package com.moovda_project.moovda.module.movie.api;

import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.entity.genre.Genre;
import com.moovda_project.moovda.module.movie.entity.genre.MovieGenre;
import com.moovda_project.moovda.module.movie.entity.staff.MovieStaff;
import com.moovda_project.moovda.module.movie.repository.MovieRepository;
import com.moovda_project.moovda.module.movie.repository.genre.GenreRepository;
import com.moovda_project.moovda.module.movie.repository.staff.StaffRepository;
import com.moovda_project.moovda.module.movie.entity.staff.Staff;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieApiService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final StaffRepository staffRepository;

    @Transactional
    public void init(String jsonData) {
        try {
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonData);

            JSONArray data = (JSONArray) jsonObj.get("Data");
            JSONObject result = (JSONObject) data.get(0);
            JSONArray resultArray = (JSONArray) result.get("Result");

            for (Object item : resultArray) {
                JSONObject movieObj = (JSONObject) item;

                Movie movie = new Movie();

                String posterUrl = movieObj.get("posters").toString().split("\\|")[0];  // 포스터는 하나만 저장
                if(posterUrl.equals("")) continue;       // 포스터가 없으면 저장하지 않는다.

                movie.setPoster(posterUrl);

                movie.setTitle(movieObj.get("title").toString());
                movie.setCountry(movieObj.get("nation").toString());

                JSONObject plotsObj = (JSONObject) movieObj.get("plots");
                JSONArray plotArray = (JSONArray) plotsObj.get("plot");
                JSONObject plotObj = (JSONObject) plotArray.get(0);
                String plotText = plotObj.get("plotText").toString();
                movie.setSummary(plotText);

                movie.setRating(movieObj.get("rating").toString());
                movie.setOpeningDate(movieObj.get("repRlsDate").toString());
                movie.setRunningTime(Integer.parseInt(movieObj.get("runtime").toString()));

                // 장르 시작
                String[] genres = movieObj.get("genre").toString().split(",");
                for(String genre : genres) {
                   MovieGenre movieGenre = new MovieGenre();

                   Genre existingGenre = genreRepository.findByName(genre);

                   if (existingGenre == null) {
                       existingGenre = new Genre();
                       existingGenre.setName(genre);
                       genreRepository.save(existingGenre);
                   }

                   movieGenre.setGenre(existingGenre);
                   movieGenre.setMovie(movie);
               }
              // 장르 끝


                // 스태프 시작
                JSONObject actorsObj = (JSONObject) movieObj.get("staffs");
                JSONArray actorArray = (JSONArray) actorsObj.get("staff");
                int directorCnt = 0;
                int actorCnt = 0;

                for(Object actorObj : actorArray) {
                    JSONObject ao = (JSONObject) actorObj;

                    MovieStaff movieStaff = new MovieStaff();

                    String position = ao.get("staffRoleGroup").toString();
                    if(!position.equals("감독") && !position.equals("출연")) {
                        continue;
                    }       // 감독이랑 출연진만 저장

                    if(position.equals("감독")) directorCnt++;
                    if(position.equals("출연")) actorCnt++;

                    movieStaff.setPosition(position);
                    movieStaff.setRole(ao.get("staffRole").toString());

                    String staffName = ao.get("staffNm").toString();

                    Staff existingStaff = staffRepository.findByName(staffName);
                    if(existingStaff==null) {
                        existingStaff = new Staff();
                        existingStaff.setName(staffName);
                        staffRepository.save(existingStaff);
                    }

                    movieStaff.setStaff(existingStaff);
                    movieStaff.setMovie(movie);

                    if(directorCnt+actorCnt==8) break;  // 최대 8명까지만 저장
                }
                // 스태프 끝

                movieRepository.save(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
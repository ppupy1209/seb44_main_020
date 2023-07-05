package com.moovda_project.moovda.movie.service;

import com.moovda_project.moovda.movie.entity.Movie;
import com.moovda_project.moovda.movie.repository.MovieRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiService {

    private final MovieRepository movieRepository;

    public ApiService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

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
                movie.setTitle(movieObj.get("title").toString());
                movie.setCountry(movieObj.get("nation").toString());

                JSONObject plotsObj = (JSONObject) movieObj.get("plots");
                JSONArray plotArray = (JSONArray) plotsObj.get("plot");
                JSONObject plotObj = (JSONObject) plotArray.get(0);
                String plotText = plotObj.get("plotText").toString();
                movie.setSummary(plotText);


                String posterUrl = movieObj.get("posters").toString().split("\\|")[0];
                movie.setPoster(posterUrl);

                movie.setRating(movieObj.get("rating").toString());
                movie.setOpeningDate(movieObj.get("repRlsDate").toString());

                movie.setRunningTime(Integer.parseInt(movieObj.get("runtime").toString()));


                movieRepository.save(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
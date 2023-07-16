package com.moovda_project.moovda.module.movie.api;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;

@Component
public class MovieDataInitializer {

    private final MovieApiService movieApiService;

    @Getter
    @Value("${api.key}")
    private String apiKey;

    public MovieDataInitializer(MovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }


    @PostConstruct
    public void callApi() throws IOException {
        for (int i = 0; i < 11; i++) {
        StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&ServiceKey=" + apiKey); /*URL*/
        urlBuilder.append("&" + URLEncoder.encode("listCount", "UTF-8") + "=" + URLEncoder.encode("15", "UTF-8"));


            if(i==0)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("박찬욱", "UTF-8"));

            if(i==1)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("봉준호", "UTF-8"));

            if(i==2)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이창동", "UTF-8"));

            if(i==3)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("폴 토마스 앤더슨", "UTF-8"));

            if(i==4)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("고레에다 히로카즈", "UTF-8"));

            if(i==5)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("데미언 셔젤", "UTF-8"));

            if(i==6)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("크리스토퍼 놀란", "UTF-8"));

            if(i==7)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조엘 코엔", "UTF-8"));

            if(i==8)
            urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("나홍진", "UTF-8"));

            if(i==9)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("하마구치 류스케", "UTF-8"));

            if(i==10)
                urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("스티븐 스필버그", "UTF-8"));


            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

            rd.close();
            conn.disconnect();
            movieApiService.init(sb.toString());
        }
    }
}

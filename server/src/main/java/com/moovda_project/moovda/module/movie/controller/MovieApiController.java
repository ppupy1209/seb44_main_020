package com.moovda_project.moovda.module.movie.controller;


import com.moovda_project.moovda.module.movie.service.MovieApiService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;


@RequiredArgsConstructor
public class MovieApiController {

    private final MovieApiService movieApiService;

    @Getter
    @Value("${api.key}")
    private String apiKey;


    // 초기 영화 데이터 구성
    public void callApi() throws IOException {
        for (int i = 0; i <26; i++) {
        StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&ServiceKey=" + apiKey); /*URL*/
        urlBuilder.append("&" + URLEncoder.encode("listCount", "UTF-8") + "=" + URLEncoder.encode("15", "UTF-8"));

            if(i==0) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("고레에다 히로카즈", "UTF-8"));
            if(i==1) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("하마구치 류스케", "UTF-8"));
            if(i==2) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("미야자키 하야오", "UTF-8"));
            if(i==3) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조엘 코엔", "UTF-8"));
            if(i==4) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("아리 에스터", "UTF-8"));
            if(i==5) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("샬롯 웰스", "UTF-8"));
//            if(i==6) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("제인 캠피온", "UTF-8"));

            if(i==7) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("크리스토퍼 놀란", "UTF-8"));
            if(i==8) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("샘 맨데스", "UTF-8"));
            if(i==9) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("파벨 포리코브스키", "UTF-8"));
            if(i==10) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("요르고스 란티모스", "UTF-8"));
            if(i==11) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("레니 에이브러햄슨", "UTF-8"));
            if(i==12) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("폴 토마스 앤더슨", "UTF-8"));
            if(i==13) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("드니 빌뇌브", "UTF-8"));
            if(i==14) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("토드 헤인즈", "UTF-8"));
            if(i==15) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("웨스 앤더슨", "UTF-8"));
            if(i==16) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("알폰소 쿠아론", "UTF-8"));
            if(i==17) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("마이크 리", "UTF-8"));
            if(i==18) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("구로사와 기요시", "UTF-8"));
            if(i==19) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이와이 슈운지", "UTF-8"));
            if(i==20) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("호소다 마모루", "UTF-8"));
            if(i==21) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("요시다 다이하치", "UTF-8"));
            if(i==22) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이누도 잇신", "UTF-8"));
            if(i==23) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("에드가 라이트", "UTF-8"));
            if(i==24) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("리들리 스콧", "UTF-8"));
            if(i==25) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("매튜 본", "UTF-8"));





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
            System.out.println("i =" + i);
            movieApiService.init(sb.toString());
        }
    }
}

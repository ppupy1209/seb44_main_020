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

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieApiController {

    private final MovieApiService movieApiService;

    @Getter
    @Value("${api.key}")
    private String apiKey;

    // 초기 영화 데이터 구성
    @GetMapping("/api")
    public void callApi() throws IOException {
        for (int i = 0; i < 46; i++) {
        StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&ServiceKey=" + apiKey); /*URL*/
        urlBuilder.append("&" + URLEncoder.encode("listCount", "UTF-8") + "=" + URLEncoder.encode("15", "UTF-8"));

            if(i==0) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("박찬욱", "UTF-8"));

            if(i==1) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("봉준호", "UTF-8"));

            if(i==2) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이창동", "UTF-8"));

            if(i==3) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("폴 토마스 앤더슨", "UTF-8"));

            if(i==4) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("고레에다 히로카즈", "UTF-8"));

            if(i==5) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("데미언 셔젤", "UTF-8"));

            if(i==6) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("크리스토퍼 놀란", "UTF-8"));

            if(i==7) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조엘 코엔", "UTF-8"));

            if(i==8) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("나홍진", "UTF-8"));

            if(i==9) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("하마구치 류스케", "UTF-8"));

            if(i==10) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("스티븐 스필버그", "UTF-8"));

            if(i==11) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("마틴 스코세이지", "UTF-8"));

            if(i==12) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("그레타 거윅", "UTF-8"));

            if(i==13) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("존 카니", "UTF-8"));

            if(i==14) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("윤종빈", "UTF-8"));

            if(i==15) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("쿠엔틴 타란티노", "UTF-8"));

            if(i==16) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("아리 에스터", "UTF-8"));

            if(i==17) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("알폰소 쿠아론", "UTF-8"));

            if(i==18) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("요르고스 란티모스", "UTF-8"));

            if(i==19) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("드니 빌뇌브", "UTF-8"));

            if(i==20) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("클린트 이스트우드", "UTF-8"));

            if(i==21) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("구로사와 기요시", "UTF-8"));

            if(i==22) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("토드 헤인즈", "UTF-8"));

            if(i==23) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("미야자키 하야오", "UTF-8"));

            if(i==24) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("허진호", "UTF-8"));

            if(i==25) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("대런 아로노프스키", "UTF-8"));

            if(i==26) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("리처드 링클레이터", "UTF-8"));

            if(i==27) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이와이 슈운지", "UTF-8"));

            if(i==28) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("데이비드 핀처", "UTF-8"));

            if(i==29) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("웨스 앤더슨", "UTF-8"));

            if(i==30) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("홍상수", "UTF-8"));

            if(i==31) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("기예르모 델 토로", "UTF-8"));

            if(i==32) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("샘 맨데스", "UTF-8"));

            if(i==33) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조던 필", "UTF-8"));

            if(i==34) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("코고나다", "UTF-8"));

            if(i==35) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("토드 필립", "UTF-8"));

            if(i==36) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("파벨 포리코브스키", "UTF-8"));

            if(i==37) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("우디 앨런", "UTF-8"));

            if(i==38) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("브라이언 싱어", "UTF-8"));

            if(i==39) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("리차드 커티스", "UTF-8"));

            if(i==40) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("제임스 카메론", "UTF-8"));

            if(i==41) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("이안", "UTF-8"));

            if(i==42) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조 루소", "UTF-8"));

            if(i==43) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("사라 폴리", "UTF-8"));

            if(i==44) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("제임스 건", "UTF-8"));

            if(i==45) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("제임스 완", "UTF-8"));








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

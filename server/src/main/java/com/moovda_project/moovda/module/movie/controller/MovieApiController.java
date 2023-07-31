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
        for (int i = 0; i <26; i++) {
        StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&ServiceKey=" + apiKey); /*URL*/
        urlBuilder.append("&" + URLEncoder.encode("listCount", "UTF-8") + "=" + URLEncoder.encode("15", "UTF-8"));

            if(i==0) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("고레에다 히로카즈", "UTF-8"));
            if(i==1) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("하마구치 류스케", "UTF-8"));
            if(i==2) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("미야자키 하야오", "UTF-8"));
            if(i==3) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("조엘 코엔", "UTF-8"));
            if(i==4) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("아리 에스터", "UTF-8"));
            if(i==5) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("샬롯 웰스", "UTF-8"));
            if(i==6) urlBuilder.append("&" + URLEncoder.encode("director", "UTF-8") + "=" + URLEncoder.encode("제인 캠피온", "UTF-8"));

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











//            if(i==0) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("로버트 다우니 주니어", "UTF-8"));
//            if(i==1) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("톰 크루즈", "UTF-8"));
//            if(i==2) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("다니엘 래드클리프", "UTF-8"));
//            if(i==3) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("유해진", "UTF-8"));
//            if(i==4) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("송강호", "UTF-8"));
//            if(i==5) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("티모시 찰라멧", "UTF-8"));
//            if(i==6) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("틸다 스윈튼", "UTF-8"));
//            if(i==7) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("미셸 윌리엄스", "UTF-8"));
//            if(i==8) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("매즈 미켈슨", "UTF-8"));
//            if(i==9) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("제이크 질렌할", "UTF-8"));
//            if(i==10) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("짐 캐리", "UTF-8"));
//            if(i==11) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("레오나르도 디카프리오", "UTF-8"));
//            if(i==12) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("브래드 피트", "UTF-8"));
//            if(i==13) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("휴 잭맨", "UTF-8"));
//            if(i==14) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("벤 애플랙", "UTF-8"));
//            if(i==15) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("천우희", "UTF-8"));
//            if(i==16) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("하정우", "UTF-8"));
//            if(i==17) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("이제훈", "UTF-8"));
//            if(i==18) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("윌 스미스", "UTF-8"));
//            if(i==19) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("키아누 리브스", "UTF-8"));
//            if(i==20) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("양자경", "UTF-8"));
//            if(i==21) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("전도연", "UTF-8"));
//            if(i==22) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("이정재", "UTF-8"));
//
//            if(i==23) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("크리스틴 스튜어트", "UTF-8"));
//            if(i==24) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("이병헌", "UTF-8"));
//            if(i==25) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("베네딕 컴버배치", "UTF-8"));
//            if(i==26) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("모건 프리먼", "UTF-8"));
//            if(i==27) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("콜린 퍼스", "UTF-8"));
//            if(i==28) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("안소니 홉킨스", "UTF-8"));
//            if(i==29) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("레이첼 맥아담스", "UTF-8"));
//            if(i==30) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("스티브 카렐", "UTF-8"));
//            if(i==31) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("다니엘 크레이그", "UTF-8"));
//            if(i==32) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("라이언 고슬링", "UTF-8"));
//            if(i==33) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("제시 아이젠버그", "UTF-8"));
//
//            if(i==34) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("크리스 에반스", "UTF-8"));
//            if(i==35) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("스칼렛 요한슨", "UTF-8"));
//            if(i==36) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("양조위", "UTF-8"));
//            if(i==37) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("이즈라 밀러", "UTF-8"));
//            if(i==38) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("유재명", "UTF-8"));
//            if(i==39) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("필립 세이모어 호프만", "UTF-8"));
//            if(i==40) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("조승우", "UTF-8"));
//            if(i==41) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("조디 포스터", "UTF-8"));
//            if(i==42) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("엠마 스톤", "UTF-8"));
//            if(i==43) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("프란시스 맥도먼드", "UTF-8"));
//            if(i==44) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("일라이저 우드", "UTF-8"));
//            if(i==45) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("알 파치노", "UTF-8"));
//            if(i==46) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("우마 서먼", "UTF-8"));
//            if(i==47) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("유아인", "UTF-8"));
//            if(i==48) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("황정민", "UTF-8"));
//            if(i==49) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("설경구", "UTF-8"));
//            if(i==50) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("마동석", "UTF-8"));
//            if(i==51) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("이선균", "UTF-8"));
//
//            if(i==52) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("공유", "UTF-8"));
//            if(i==53) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("정유미", "UTF-8"));
//            if(i==54) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("최민식", "UTF-8"));
//            if(i==55) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("크리스찬 베일", "UTF-8"));
//            if(i==56) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("나탈리 포트만", "UTF-8"));
//            if(i==57) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("조승우", "UTF-8"));
//            if(i==58) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("오달수", "UTF-8"));
//            if(i==59) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("맷 데이먼", "UTF-8"));
//            if(i==60) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("톰 하디", "UTF-8"));
//            if(i==61) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("에단 호크", "UTF-8"));
//            if(i==62) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("김윤석", "UTF-8"));
//            if(i==63) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("레미 맬렉", "UTF-8"));
//            if(i==64) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("애드리엔 브로디", "UTF-8"));
//            if(i==65) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("제시카 차스테인", "UTF-8"));
//            if(i==66) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("제니퍼 로렌스", "UTF-8"));
//            if(i==67) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("메릴 스트립", "UTF-8"));
//            if(i==68) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("베리 케오간", "UTF-8"));
//            if(i==69) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("전지현", "UTF-8"));
//            if(i==70) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("손예진", "UTF-8"));
//            if(i==71) urlBuilder.append("&" + URLEncoder.encode("actor", "UTF-8") + "=" + URLEncoder.encode("주드 로", "UTF-8"));



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

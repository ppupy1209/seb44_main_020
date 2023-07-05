import React from "react";
import * as S from './MainPage.styled'; 
import { MainPoster } from "../../../components/MainPoster/MainPoster";
import MainCarousel from "../../../components/MainCarousel/MainCarousel";
import {ReactComponent as Logo} from "../../../assets/logo-moovda.svg";

export function MainPage() {
const data=[{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
title:'엘리멘탈',
star:5},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
title:'스파이더맨: 어크로스 더 유니버스 포토',
star:3},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
title:'범죄도시3',
star:4.5},{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
title:'엘리멘탈',
star:5},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
title:'스파이더맨: 어크로스 더 유니버스 포토',
star:3},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
title:'범죄도시3',
star:4.5}];

const posters=data.map((poster,index)=>(
  <MainPoster key={index} data={poster} isWatched={false} isToWatch={false}/>
));
  return(
    <S.Container>
      <S.Left>
        <S.TextContainer>
        <S.SmallText>
          <S.TextBox>아직도 해리포터가 인생영화인가요?</S.TextBox>
          <S.TextBox>새로운 인생 영화를 찾고 계신가요?</S.TextBox>
          <S.TextBox>많은 사람들과 공유하고픈 영화 이야기가 있나요?</S.TextBox>
        </S.SmallText>
        <S.MidText>
          세상의 영화가 다 있는 <span>뭅다</span>에서 <span>묻다</span>
        </S.MidText>
        <S.LargeText>
<div><Logo /> 에서 새로운</div>
<div>영화 세상을 경험하세요</div>
        </S.LargeText>
        </S.TextContainer>
      </S.Left>
      <S.Right>
        <S.Poster><MainCarousel props={posters} /></S.Poster></S.Right>
      </S.Container>
  );
}


import React from "react";
import * as S from './MainPage.styled'; 
import { MainPoster } from "../../../components/MainPoster/MainPoster";


export function MainPage() {
const data=[{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
title:'엘리멘탈'},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
title:'스파이더맨: 어크로스 더 유니버스 포토'},
{img:'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
title:'범죄도시3'}];

const posters=data.map((poster,index)=>(
  <MainPoster data={poster} key={index} />
));
  return(
  <S.Posters>{posters}</S.Posters>
  );
}


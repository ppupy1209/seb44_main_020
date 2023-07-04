import React from 'react';
import * as S from './MainPoster.styled';
// import { useNavigate } from 'react-router-dom';

interface Props{
    data:{
    img:string;
    title:string;
}
}

export function MainPoster({data}:Props) {
    // const navigate=useNavigate();
    // const goToMovieDetail = () => {
    //     const movieId = data.movie-id;
    //     navigate(`/movies/${movieId}`);
    //   };
    
    return <S.Container> {/*onClickt시 goToMovieDetail */}
            <S.PosterImg src={data.img} alt="영화포스터" />
            <S.Title><S.TitleText>{data.title}</S.TitleText></S.Title>
    </S.Container>;
}
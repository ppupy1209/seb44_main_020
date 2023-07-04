import React from 'react';
import * as S from './MainPoster.styled';

interface Props{
    data:{
    img:string;
    title:string;
}
}

export function MainPoster({data}:Props) {
    return <S.Container>
            <S.PosterImg src={data.img} alt="영화포스터" />
            <S.Title><S.TitleText>{data.title}</S.TitleText></S.Title>
    </S.Container>;
}
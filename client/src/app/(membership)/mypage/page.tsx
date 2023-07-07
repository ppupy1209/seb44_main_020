'use client'
// import { useState, useEffect } from 'react';
// import { useState, useEffect,useCallback } from 'react';
// import { useNavigate } from 'react-router-dom';
// import axios from 'axios';
import { MainPoster } from '@/components/MainPoster/MainPoster';
import {data} from './dummydata'
import * as S from './page.styled';
import theme from '@/components/MainPoster/theme';
import { ThemeProvider } from 'styled-components';

  

export default function MyPage() {
    //const navigate=useNavigate();
    // const [data, setData]=useState([]);

  // useEffect(()=>{
  //   axios.get('주소/members/${member_id}')
  //   .then((res)=>{
  //     setData(res.data);
  //   }).catch((error)=>{
  //     console.log(error.message);
  //   });
  // },[]);


//회원삭제
  // const handleDelete = useCallback(() => {
  //   if (window.confirm('삭제하시겠습니까?')) {
  //     axios
  //       .delete(
  //         `주소/members/${member_id}`,
  //         {
  //           headers: {
  //            //권한헤더
  //           },
  //         }
  //       )
  //       .then(() => {
  //       //로그아웃
  //       alert('회원 정보가 삭제되었습니다.');
  //       navigate('/');
  //       })
  //       .catch((error) => {
  //         console.log( error.message);
  //       });
  //   } 
  // }, [memberId]);

const toWatchlist =data.toWatch.map((list)=>(
    <ThemeProvider theme={theme.myPage}>
<MainPoster key={list.movie_id} data={list} isWatched={false} isToWatch={true}/> 
</ThemeProvider>
));

const watchedList=data.watched.map((list)=>(
    <ThemeProvider theme={theme.myPage}>
    <MainPoster key={list.movie_id} data={list} isWatched={true} isToWatch={false}/> 
    </ThemeProvider>
))

  return <S.Wrapper>
  <S.PageTitle>
    my page
  </S.PageTitle>
  <S.Container>
    <S.Nickname>{data.nickname} 님의 리스트</S.Nickname>
    <S.SectionWrapper>
    <S.Section>
    <S.SectionTitle>볼 영화</S.SectionTitle>
    <S.SectionContent>
      <S.MovieList hasContent={toWatchlist.length > 0}>{toWatchlist}</S.MovieList>
    </S.SectionContent>
    </S.Section>
    <S.Section>
    <S.SectionTitle>본 영화</S.SectionTitle>
    <S.SectionContent>
      <S.MovieList hasContent={toWatchlist.length > 0}>{watchedList}</S.MovieList>
    </S.SectionContent>
    </S.Section>
    <S.Section>
    <S.SectionTitle>계정 관리</S.SectionTitle>
    <S.SectionContent>
    <S.DeleteContainter>
      <S.Text>회원 삭제</S.Text>
      <S.DeleteBtn>삭제하기</S.DeleteBtn>  {/*onClick시 handleDelete*/}
      </S.DeleteContainter>
      </S.SectionContent>
    </S.Section>
    </S.SectionWrapper>
  </S.Container>
</S.Wrapper>;
}

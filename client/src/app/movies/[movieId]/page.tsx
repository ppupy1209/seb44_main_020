'use client'
import { useState } from 'react';
import * as S from './page.styled';
import Pen from '@/assets/penIcon.svg'
import Plus from '@/assets/plus.svg'
import { StaffBox } from '@/components/StaffBox/StaffBox';
import { Comment } from '@/components/CommentBox/Comment';
import {data} from './dummydata';
import { StarrateShow } from '@/components/Starrate/StarrateShow';
import { CommentModal } from '@/components/CommentModal/Modal';
import {useSelector,useDispatch } from 'react-redux';
import { RootState } from '@/redux/store';
import {open} from '@/redux/features/commentSlice'



export default function MyPage() {
const dispatch=useDispatch();
const openState=useSelector((state:RootState)=>state.comment.isOpen);

const handleOpen=()=>{
    dispatch(open())
}
    
    const member_id=1;
    const found= data.comments.find(e=>e.member_id===member_id);

    const starAvg= data.starAvg.toFixed(1);

    const genre=data.genre.map((item)=>(
        item.name
    ))

    function changeDateFormat(date:number){
        const dateString=date.toString();
        const year =dateString.slice(0,2);
        const month =dateString.slice(2,4);
        const day =dateString.slice(4,6);

        const formattedDate=`20${year}.${month}.${day}`

        return formattedDate;
    }

    const staffList= data.staff.map((list,index)=>(
        <StaffBox key={index} data={list} />
    ))

    const commentList=data.comments.map((list)=>(
    <Comment key={list.comment_id} data={list} />
    ))

    return(
        <S.Wrapper>
            {openState? <CommentModal />:''}
            <S.MovieInfoWrapper>
                <S.PosterStar>
                    <S.PosterImg src={data.poster} alt="영화 포스터" />
                    <S.MyStar>
                        <S.MystarIcon><StarrateShow rate={found?found.star:0} /></S.MystarIcon> 
                        <S.MyStarNum>{found?found.star.toFixed(1):0.0}</S.MyStarNum></S.MyStar>
                </S.PosterStar>
                <S.MovieInfo>
                    <S.StarAvg>
                        <S.avNum>{starAvg}</S.avNum>
                        <S.avText>평균 별점</S.avText>
                    </S.StarAvg>
                    <S.Title>{data.title}</S.Title>
                    <S.DetailWrapper>
                    <S.DateAndCountry>{changeDateFormat(data.openingDate)} • {data.country}</S.DateAndCountry>
                    <S.Genre>{genre.join(' / ')}</S.Genre>
                    <S.RunningTime>{data.runningTime}분</S.RunningTime>
                    </S.DetailWrapper>
                    <S.BtnWrapper>
                        <S.ToWatchBtn onClick={handleOpen} ><span><Pen fill="#ffffff"/></span><span>별점・코멘트</span> </S.ToWatchBtn>
                        <S.WatchedBtn><span><Plus fill="#ffffff"/></span><span>보고싶어요</span></S.WatchedBtn>
                    </S.BtnWrapper>

                    <S.Summary>
                        {data.summary}
                    </S.Summary>
                </S.MovieInfo>
            </S.MovieInfoWrapper>
            <S.SectionWrapper>
                <S.SectionContainer>
                <S.SectionTitle>출연/제작</S.SectionTitle>
                <S.StaffList>{staffList}</S.StaffList>
                </S.SectionContainer>
            </S.SectionWrapper>
            <S.SectionWrapper>
            <S.SectionContainer>
                <S.SectionTitle>코멘트</S.SectionTitle>
                <S.CommentList>{commentList}</S.CommentList>
                </S.SectionContainer>
            </S.SectionWrapper>
        </S.Wrapper>
    )
}
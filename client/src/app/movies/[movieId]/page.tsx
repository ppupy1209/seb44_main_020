'use client'
import * as S from './page.styled';
import Pen from '@/assets/penIcon.svg'
import Plus from '@/assets/plus.svg'
import { StaffBox } from '@/components/StaffBox/StaffBox';
import { Comment } from '@/components/CommentBox/Comment';
import {data} from './dummydata';
import { StarrateShow } from '@/components/Starrate/StarrateShow';


export default function MyPage() {
    
    const member_id=1;
    const found= data.comments.find(e=>e.member_id===member_id);

    const starAvg= data.starAvg.toFixed(1);

    function changeDateFormat(date:number){
        const dateString=date.toString();
        const year =dateString.slice(0,2);
        const month =dateString.slice(2,4);
        const day =dateString.slice(4,6);

        const formattedDate=`20${year}.${month}.${day}`

        return formattedDate;
    }

    return(
        <S.Wrapper>
            <S.MovieInfoWrapper>
                <S.PosterStar>
                    <S.PosterImg src={data.poster} alt="영화 포스터" />
                    <S.MyStar><StarrateShow rate={found?found.star:0} /></S.MyStar>
                </S.PosterStar>
                <S.MovieInfo>
                    <S.StarAvg>
                        <S.avNum>{starAvg}</S.avNum>
                        <S.avText>평균 별점</S.avText>
                    </S.StarAvg>
                    <S.Title>{data.title}</S.Title>
                    <S.DetailWrapper>
                    <S.DateAndCountry>{changeDateFormat(data.openingDate)} • {data.country}</S.DateAndCountry>
                    <S.Genre>애니메이션 / 모험 / 판타지 / SF / 로맨스</S.Genre>
                    <S.RunningTime>93분</S.RunningTime>
                    </S.DetailWrapper>
                    <S.BtnWrapper>
                        <S.ToWatchBtn><span><Pen fill="#ffffff"/></span><span>별점・코멘트</span> </S.ToWatchBtn>
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
                <S.StaffList><StaffBox /></S.StaffList>
                </S.SectionContainer>
            </S.SectionWrapper>
            <S.SectionWrapper>
            <S.SectionContainer>
                <S.SectionTitle>코멘트</S.SectionTitle>
                <S.CommentList><Comment /><Comment /><Comment /><Comment /></S.CommentList>
                </S.SectionContainer>
            </S.SectionWrapper>
        </S.Wrapper>
    )
}
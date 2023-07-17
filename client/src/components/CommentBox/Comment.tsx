'use client'
import axios from 'axios';
import * as S from './Comment.styled';
import Heart from '@/assets/heart.svg';
import Fullstar from '@/assets/fullStar.svg'
import { useCallback } from 'react';

interface Props {
    data: {
      memberId?:number;
      commentId?: number;
      nickname?: string;
      content?:string;
      star?:number;
      likeCount?:number;
      createdAt?:string;
    };
  }

export function Comment({data}:Props) {

const {commentId}=data

const handleLike=useCallback(()=>{
    axios
    .post(
        `/comments/${commentId}/likes`,
        {},
        // {headers}
    )
    .catch((error)=>{
        console.log('Error:', error.message);
    });
    //에러처리
    },[commentId])

    return(
        <S.Container>
            <S.Wrapper>
                <S.Top>
                    <S.Left>
                        <S.Nickname>{data.nickname}</S.Nickname>
                        <S.CreatedAt>(작성시간)</S.CreatedAt>
                    </S.Left>
                    <S.Right>
                        <S.StarIcon><Fullstar /></S.StarIcon>
                        <S.starrate>{data.star?.toFixed(1)}</S.starrate></S.Right>
                </S.Top>
                <S.Content>
                    {data.content}
                </S.Content>
                <S.Bottom>
                    <S.LikeWrapper>
                    <S.LikeBtn onClick={handleLike}><Heart width="20" height="20" fill="#E7E7E7"/></S.LikeBtn>
                    <S.LikeCount>{data.likeCount}</S.LikeCount>
                    </S.LikeWrapper>
                    <S.BtnWrapper>
                    <S.EditBtn>수정</S.EditBtn>
                    <S.DeleteBtn>삭제</S.DeleteBtn>
                    </S.BtnWrapper>
                </S.Bottom>
            </S.Wrapper>
        </S.Container>
    )
}
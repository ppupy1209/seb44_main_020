'use client'

import * as S from './Comment.styled';
import Heart from '@/assets/heart.svg';

export function Comment() {
    return(
        <S.Container>
            <S.Wrapper>
                <S.Top>
                    <S.Left>
                        <S.Nickname>닉네임</S.Nickname>
                        <S.CreatedAt>작성시간</S.CreatedAt>
                    </S.Left>
                    <S.Right>별점</S.Right>
                </S.Top>
                <S.Content>
                    내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.
                </S.Content>
                <S.Bottom>
                    <S.LikeWrapper>
                    <S.LikeBtn><Heart width="20" height="20" fill="#E7E7E7"/></S.LikeBtn>
                    <S.LikeCount>1</S.LikeCount>
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
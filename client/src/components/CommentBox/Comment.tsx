'use client';
import { useCallback, useState } from 'react';
import { useRouter } from 'next/navigation';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import { open, getContent, getCommentId } from '@/redux/features/commentSlice';
import { selectStar } from '@/redux/features/starSlice';
import { handleDelete } from '@/api/axiosHandler';
import Heart from '@/assets/heart.svg';
import Fullstar from '@/assets/fullStar.svg';
import * as S from './Comment.styled';

interface Props {
  data: {
    memberId?: number;
    commentId?: number;
    nickname?: string;
    content?: string;
    star?: number;
    likeCount?: number;
    createdAt?: string;
  };
}

export function Comment({ data }: Props) {
  const router = useRouter();
  const [likeTotal, setLikeTotal] = useState<number | undefined>(
    data.likeCount,
  );
  const [liked, setLiked] = useState(false);
  const dispatch = useDispatch();
  const userId = useSelector((state: RootState) => state.auth.memberId);
  const { commentId, memberId } = data;

  const handleLike = useCallback(() => {
    if (userId) {
      axios
        .post(
          `서버url/comments/${commentId}/likes`,
          {},
          {
            headers: {
              'Content-Type': 'application/json',
              Authorization: localStorage.getItem('Authorization'),
            },
          },
        )
        .then(() => {
          //좋아요 상태가 있어야 반영 가능할듯...?
          if (liked === false) {
            likeTotal && setLikeTotal(likeTotal + 1);
            setLiked(true);
          } else {
            if (likeTotal && likeTotal > 0) {
              setLikeTotal(likeTotal - 1);
              setLiked(false);
            }
          }
        })
        .catch((error) => {
          console.log('Error:', error.message);
        });
    } else {
      alert('로그인 후 좋아요가 가능합니다');
    }
  }, [commentId, liked, likeTotal]);

  const handleDeleteComment = () => {
    handleDelete(`/comments/${commentId}`);
  };

  //수정 버튼 클릭
  const handleModalOpen = () => {
    dispatch(open());
    dispatch(getCommentId(data.commentId));
    dispatch(getContent(data.content));
    if (data.star) {
      dispatch(selectStar(data.star));
    }
  };

  const handleProfile = () => {
    router.push(`/mypage/${memberId}`);
  };

  const CommentDate = () => {
    if (data.createdAt) {
      const milliSeconds: number =
        new Date().getTime() - new Date(data.createdAt).getTime();
      const seconds: number = milliSeconds / 1000;

      if (seconds < 60) return `방금 전`;
      const minutes: number = seconds / 60;
      if (minutes < 60) return `${Math.floor(minutes)}분 전`;
      const hours: number = minutes / 60;
      if (hours < 24) return `${Math.floor(hours)}시간 전`;
      const days: number = hours / 24;
      if (days < 7) return `${Math.floor(days)}일 전`;
      const weeks: number = days / 7;
      if (weeks < 5) return `${Math.floor(weeks)}주 전`;
      const months: number = days / 30;
      if (months < 12) return `${Math.floor(months)}개월 전`;
      const years: number = days / 365;
      return `${Math.floor(years)}년 전`;
    }
    return '';
  };

  return (
    <S.Container>
      <S.Wrapper>
        <S.Top>
          <S.Left>
            <S.Nickname onClick={handleProfile}>{data.nickname}</S.Nickname>
            <S.CreatedAt>{CommentDate()}</S.CreatedAt>
          </S.Left>
          <S.Right>
            <S.StarIcon>
              <Fullstar />
            </S.StarIcon>
            <S.starrate>{data.star?.toFixed(1)}</S.starrate>
          </S.Right>
        </S.Top>
        <S.Content>{data.content}</S.Content>
        <S.Bottom>
          <S.LikeWrapper>
            <S.LikeBtn onClick={handleLike}>
              <Heart width="20" height="20" />
            </S.LikeBtn>
            <S.LikeCount>{likeTotal}</S.LikeCount>
          </S.LikeWrapper>
          {userId === memberId ? (
            <S.BtnWrapper>
              <S.EditBtn onClick={handleModalOpen}>수정</S.EditBtn>
              <S.DeleteBtn onClick={handleDeleteComment}>삭제</S.DeleteBtn>
            </S.BtnWrapper>
          ) : (
            ''
          )}
        </S.Bottom>
      </S.Wrapper>
    </S.Container>
  );
}

'use client';

import * as S from '@/components/Question/AnswerBox.styled';
import {
  AnswerType,
  deleteAnswerList,
  editAnswerList,
} from '@/redux/features/answerListSlice';
import Link from 'next/link';
import { useParams } from 'next/navigation';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { SearchMovieList } from './Modal';
import SearchBox from './SearchBox';

interface AnswerBoxProps {
  answer: AnswerType;
}

const AnswerBox = ({ answer }: AnswerBoxProps) => {
  const [isEditing, setIsEditing] = useState<Boolean>(false);
  const dispatch = useDispatch();

  const onEditClick = () => {
    setIsEditing((prev) => !prev);
  };

  const onSubmit = ({
    selectedMovie,
    textValue,
  }: {
    selectedMovie?: SearchMovieList;
    textValue: string;
  }) => {
    dispatch(
      editAnswerList({
        answerId: answer.answerId,
        nickname: answer.nickname,
        content: textValue,
        movie: {
          title: selectedMovie?.title,
          poster: selectedMovie?.poster,
        },
      }),
    );
    // TODO: post 요청
    setIsEditing(false);
  };

  return (
    <S.AnswerBoxGroup>
      <S.AnswerBox>
        <AnswerBoxTop onEditClick={onEditClick} answer={answer} />
        <S.AnswerBoxMid>
          {isEditing ? (
            <SearchBox
              onSubmit={onSubmit}
              defaultValue={{
                movieId: '',
                content: answer.content,
                title: answer.movie.title,
                poster: answer.movie.poster,
                pageInfo: {
                  currentPage: 0,
                  pageSize: 0,
                  total: 0,
                },
              }}
            />
          ) : (
            <S.ContentBox>
              <div>{answer.content}</div>
              <AnswerBoxBottom answer={answer} />
            </S.ContentBox>
          )}
        </S.AnswerBoxMid>
      </S.AnswerBox>
    </S.AnswerBoxGroup>
  );
};

interface AnswerBoxTopProps {
  onEditClick: () => void;
  answer: AnswerType;
}

const AnswerBoxTop = ({ onEditClick, answer }: AnswerBoxTopProps) => {
  const dispatch = useDispatch();

  const handleDeleteAnswer = () => {
    dispatch(deleteAnswerList(answer));
  };

  return (
    <S.BoxTop>
      <S.LeftBox>
        {/* // TODO: 회원 === 글작성자 -> 본인 mypage || 회원 != 글작성자 -> 글작성자 mypage */}
        <Link href={'/mypage'}>
          <S.Nickname>{answer.nickname}</S.Nickname>
        </Link>
        <S.Time>{AnswerDate(new Date())}</S.Time>
      </S.LeftBox>
      <S.RightBox>
        <S.EditBtn onClick={onEditClick}>수정</S.EditBtn>
        <S.DeleteBtn onClick={handleDeleteAnswer}>삭제</S.DeleteBtn>
      </S.RightBox>
    </S.BoxTop>
  );
};

const AnswerDate = (createdAt: Date): string => {
  const milliSeconds: number = new Date().getTime() - createdAt.getTime();
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
};

interface AnswerBoxBottomProps {
  answer: AnswerType;
}

const AnswerBoxBottom = ({ answer }: AnswerBoxBottomProps) => {
  const { movieId } = useParams();
  return (
    <Link href={`/movie/${movieId}`}>
      <S.BoxBottom>
        <S.SelectedMovieBox>
          <S.Poster>{answer.movie.poster}</S.Poster>
          <S.MovieInfo>
            <S.MovieTitle>{answer.movie.title}</S.MovieTitle>
            <S.MovieReleaseDate>{answer.movie.prodYear}</S.MovieReleaseDate>
          </S.MovieInfo>
        </S.SelectedMovieBox>
      </S.BoxBottom>
    </Link>
  );
};

export default AnswerBox;

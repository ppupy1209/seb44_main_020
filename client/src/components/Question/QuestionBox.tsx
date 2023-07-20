'use client';

import { QuestionItem } from '@/app/questions/page';
import * as S from '@/components/Question/QuestionBox.styled';
import { faCommentDots } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Link from 'next/link';

interface QuestionBoxProps {
  question: QuestionItem;
}

export const QuestionBox = ({ question }: QuestionBoxProps) => {
  const questionId = question.questionId;

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

  return (
    // TODO: 해당 questionId값 페이지로 이동
    <Link href={`/questions/${questionId}`}>
      <S.QuestionBoxGroup>
        <S.QuestionBox>
          <S.BoxTop>
            <S.Name>{question.title}</S.Name>
          </S.BoxTop>
          <S.BoxMiddle>
            <S.Title>{question.content}</S.Title>
          </S.BoxMiddle>
          <S.BoxBottom>
            <S.Comment>
              <FontAwesomeIcon
                icon={faCommentDots}
                color="white"
                width={'14px'}
              />
              <S.CommentCount>{question.answerCount}</S.CommentCount>
            </S.Comment>
            <S.Time>{AnswerDate(new Date())}</S.Time>
          </S.BoxBottom>
        </S.QuestionBox>
      </S.QuestionBoxGroup>
    </Link>
  );
};

'use client';

import * as S from '@/app/questions/[questionId]/page.styled';
import { QuestionBox } from '@/components/Question/QuestionBox';
import { WebEditor } from '@/components/Question/Webeditor';
import { useRouter } from 'next/navigation';
import { useState } from 'react';

const QuestionListPage = () => {
  return (
    <S.PageGroup>
      <AskBox />
      <QuestionBox />
      <AnswerCreateGroup />
    </S.PageGroup>
  );
};

const AskBox = () => {
  return (
    <S.AskBox>
      <BoxTop />
      <S.BoxTitle>제목</S.BoxTitle>
      <S.BoxMid>
        <S.ContentBox>
          <div>내용</div>
        </S.ContentBox>
      </S.BoxMid>
    </S.AskBox>
  );
};

const BoxTop = () => {
  const router = useRouter();

  return (
    <S.BoxTop>
      <S.LeftBox>
        <S.Nickname
          onClick={() =>
            // TODO: 회원 === 글작성자 => 본인 mypage || 회원 != 글작성자 => 글작성자 mypage
            router.push('/mypage')
          }
        >
          닉네임
        </S.Nickname>
        <S.Time>{AnswerDate(new Date())}</S.Time>
      </S.LeftBox>
      <S.RightBox>
        <S.EditBtn>수정</S.EditBtn>
        <S.DeleteBtn>삭제</S.DeleteBtn>
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

const AnswerCreateGroup = () => {
  const [contentValue, setContentValue] = useState<string>('');

  return (
    <S.PageBottom>
      <S.AnswerCreateBox>
        <WebEditor value={contentValue} setValue={setContentValue} />
      </S.AnswerCreateBox>
      <S.ButtonBox>
        <S.Button>추천하기</S.Button>
      </S.ButtonBox>
    </S.PageBottom>
  );
};

export default QuestionListPage;

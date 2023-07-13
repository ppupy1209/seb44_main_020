'use client';

import { useCallback, useState } from 'react';
import * as S from '@/app/questions/page.styled';
import { QuestionBox } from '@/components/Question/QuestionBox';
import { usePathname, useRouter, useSearchParams } from 'next/navigation';

export interface QuestionItem {
  id: string;
}

const QuestionListPage = () => {
  const [questions] = useState<QuestionItem[]>([]);

  return (
    <S.TalkPage>
      <S.TalkPageBox>
        <S.Header>
          <S.Title>MoovTalk</S.Title>
          <S.ButtonBox>
            <S.Button>추천 받기</S.Button>
          </S.ButtonBox>
        </S.Header>
        <S.QuestionBox>
          <QuestionBoxes questions={questions} />
        </S.QuestionBox>
        {/* <Pagination totalElements={15} pages={3} /> */}
      </S.TalkPageBox>
    </S.TalkPage>
  );
};

interface QuestionBoxesProps {
  questions: QuestionItem[];
}

const QuestionBoxes = ({ questions }: QuestionBoxesProps) => {
  return (
    <ul>
      {questions.map((question) => (
        <QuestionBox key={question.id} question={question} />
      ))}
      {/* <QuestionBox />
      <QuestionBox />
      <QuestionBox />
      <QuestionBox />
      <QuestionBox /> */}
    </ul>
  );
};

interface PaginationProps {
  totalElements: number;
  size: number;
}

const Pagination = ({ totalElements, size }: PaginationProps) => {
  const searchParams = useSearchParams()!;
  const router = useRouter();
  const pathname = usePathname();
  // button active 상태 확인용
  const page = searchParams.get('page') ?? 1;

  const onPaginate = useCallback(
    (value: number) => {
      const params = new URLSearchParams(searchParams.toString());
      params.set('page', value.toString());

      return params.toString();
    },
    [searchParams],
  );

  const pageNumbers = Array.from(
    { length: Math.ceil(totalElements / size) },
    (_, i) => i + 1,
  );

  return (
    <section>
      <div>
        {pageNumbers.map((pageNumber) => (
          <div key={pageNumber}>
            <button
              onClick={() => {
                router.push(pathname + '?' + onPaginate(pageNumber));
              }}
            >
              {pageNumber}
            </button>
          </div>
        ))}
      </div>
    </section>
  );
};

export default QuestionListPage;

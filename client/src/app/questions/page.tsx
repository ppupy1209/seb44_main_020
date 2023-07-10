'use client';

import { useState } from 'react';
import * as S from '@/app/questions/page.styled';
import { QuestionBox } from '@/components/Question/QuestionBox';

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
        {/* <Pagination totalPage={15} pages={3} /> */}
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
      {/* {questions.map((question) => (
        <QuestionBox key={question.id} question={question} />
      ))} */}
      <QuestionBox />
      <QuestionBox />
      <QuestionBox />
      <QuestionBox />
      <QuestionBox />
    </ul>
  );
};

// interface PaginationProps {
//   totalPage: number;
//   pages: number;
// }

// const Pagination = ({ totalPage, pages }: PaginationProps) => {
//   const [searchParams, setSearchParams] = useSearchParams();
//   const page = searchParams.get('page') ?? 1;

//   const onPaginate = (pageNumber: number) => {
//     setSearchParams({
//       page: pageNumber.toString(),
//     });
//   };

//   const pageNumbers = Array.from(
//     { length: Math.ceil(totalPage / pages) },
//     (_, i) => i + 1,
//   );

// return (
//   <section>
//     <div>
//       {pageNumbers.map((pageNumber) => (
//         <div key={pageNumber}>
//           <button
//             onClick={() => onPaginate(pageNumber)}
//             className={page === pageNumber.toString() ? 'active' : ''}
//           >
//             {pageNumber}
//           </button>
//         </div>
//       ))}
//     </div>
//   </section>
// )

export default QuestionListPage;

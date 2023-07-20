'use client';

// TODO: userId === memberId 일 때 수정, 삭제 버튼 노출

import * as S from '@/app/questions/[questionId]/page.styled';
import AnswerBox from '@/components/Question/AnswerBox';
import { SearchMovieList } from '@/components/Question/Modal';
import SearchBox from '@/components/Question/SearchBox';
import {
  AnswerType,
  addAnswerList,
  setAnswerList,
} from '@/redux/features/answerListSlice';
import { RootState } from '@/redux/store';
import axios from 'axios';
import Link from 'next/link';
import {
  useParams,
  usePathname,
  useRouter,
  useSearchParams,
} from 'next/navigation';
import { useCallback, useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { QuestionListResponse } from '../page';

export interface QuestionDetailResponse {
  memberId: string;
  questionId: string;
  nickname: string;
  title: string;
  content: string;
  createdAt: string;
  answerCount: number;
  views: number;
  answers: AnswerType[];
}

const QuestionDetailPage = () => {
  const dispatch = useDispatch();
  const { answers } = useSelector((state: RootState) => state.answerList);
  // const { user } = useSelector((state: RootState) => state.login);
  const { questionId } = useParams();
  const searchParams = useSearchParams();
  const page = searchParams.get('page') ?? 1;
  const [pageInfo, setPageInfo] = useState<QuestionListResponse['pageInfo']>({
    page: 1,
    size: 1,
    totalElements: 7,
    totalPages: 7,
  });

  // TODO: const user = 로그인한 유저 Id
  // 작성자인지 아닌지 체크
  const [isAuthor, setIsAuthor] = useState<boolean>(false);
  const [questionAndAnswer, setQuestionAndAnswer] =
    useState<QuestionDetailResponse | null>(null);

  useEffect(() => {
    const getQuestionDetailData = async () => {
      const source = `${process.env.NEXT_PUBLIC_API_URL}/questions/${questionId}?page=${page}`;
      const response = await axios.get(source, {
        headers: {},
      });
      setQuestionAndAnswer(response.data);
      console.log(response.data);
      // setPageInfo(response.data.pageInfo);
      dispatch(setAnswerList(response.data.answers));
    };
    // user추가
    getQuestionDetailData();
  }, [questionId, page]);

  const onSubmit = async ({
    selectedMovie,
    textValue,
  }: {
    selectedMovie: SearchMovieList;
    textValue: string;
  }) => {
    // 댓글 생성 post

    const source = `${process.env.NEXT_PUBLIC_API_URL}/questions/${questionId}/answers`;
    const response = await axios.post(source, {
      body: {
        memberId: 1,
        content: textValue,
        movie: {
          title: selectedMovie.title,
          poster: selectedMovie.poster,
        },
      },
      headers: {},
    });
    console.log(response);

    dispatch(
      addAnswerList({
        answerId: crypto.randomUUID(),
        // nickname: user ? user.nickname : '',
        createdAt: new Date().toString(),
        content: textValue,
        movie: { title: selectedMovie?.title, poster: selectedMovie?.poster },
      }),
    );
  };

  // if (questionAndAnswer?.memberId === user?.memberId) {
  //   setIsAuthor(true);
  // }

  return (
    <S.PageGroup>
      <S.goMenuBtnBox>
        <Link href={'/questions'}>
          <S.goMenuBtn>전체 목록으로 돌아가기</S.goMenuBtn>
        </Link>
      </S.goMenuBtnBox>
      <AskBox isAuthor={isAuthor} question={questionAndAnswer} />
      <SearchBox onSubmit={onSubmit} />
      {answers.map((answer) => (
        <AnswerBox key={answer.answerId} answer={answer} />
      ))}
      <Pagination
        totalElements={pageInfo?.totalElements}
        size={pageInfo.size}
      />
    </S.PageGroup>
  );
};

interface AskBoxProps {
  isAuthor: boolean;
  question: QuestionDetailResponse | null;
}

const AskBox = ({ isAuthor, question }: AskBoxProps) => {
  return (
    <S.AskBox>
      <BoxTop isAuthor={isAuthor} question={question} />
      <S.BoxTitle>{question?.title}</S.BoxTitle>
      <S.BoxMid>
        <S.ContentBox>
          <div>{question?.content}</div>
        </S.ContentBox>
      </S.BoxMid>
    </S.AskBox>
  );
};

interface BoxTopProps {
  isAuthor: boolean;
  question: QuestionDetailResponse | null;
}

const BoxTop = ({ isAuthor, question }: BoxTopProps) => {
  const router = useRouter();
  const { questionId } = useParams();

  const onDelete = async () => {
    if (window.confirm('삭제하시겠습니까?')) {
      const source = `${process.env.NEXT_PUBLIC_API_URL}/questions/${questionId}`;
      await axios.delete(source, {
        headers: {},
      });
    }
    console.log('질문이 삭제되었습니다.');
    router.push('/questions');
  };

  return (
    <S.BoxTop>
      <S.LeftBox>
        <S.Nickname
          onClick={() =>
            // TODO: 회원 === 글작성자 => 본인 mypage || 회원 != 글작성자 => 글작성자 mypage
            router.push('/mypage')
          }
        >
          {question?.nickname}
        </S.Nickname>
        <S.Time>{AnswerDate(new Date())}</S.Time>
      </S.LeftBox>
      <S.RightBox>
        {/* {isAuthor && ( */}
        <Link href={'/questions/edit'}>
          <S.EditBtn>수정</S.EditBtn>
        </Link>
        {/* )} */}
        {/* {isAuthor &&  */}
        {<S.DeleteBtn onClick={onDelete}>삭제</S.DeleteBtn>}
      </S.RightBox>
    </S.BoxTop>
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
    <>
      <div>
        {pageNumbers.map((pageNumber) => (
          <div key={pageNumber}>
            <button
              onClick={() => {
                router.push(pathname + '?' + onPaginate(pageNumber));
              }}
              className={page === pageNumber.toString() ? 'active' : ''}
            >
              {pageNumber}
            </button>
          </div>
        ))}
      </div>
    </>
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

export default QuestionDetailPage;

'use client';
import { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { useParams } from 'next/navigation';
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '@/redux/store';
import { open } from '@/redux/features/commentSlice';
import { selectStar } from '@/redux/features/starSlice';
import { StarrateShow } from '@/components/Starrate/StarrateShow';
import { CommentModal } from '@/components/CommentModal/Modal';
import { StaffBox } from '@/components/StaffBox/StaffBox';
import { Comment } from '@/components/CommentBox/Comment';
import Pen from '@/assets/penIcon.svg';
import Plus from '@/assets/plus.svg';
import * as S from './page.styled';
import { data } from './dummydata';

interface Genre {
  name: string;
}

interface Staff {
  role: string;
  position: string;
  name: string;
}

interface Comment {
  commentId: number;
  memberId: number;
  nickname: string;
  content: string;
  star: number;
  likeCount: number;
  createdAt: string;
}

interface PageInfo {
  currentPage: number;
  pageSize: number;
  total: number;
}

interface MovieData {
  movieId: number;
  title: string;
  country: string;
  summary: string;
  poster?: string;
  runningTime: number;
  starAvg: number;
  genre: Genre[];
  staff: Staff[];
  openingDate?: string;
  comments: Comment[];
  pageInfo: PageInfo[];
}

export default function MovieDetail() {
  const dispatch = useDispatch();
  // const [data,setData]=useState<MovieData | null>(null);
  const [currentPage, setCurrentPage] = useState(1);
  const openState = useSelector((state: RootState) => state.comment.isOpen);
  const userId = useSelector((state: RootState) => state.auth.memberId);
  const { movieId } = useParams();

  const pageNumbers: number[] = Array.from(
    { length: Math.ceil(data.pageInfo.total / data.pageInfo.pageSize) },
    (_, i) => i + 1,
  );

  // useEffect(()=>{
  //     axios.get(`/movies/${movieId}?page=${currentPage}`)
  //     .then((res)=>{
  //       setData(res.data.data);
  //     }).catch((error)=>{
  //       console.log(error.message);
  //     });
  //   },[]);

  const found = data?.comments?.find((e) => e.memberId === userId);
  const starAvg = data?.starAvg.toFixed(1);
  const genre = data?.genre.map((item) => item.name);

  function changeDateFormat(date: string) {
    const year = date.slice(0, 2);
    const month = date.slice(2, 4);
    const day = date.slice(4, 6);
    const formattedDate = `20${year}.${month}.${day}`;
    return formattedDate;
  }

  const handleOpenModal = () => {
    if (userId) {
      if (!found) {
        dispatch(open());
        dispatch(selectStar(null));
      } else {
        alert('코멘트는 하나만 등록이 가능합니다.');
      }
    } else {
      alert('로그인 후 이용이 가능합니다.');
    }
  };

  const handleToWatch = useCallback(() => {
    if (userId) {
      axios
        .post(
          `/toWatch/${movieId}`,
          {},
          {
            headers: {
              'Content-Type': 'application/json',
              Authorization: localStorage.getItem('Authorization'),
            },
          },
        )
        .then(() => {
          alert('볼 영화 리스트에 추가되었습니다.');
        })
        .catch((error) => {
          if (error.response) {
            if (error.response.status === 409) {
              alert('이미 추가된 영화입니다.');
            } else {
              console.log(error.message);
            }
          }
        });
    } else {
      alert('로그인 후 이용이 가능합니다.');
    }
  }, [movieId, userId]);

  const staffList = data?.staff.map((list, index) => (
    <StaffBox key={index} data={list} />
  ));

  const commentList = data?.comments.map((list) => (
    <Comment key={list.commentId} data={list} />
  ));

  return (
    <S.Wrapper>
      {openState ? <CommentModal /> : ''}
      <S.MovieInfoWrapper>
        <S.PosterStar>
          <S.PosterImg src={data?.poster} alt="영화 포스터" loading="lazy" />
          <S.MyStar>
            <S.MystarIcon>
              <StarrateShow rate={found ? found.star : 0} />
            </S.MystarIcon>
            <S.MyStarNum>{found ? found.star.toFixed(1) : 0.0}</S.MyStarNum>
          </S.MyStar>
        </S.PosterStar>
        <S.MovieInfo>
          <S.StarAvg>
            <S.avNum>{starAvg}</S.avNum>
            <S.avText>평균 별점</S.avText>
          </S.StarAvg>
          <S.Title>{data?.title}</S.Title>
          <S.DetailWrapper>
            <S.DateAndCountry>
              {changeDateFormat(data?.openingDate ? data.openingDate : '')} •{' '}
              {data?.country}
            </S.DateAndCountry>
            <S.Genre>{genre?.join(' / ')}</S.Genre>
            <S.RunningTime>{data?.runningTime}분</S.RunningTime>
          </S.DetailWrapper>
          <S.BtnWrapper>
            <S.ToWatchBtn onClick={handleOpenModal}>
              <span>
                <Pen fill="#ffffff" />
              </span>
              <span>별점・코멘트</span>{' '}
            </S.ToWatchBtn>
            <S.WatchedBtn onClick={handleToWatch}>
              <span>
                <Plus fill="#ffffff" />
              </span>
              <span>보고싶어요</span>
            </S.WatchedBtn>
          </S.BtnWrapper>

          <S.Summary>{data?.summary}</S.Summary>
        </S.MovieInfo>
      </S.MovieInfoWrapper>
      <S.SectionWrapper>
        <S.SectionContainer>
          <S.SectionTitle>출연/제작</S.SectionTitle>
          <S.StaffList>{staffList}</S.StaffList>
        </S.SectionContainer>
      </S.SectionWrapper>
      <S.SectionWrapper>
        <S.SectionContainer>
          <S.SectionTitle>코멘트</S.SectionTitle>
          <S.CommentList>{commentList}</S.CommentList>
          {pageNumbers.length !== 1 ? (
            <Pagination
              pageNumbers={pageNumbers}
              currentPage={currentPage}
              setCurrentPage={setCurrentPage}
            />
          ) : (
            ''
          )}
        </S.SectionContainer>
      </S.SectionWrapper>
    </S.Wrapper>
  );
}

interface PaginationProps {
  pageNumbers: number[];
  currentPage: number;
  setCurrentPage: React.Dispatch<React.SetStateAction<number>>;
}

//페이지네이션
const Pagination = ({
  pageNumbers,
  currentPage,
  setCurrentPage,
}: PaginationProps) => {
  const handleClick = (pageNumber: number): void => {
    setCurrentPage(pageNumber);
  };

  return (
    <div>
      <nav>
        <S.PageButtonGroup>
          {pageNumbers.map((pageNumber) => (
            <S.PageButtonBox
              key={pageNumber}
              onClick={() => handleClick(pageNumber)}
            >
              <S.PageButton
                className={currentPage === pageNumber ? 'active' : ''}
              >
                {pageNumber}
              </S.PageButton>
            </S.PageButtonBox>
          ))}
        </S.PageButtonGroup>
      </nav>
    </div>
  );
};

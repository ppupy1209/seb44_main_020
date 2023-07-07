import React from 'react';
// import { useNavigate } from 'react-router-dom';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import * as S from './MainPoster.styled';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { StarrateShow } from '../Starrate/StarrateShow';
// import { handleDelete } from '../../axiosHandler';

interface Props {
  data: {
    poster: string;
    title: string;
    star: number;
  };
  isWatched: boolean;
  isToWatch: boolean;
}

//조건부 노출을 위해서 isWatched isToWatch 프롭스도 항상 함께 전달해주어야 합니다.
//예시: <MainPoster key={id값} data={data} isWatched={false} isToWatch={false}/>

export function MainPoster({ data, isWatched, isToWatch }: Props) {
  // const navigate=useNavigate();

  // const movieId=data.movie-id

  // const goToMovieDetail = () => {
  //     const movieId = data.movie-id;
  //     navigate(`/movies/${movieId}`);
  //   };

  // const handleDelete=()=>{
  //             {handleDelete(`/movies/toWatch/${movie-id}`)}
  // };

  return (
    <S.Container>
      {' '}
      {/*onClick시 goToMovieDetail, width props 전달하여 크기 조정 가능, styled-components는 처음 상태 그대로 유지해주세요. */}
      <S.PosterImg src={data.poster} alt="영화포스터" />
      <S.Title>
        <S.TitleText>{data.title}</S.TitleText>
      </S.Title>
      {isWatched ? (
        <S.Star>
          <StarrateShow rate={data.star ? data.star : 0} />
        </S.Star>
      ) : (
        ''
      )}{' '}
      {/*본영화 리스트 목록일때 별점 노출 */}
      {isToWatch ? (
        <S.Delete>
          <FontAwesomeIcon icon={faTrash} color="#7EAEF6" />
        </S.Delete>
      ) : (
        ''
      )}{' '}
      {/*볼영화일때 삭제 버튼 노출 onClick시 handleDelete*/}
    </S.Container>
  );
}

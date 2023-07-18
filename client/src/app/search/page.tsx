'use client';
import { useState } from 'react';
import FilterSection from '../../components/Category/FilterSection';
import { FilteredMovies } from '../../components/Category/FilterMovies';
import * as S from './page.styled';

interface Movie {
  title: string;
  genre: string;
  country: string;
  age: string;
  rating: number;
  poster: string;
}

interface Filters {
  genre: string;
  country: string;
  age: string;
  rating: number;
}

const allGenres = ['공포', '액션', '드라마'];
const allCountries = ['한국', '미국', '영국', '일본'];
const allAges = ['전체이용가', '12세', '15세', '18세'];
const allRatings = [1, 2, 3, 4, 5];

const movies: Movie[] = [
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '범죄도시',
    genre: '공포',
    country: '한국',
    age: '18세',
    rating: 2.2,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '범죄도시',
    genre: '공포',
    country: '한국',
    age: '18세',
    rating: 2.2,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '범죄도시',
    genre: '공포',
    country: '한국',
    age: '18세',
    rating: 2.2,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230508_234%2F1683510751767I8t1j_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '오리엔탈',
    genre: '드라마',
    country: '영국',
    age: '전체이용가',
    rating: 4.5,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230526_154%2F1685060493223yFUCL_JPEG%2Fmovie_image.jpg',
  },
  {
    title: '스파이더맨',
    genre: '액션',
    country: '미국',
    age: '15세',
    rating: 1.9,
    poster:
      'https://search.pstatic.net/common?quality=75&direct=true&src=https%3A%2F%2Fmovie-phinf.pstatic.net%2F20230609_126%2F1686293895296CKL3o_JPEG%2Fmovie_image.jpg',
  },
];

const SearchPage: React.FC = () => {
  const [filteredMovies, setFilteredMovies] = useState<Movie[]>(movies);

  const handleFilterChange = (filters: Filters) => {
    const updatedMovies = movies.filter((movie) => {
      if (filters.genre && movie.genre !== filters.genre) {
        return false;
      }
      if (filters.country && movie.country !== filters.country) {
        return false;
      }
      if (filters.age && movie.age !== filters.age) {
        return false;
      }
      if (filters.rating && !isRatingInRange(movie.rating, filters.rating)) {
        return false;
      }
      return true;
    });
    setFilteredMovies(updatedMovies);
  };

  const isRatingInRange = (rating: number, selectedRating: number) => {
    const range = 0.5;
    return Math.abs(rating - selectedRating) <= range;
  };

  return (
    <S.Container>
      <FilterSection
        genres={allGenres}
        countries={allCountries}
        ages={allAges}
        ratings={allRatings}
        onFilterChange={handleFilterChange}
      />

      <FilteredMovies
        movies={filteredMovies}
        filters={{ genre: '', country: '', age: '', rating: 0 }}
      />
    </S.Container>
  );
};

export default SearchPage;

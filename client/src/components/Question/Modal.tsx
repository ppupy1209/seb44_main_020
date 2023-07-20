'use client';

import * as S from '@/components/Question/Modal.styled';
import axios from 'axios';
import Link from 'next/link';
import { usePathname, useSearchParams } from 'next/navigation';
import React, { useState } from 'react';

interface ModalProps {
  onSelectItem: (movie: SearchMovieList) => void;
}

const Modal = ({ onSelectItem }: ModalProps) => {
  const pathname = usePathname();

  const onSelectMovie = (movie: SearchMovieList) => {
    onSelectItem(movie);
  };

  return (
    <S.ModalWrapper>
      <S.ModalContent>
        <SearchModal onSelect={onSelectMovie} />
        <Link href={pathname} replace>
          <button>완료하기</button>
        </Link>
      </S.ModalContent>
    </S.ModalWrapper>
  );
};

export interface SearchMovieList {
  movieId: string;
  title: string;
  poster: string;
  pageInfo: {
    currentPage: number;
    pageSize: number;
    total: number;
  };
}
export interface Movie {
  movies: SearchMovieList[];
}

interface SearchModalProps {
  onSelect: (movie: SearchMovieList) => void;
}

const SearchModal = ({ onSelect }: SearchModalProps) => {
  // const [searchTitle, setSearchTitle] = useState<string>('');
  const searchParams = useSearchParams();
  const page = searchParams.get('page') ?? 1;
  const [searchResult, setSearchResult] = useState<
    SearchMovieList[] | undefined
  >(undefined);
  const [searchKeyword, setSearchKeyword] = useState<string>('');

  const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (searchKeyword) {
      const MovieSearchData = async () => {
        const source = `${process.env.NEXT_PUBLIC_API_URL}/movies/search?page=1&keyword=${searchKeyword}`;
        const response = await axios.get(source, { headers: {} });
        // console.log(response.data);
        setSearchResult(response.data.movies);
        // console.log(searchResult);
      };
      MovieSearchData();
    }
  };

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const searchKeyword = e.target.value;
    setSearchKeyword(searchKeyword);
  };

  const onSelectMovie = (movie: SearchMovieList) => {
    onSelect(movie);
  };

  return (
    <form onSubmit={onSubmit}>
      <S.SearchContainer>
        <S.SearchInput type="text" onChange={onChange} />
        <button type="submit">검색</button>
      </S.SearchContainer>
      <SearchedMovieList
        searchResult={searchResult}
        onSelectMovie={onSelectMovie}
      />
    </form>
  );
};

interface SearchedMovieListProps {
  searchResult: SearchMovieList[] | undefined;
  onSelectMovie: (movie: SearchMovieList) => void;
}

const SearchedMovieList = ({
  searchResult,
  onSelectMovie,
}: SearchedMovieListProps) => {
  const onClickMovie = (movie: SearchMovieList) => {
    onSelectMovie(movie);
  };

  return (
    <S.SearchedListBox>
      {searchResult?.map((movie) => (
        <S.SearchedMovieBox
          onClick={() => onClickMovie(movie)}
          key={movie.movieId}
        >
          <div>
            <img
              src={movie.poster}
              alt="movieposter"
              width={'56px'}
              height={'64px'}
            />
          </div>
          <div>
            <S.SearchedMovieTitle>{movie.title}</S.SearchedMovieTitle>
          </div>
        </S.SearchedMovieBox>
      ))}
    </S.SearchedListBox>
  );
};

export default Modal;

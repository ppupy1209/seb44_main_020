'use client';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Link from 'next/link';
import * as S from './page.styled';
import NavigationBar from '../../components/Filter/NavigationBar';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';
import Pagination from '@/components/Filter/Pagination';
interface PageInfo {
  currentPage: number;
  pageSize: number;
  total: number;
}

interface ApiResponse {
  movies: MovieResponse[];
  pageInfo: PageInfo;
}

interface MovieResponse {
  movieId: string;
  title: string;
  poster: string;
  starAvg: string;
}

const SearchPage: React.FC = () => {
  const url = `${process.env.NEXT_PUBLIC_API_URL}/movies/search`;
  const [filteredData, setFilteredData] = useState<ApiResponse>({
    movies: [],
    pageInfo: { currentPage: 1, pageSize: 8, total: 10 },
  });

  const [genreDropdownOpen, setGenreDropdownOpen] = useState(false);
  const [countryDropdownOpen, setCountryDropdownOpen] = useState(false);
  const [starDropdownOpen, setStarDropdownOpen] = useState(false);
  const [ratingDropdownOpen, setRatingDropdownOpen] = useState(false);
  const [selectedGenre, setSelectedGenre] = useState<string | null>(null);
  const [selectedCountry, setSelectedCountry] = useState<string | null>(null);
  const [selectedRating, setSelectedRating] = useState<string | null>(null);
  const [startStarAvg, setStartStarAvg] = useState<number | null>(null);
  const [endStarAvg, setEndStarAvg] = useState<number | null>(null);
  const [searchKeyword, setSearchKeyword] = useState<string | null>(null);
  const [currentPage, setCurrentPage] = useState(1);

  const fetchData = async (
    genre: string | null,
    country: string | null,
    rating: string | null,
    startStarAvg: number | null,
    endStarAvg: number | null,
    page: number,
    keyword: string | null,
  ) => {
    try {
      const params: any = {
        genre,
        country,
        rating,
        page,
        keyword,
        startStarAvg,
        endStarAvg,
      };

      const response = await axios.get<ApiResponse>(url, {
        params,
      });
      setFilteredData(response.data);
    } catch (error) {
      console.error('Error', error);
    }
  };

  useEffect(() => {
    fetchData(null, null, null, null, null, 1, null);
  }, []);

  const handleGenreClick = (genre: string) => {
    if (selectedGenre === genre) {
      setSelectedGenre(null);
      fetchData(
        null,
        selectedCountry,
        selectedRating,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    } else {
      setSelectedGenre(genre);
      fetchData(
        genre,
        selectedCountry,
        selectedRating,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    }
  };

  const handleCountryClick = (country: string) => {
    if (selectedCountry === country) {
      setSelectedCountry(null);
      fetchData(
        selectedGenre,
        null,
        selectedRating,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    } else {
      setSelectedCountry(country);
      fetchData(
        selectedGenre,
        country,
        selectedRating,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    }
  };

  const handleRatingClick = (rating: string) => {
    if (selectedRating === rating) {
      setSelectedRating(null);
      fetchData(
        selectedGenre,
        selectedCountry,
        null,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    } else {
      setSelectedRating(rating);
      fetchData(
        selectedGenre,
        selectedCountry,
        rating,
        startStarAvg,
        endStarAvg,
        1,
        searchKeyword,
      );
    }
  };

  const handleStartingStarClick = (star: number) => {
    if (star === startStarAvg) {
      setStartStarAvg(null);
    } else {
      setStartStarAvg(star);
    }
    fetchData(
      selectedGenre,
      selectedCountry,
      selectedRating,
      star,
      endStarAvg,
      1,
      searchKeyword,
    );
  };

  const handleEndingStarClick = (star: number) => {
    if (star === endStarAvg) {
      setEndStarAvg(null);
    } else {
      setEndStarAvg(star);
    }
    fetchData(
      selectedGenre,
      selectedCountry,
      selectedRating,
      startStarAvg,
      star,
      1,
      searchKeyword,
    );
  };

  const toggleGenreDropdown = () => {
    setGenreDropdownOpen(!genreDropdownOpen);
  };

  const toggleCountryDropdown = () => {
    setCountryDropdownOpen(!countryDropdownOpen);
  };

  const toggleStarDropdown = () => {
    setStarDropdownOpen(!starDropdownOpen);
  };

  const toggleRatingDropdown = () => {
    setRatingDropdownOpen(!ratingDropdownOpen);
  };

  const handleSearch = (keyword: string) => {
    setSearchKeyword(keyword);
    fetchData(selectedGenre, selectedCountry, selectedRating, 0, 0, 1, keyword);
  };

  const handleSearchInputKeyPress = (
    event: React.KeyboardEvent<HTMLInputElement>,
  ) => {
    if (event.key === 'Enter') {
      handleSearch(event.currentTarget.value);
    }
  };

  const handleSearchIconClick = () => {
    const inputElement = document.getElementById(
      'searchInput',
    ) as HTMLInputElement;
    handleSearch(inputElement.value);
  };

  const handlePreviousPage = () => {
    if (currentPage > 1) {
      const prevPage = currentPage - 1;
      setCurrentPage(prevPage);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        startStarAvg,
        endStarAvg,
        prevPage,
        searchKeyword,
      );
    }
  };

  const handleNextPage = () => {
    const nextPage = currentPage + 1;
    setCurrentPage(nextPage);
    fetchData(
      selectedGenre,
      selectedCountry,
      selectedRating,
      startStarAvg,
      endStarAvg,
      nextPage,
      searchKeyword,
    );
  };
  const fetchDataWithPage = (page: number) => {
    fetchData(
      selectedGenre,
      selectedCountry,
      selectedRating,
      startStarAvg,
      endStarAvg,
      page,
      searchKeyword,
    );
  };
  const pageNumbers: number[] = Array.from(
    {
      length: Math.ceil(
        filteredData.pageInfo.total / filteredData.pageInfo.pageSize,
      ),
    },
    (_, i) => i + 1,
  );

  return (
    <>
      <S.SearchWrapper>
        <S.SearchInputWrapper>
          <S.SearchInput
            type="text"
            placeholder="영화 제목, 배우, 감독을 검색해보세요."
            onKeyDown={handleSearchInputKeyPress}
          />
          <S.SearchIcon>
            <FontAwesomeIcon
              icon={faMagnifyingGlass}
              style={{ color: '#000000', margin: '0 10px', fontSize: '20px' }}
              onClick={handleSearchIconClick}
            />
          </S.SearchIcon>
        </S.SearchInputWrapper>
      </S.SearchWrapper>
      <S.MoviesWrapper>
        <NavigationBar
          toggleGenreDropdown={toggleGenreDropdown}
          toggleCountryDropdown={toggleCountryDropdown}
          toggleStarDropdown={toggleStarDropdown}
          toggleRatingDropdown={toggleRatingDropdown}
          handleGenreClick={handleGenreClick}
          handleCountryClick={handleCountryClick}
          handleRatingClick={handleRatingClick}
          handleStartingStarClick={handleStartingStarClick}
          handleEndingStarClick={handleEndingStarClick}
          genreDropdownOpen={genreDropdownOpen}
          countryDropdownOpen={countryDropdownOpen}
          starDropdownOpen={starDropdownOpen}
          ratingDropdownOpen={ratingDropdownOpen}
          selectedGenre={selectedGenre}
          selectedCountry={selectedCountry}
          startStarAvg={startStarAvg}
          endStarAvg={endStarAvg}
          selectedRating={selectedRating}
        />
        {filteredData.movies.length === 0 ? (
          <S.NoMoviesFound>
            검색하신 조건에 해당하는 영화가 없습니다.
          </S.NoMoviesFound>
        ) : (
          <S.GridContainer>
            {filteredData.movies.map((item) => (
              <Link key={item.movieId} href={`/movies/${item.movieId}`}>
                <S.MovieWrapper key={item.movieId}>
                  <S.Poster src={item.poster} alt={item.title} />
                  <S.Title>{item.title}</S.Title>
                </S.MovieWrapper>
              </Link>
            ))}
          </S.GridContainer>
        )}
      </S.MoviesWrapper>
      <Pagination
        pageNumbers={pageNumbers}
        currentPage={currentPage}
        setCurrentPage={setCurrentPage}
        handlePreviousPage={handlePreviousPage}
        handleNextPage={handleNextPage}
        fetchDataWithPage={fetchDataWithPage}
      />
    </>
  );
};

export default SearchPage;

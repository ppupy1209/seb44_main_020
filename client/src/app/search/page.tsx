'use client';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
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
  const [ageDropdownOpen, setAgeDropdownOpen] = useState(false);
  const [ratingDropdownOpen, setRatingDropdownOpen] = useState(false);
  const [selectedGenre, setSelectedGenre] = useState<string | null>(null);
  const [selectedCountry, setSelectedCountry] = useState<string | null>(null);
  const [selectedRating, setSelectedRating] = useState<string | null>(null);
  // const [selectedAge, setSelectedAge] = useState<number>(0);
  const [startStarAvg, setStartStarAvg] = useState<number>(0);
  const [endStarAvg, setEndStarAvg] = useState<number>(0);
  const [searchKeyword, setSearchKeyword] = useState<string | null>(null);
  const [currentPage, setCurrentPage] = useState(1);
  // const [pageInfo, setPageInfo] = useState<PageInfo>({
  //   currentPage: 1,
  //   pageSize: 10,
  //   total: 10,
  // });

  const fetchData = async (
    genre: string | null,
    country: string | null,
    rating: string | null,
    startStarAvg: 0,
    endStarAvg: 0,
    page: number,
    keyword: string | null,
  ) => {
    try {
      const response = await axios.get<ApiResponse>(url, {
        params: {
          genre,
          country,
          rating,
          startStarAvg,
          endStarAvg,
          page,
          keyword,
        },
      });
      setFilteredData(response.data);
    } catch (error) {
      console.error('Error', error);
    }
  };

  useEffect(() => {
    fetchData(null, null, null, 0, 0, 1, null);
  }, []);

  const handleGenreClick = (genre: string) => {
    if (selectedGenre === genre) {
      setSelectedGenre(null);
      setGenreDropdownOpen(true);
      fetchData(genre, selectedCountry, selectedRating, 0, 0, 1, searchKeyword);
    } else {
      setSelectedGenre(genre);
      setGenreDropdownOpen(true);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        0,
        0,
        1,
        searchKeyword,
      );
    }
  };

  const handleCountryClick = (country: string) => {
    if (selectedCountry === country) {
      setSelectedCountry(null);
      setCountryDropdownOpen(true);
      fetchData(selectedGenre, country, selectedRating, 0, 0, 1, searchKeyword);
    } else {
      setSelectedCountry(country);
      setCountryDropdownOpen(true);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        0,
        0,
        1,
        searchKeyword,
      );
    }
  };

  const handleRatingClick = (rating: string) => {
    if (selectedRating === rating) {
      setSelectedRating(null);
      setRatingDropdownOpen(true);
      fetchData(selectedGenre, selectedCountry, rating, 0, 0, 1, searchKeyword);
    } else {
      setSelectedRating(rating);
      setRatingDropdownOpen(true);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        0,
        0,
        1,
        searchKeyword,
      );
    }
  };

  const handleAgeClick = (age: number) => {
    if (startStarAvg === age && endStarAvg === age) {
      // If the selected age is already applied, remove the age filter
      setStartStarAvg(0);
      setEndStarAvg(0);
      setAgeDropdownOpen(false);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        0,
        0,
        1,
        searchKeyword,
      );
    } else {
      setStartStarAvg(age);
      setEndStarAvg(age);
      setAgeDropdownOpen(true);
      fetchData(
        selectedGenre,
        selectedCountry,
        selectedRating,
        0,
        0,
        1,
        searchKeyword,
      );
    }
  };
  const toggleGenreDropdown = () => {
    setGenreDropdownOpen(!genreDropdownOpen);
  };

  const toggleCountryDropdown = () => {
    setCountryDropdownOpen(!countryDropdownOpen);
  };

  const toggleAgeDropdown = () => {
    setAgeDropdownOpen(!ageDropdownOpen);
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
        0,
        0,
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
      0,
      0,
      nextPage,
      searchKeyword,
    );
  };
  const fetchDataWithPage = (page: number) => {
    fetchData(
      selectedGenre,
      selectedCountry,
      selectedRating,
      0,
      0,
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
          toggleAgeDropdown={toggleAgeDropdown}
          toggleRatingDropdown={toggleRatingDropdown}
          handleGenreClick={handleGenreClick}
          handleCountryClick={handleCountryClick}
          handleAgeClick={handleAgeClick}
          handleRatingClick={handleRatingClick}
          genreDropdownOpen={genreDropdownOpen}
          countryDropdownOpen={countryDropdownOpen}
          ageDropdownOpen={ageDropdownOpen}
          ratingDropdownOpen={ratingDropdownOpen}
          selectedGenre={selectedGenre}
          selectedCountry={selectedCountry}
          startStarAvg={startStarAvg}
          endStarAvg={endStarAvg}
          selectedRating={selectedRating}
        />
        <S.GridContainer>
          {filteredData.movies.map((item) => (
            <S.MovieWrapper key={item.movieId}>
              <S.Poster src={item.poster} alt={item.title} />
              <S.Title>{item.title}</S.Title>
              {/* <S.Title>평균별점: {item.starAvg}</S.Title> */}
            </S.MovieWrapper>
          ))}
        </S.GridContainer>
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

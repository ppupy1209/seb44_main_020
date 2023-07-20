import React from 'react';
import * as S from './NavigationBar.styled';

interface Props {
  toggleGenreDropdown: () => void;
  toggleCountryDropdown: () => void;
  toggleAgeDropdown: () => void;
  toggleRatingDropdown: () => void;
  handleGenreClick: (genre: string) => void;
  handleCountryClick: (country: string) => void;
  handleAgeClick: (age: number) => void;
  handleRatingClick: (rating: string) => void;
  genreDropdownOpen: boolean;
  countryDropdownOpen: boolean;
  ageDropdownOpen: boolean;
  ratingDropdownOpen: boolean;
  selectedGenre: string | null;
  selectedCountry: string | null;
  startStarAvg: number;
  endStarAvg: number;
  selectedRating: string | null;
}

const NavigationBar: React.FC<Props> = ({
  toggleGenreDropdown,
  toggleCountryDropdown,
  toggleAgeDropdown,
  toggleRatingDropdown,
  handleGenreClick,
  handleCountryClick,
  handleAgeClick,
  handleRatingClick,
  genreDropdownOpen,
  countryDropdownOpen,
  ageDropdownOpen,
  ratingDropdownOpen,
  selectedGenre,
  selectedCountry,
  startStarAvg,
  endStarAvg,
  selectedRating,
}) => {
  const genreOptions = [
    { label: '드라마', value: '드라마' },
    { label: '판타지', value: '판타지' },
    { label: '스릴러', value: '스릴러' },
    { label: '공포', value: '공포' },
    { label: '로맨스', value: '로맨스' },
    { label: '코메디', value: '코메디' },
    { label: '범죄', value: '범죄' },
    { label: '미스터리', value: '미스터리' },
    { label: '액션', value: '액션' },
    { label: 'SF', value: 'SF' },
    { label: '뮤지컬', value: '뮤지컬' },
  ];
  const countryOptions = [
    { label: '대한민국', value: '대한민국' },
    { label: '미국', value: '미국' },
    { label: '영국', value: '영국' },
    { label: '일본', value: '일본' },
  ];

  const ratingOptions = [
    { label: '전체관람가', value: '전체관람가' },
    { label: '12세관람가', value: '12세관람가' },
    { label: '15세관람가', value: '15세관람가' },
    { label: '18세관람가', value: '18세관람가(청소년관람불가)' },
  ];

  const ageOptions = [
    { label: '0점', value: 0.0 },
    { label: '1점', value: 1 },
    { label: '2점', value: 2 },
    { label: '3점', value: 3 },
    { label: '4점', value: 4 },
  ];

  return (
    <S.StyledNav>
      {/* 장르 드롭다운 */}
      <S.Button onClick={toggleGenreDropdown} active={genreDropdownOpen}>
        장르별
      </S.Button>
      {genreDropdownOpen && (
        <S.Dropdown>
          {/* 드라마, 판타지, 스릴러, 공포, 멜로/로맨스, 코메디, 범죄,
            미스터리, 액션, SF, 뮤지컬 */}
          {genreOptions.map((option) => (
            <S.Buttondetail
              key={option.value}
              onClick={() => handleGenreClick(option.value)}
              active={selectedGenre === option.value}
            >
              {option.label}
            </S.Buttondetail>
          ))}
        </S.Dropdown>
      )}
      {/* 국가 드롭다운 */}
      <S.Button onClick={toggleCountryDropdown} active={countryDropdownOpen}>
        국가별
      </S.Button>
      {countryDropdownOpen && (
        <S.Dropdown>
          {countryOptions.map((option) => (
            <S.Buttondetail
              key={option.value}
              onClick={() => handleCountryClick(option.value)}
              active={selectedCountry === option.value}
            >
              {option.label}
            </S.Buttondetail>
          ))}
        </S.Dropdown>
      )}
      {/* 연령별점 드롭다운 */}
      <S.Button onClick={toggleRatingDropdown} active={ratingDropdownOpen}>
        연령별
      </S.Button>
      {ratingDropdownOpen && (
        <S.Dropdown>
          {ratingOptions.map((option) => (
            <S.Buttondetail
              key={option.value}
              onClick={() => handleRatingClick(option.value)}
              active={selectedRating === option.value}
            >
              {option.label}
            </S.Buttondetail>
          ))}
        </S.Dropdown>
      )}
      {/* 연령 드롭다운 */}
      <S.Button onClick={toggleAgeDropdown} active={ageDropdownOpen}>
        별점순
      </S.Button>
      {ageDropdownOpen && (
        <S.Dropdown>
          {ageOptions.map((option) => (
            <S.Buttondetail
              key={option.value}
              onClick={() => handleAgeClick(option.value)}
              active={
                startStarAvg === option.value && endStarAvg === option.value
              }
            >
              {option.label}
            </S.Buttondetail>
          ))}
        </S.Dropdown>
      )}
    </S.StyledNav>
  );
};

export default NavigationBar;

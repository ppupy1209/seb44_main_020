import React from 'react';
import * as S from './NavigationBar.styled';
import { StarrateShow } from '../Starrate/StarrateShow';
import { useState } from 'react';

interface Props {
  toggleGenreDropdown: () => void;
  toggleCountryDropdown: () => void;
  toggleStarDropdown: () => void;
  toggleRatingDropdown: () => void;
  handleGenreClick: (genre: string) => void;
  handleCountryClick: (country: string) => void;
  handleStartingStarClick: (star: number) => void;
  handleEndingStarClick: (star: number) => void;
  handleRatingClick: (rating: string) => void;
  genreDropdownOpen: boolean;
  countryDropdownOpen: boolean;
  starDropdownOpen: boolean;
  ratingDropdownOpen: boolean;
  selectedGenre: string | null;
  selectedCountry: string | null;
  startStarAvg: number | null;
  endStarAvg: number | null;
  selectedRating: string | null;
}

const NavigationBar: React.FC<Props> = ({
  toggleGenreDropdown,
  toggleCountryDropdown,
  toggleStarDropdown,
  toggleRatingDropdown,
  handleGenreClick,
  handleCountryClick,
  handleStartingStarClick,
  handleEndingStarClick,
  handleRatingClick,
  genreDropdownOpen,
  countryDropdownOpen,
  starDropdownOpen,
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

  // const handleEndingStarSliderChange = (
  //   event: React.ChangeEvent<HTMLInputElement>,
  // ) => {
  //   const value = parseInt(event.target.value, 10);
  //   handleEndingStarClick(value);
  // };
  // const handleStartingStarSliderChange = (value: number) => {
  //   // 별점 슬라이더 값을 0.5 단위로 반올림하여 업데이트합니다.
  //   const roundedValue = Math.round(value * 2) / 2;
  //   handleStartingStarClick(roundedValue);
  // };
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
      {/* 별점 드롭다운 */}
      <S.Button onClick={toggleStarDropdown} active={starDropdownOpen}>
        별점순
      </S.Button>
      {starDropdownOpen && (
        <S.DropdownWrapper>
          <S.Dropdown1>
            <S.SliderWrapper>
              <StarRating
                rate={startStarAvg || 5}
                onChange={handleStartingStarClick}
              />
            </S.SliderWrapper>
          </S.Dropdown1>
        </S.DropdownWrapper>
      )}
    </S.StyledNav>
  );
};
interface StarRatingProps {
  rate: number;
  onChange: (star: number) => void;
}

const StarRating: React.FC<StarRatingProps> = ({ rate = 5, onChange }) => {
  const [currentRating, setCurrentRating] = useState(rate);

  const handleClick = (starRating: number) => {
    setCurrentRating(starRating);
    onChange(starRating);
  };

  return (
    <div>
      {[1, 2, 3, 4, 5].map((starRating) => (
        <StarIcon
          key={starRating}
          filled={starRating <= currentRating}
          onClick={() => handleClick(starRating)}
        />
      ))}
    </div>
  );
};

interface StarIconProps {
  filled: boolean;
  onClick: () => void;
}

const StarIcon: React.FC<StarIconProps> = ({ filled, onClick }) => (
  <svg
    xmlns="http://www.w3.org/2000/svg"
    width="25"
    height="25"
    fill={filled ? 'yellow' : 'none'}
    viewBox="0 0 16 16"
    onClick={onClick}
  >
    <path d="M8 0l2.5 6h6l-4.5 3.5 1.5 6-5-4-5 4 1.5-6L1.5 6h6z" />
  </svg>
);

export default NavigationBar;

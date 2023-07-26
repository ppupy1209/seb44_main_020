'use client';

import Starfull from '@/assets/fullStar.svg'
import Starhalf from '@/assets/halfStar.svg'
import Starempty from '@/assets/emptyStar.svg'
import * as S from './StarrateShow.styled';

interface proptype {
  rate: number;
}

export function StarrateShow({ rate }: proptype) {
  const starRatings = [1, 2, 3, 4, 5];
  return (
    <S.Container>
      {starRatings.map((starRating) => {
        if (rate >= starRating) {
          return <Starfull  key={starRating}/>;
        } else if (rate === starRating - 0.5) {
          return <Starhalf  key={starRating} />;
        } else {
          return <Starempty width="24" height="24" fill="#1F305F"  key={starRating}/>;
        }
      })}
    </S.Container>
  );
}

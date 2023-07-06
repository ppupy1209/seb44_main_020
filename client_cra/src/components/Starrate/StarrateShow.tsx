import { ReactComponent as Starfull} from '../../static/fullStar.svg';
import { ReactComponent as Starhalf} from '../../static/halfStar.svg';
import { ReactComponent as Starempty} from '../../static/emptyStar.svg';
import * as S from './StarrateShow.styled';

interface proptype{
    rate:number;
}

export function StarrateShow({rate}:proptype){  
    const starRatings = [1, 2, 3, 4, 5];
    return(
        <S.Container>
                  {starRatings.map((starRating) => {
                    if (rate >= starRating) {
          return <Starfull key={starRating} />;
        } else if (rate === starRating - 0.5) {
          return <Starhalf key={starRating} />;
        } else {
          return <Starempty key={starRating} />;
        }
      })}
        </S.Container>
    );
}
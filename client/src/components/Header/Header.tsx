import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faMagnifyingGlass,
  faUser,
  faPen,
  faRightToBracket,
  faRightFromBracket,
} from '@fortawesome/free-solid-svg-icons';
import { ReactComponent as Logo } from '../../assets/logo-moovda.svg';
import {
  StyledHeader,
  StyledLogo,
  StyledLog,
  StyledIconSearch,
  StyledIconAsk,
  StyledIconMyPage,
} from './Header.styled';

const Header = () => {
  const navigate = useNavigate();

  const handleNavigate = (path: string) => {
    navigate(path);
  };
  return (
    <StyledHeader>
      <StyledLogo>
        <Logo onClick={() => handleNavigate('/')} />
      </StyledLogo>
      <StyledIconSearch>
        <FontAwesomeIcon
          icon={faMagnifyingGlass}
          style={{ color: 'white' }}
          size="xl"
          onClick={() => handleNavigate('/moives/search')}
        />
      </StyledIconSearch>
      <StyledIconAsk>
        <FontAwesomeIcon
          icon={faPen}
          style={{ color: 'white' }}
          size="xl"
          onClick={() => handleNavigate('questions/ask')}
        />
      </StyledIconAsk>
      <StyledIconMyPage>
        <FontAwesomeIcon
          icon={faUser}
          style={{ color: 'white' }}
          size="xl"
          onClick={() => handleNavigate('members/mypage')}
        />
      </StyledIconMyPage>
      <StyledLog>
        <FontAwesomeIcon
          icon={faRightToBracket}
          style={{ color: 'white' }}
          size="xl"
          onClick={() => handleNavigate('members/login')}
        />
      </StyledLog>
    </StyledHeader>
  );
};

export default Header;

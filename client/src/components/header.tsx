import { useNavigate } from 'react-router-dom';

import styled from 'styled-components';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faMagnifyingGlass,
  faCircleInfo,
  faPen,
} from '@fortawesome/free-solid-svg-icons';
import logo from '../assets/logo-moovda.jpg';
import login from '../assets/login.png';

const Header = () => {
  const navigate = useNavigate();

  const handleNavigate = (path: string) => {
    navigate(path);
  };
  return (
    <StyledHeader>
      <StyledLogo1>
        <StyledLogo src={logo} alt="logo" onClick={() => handleNavigate('/')} />
      </StyledLogo1>
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
          icon={faCircleInfo}
          style={{ color: 'white' }}
          size="xl"
          onClick={() => handleNavigate('members/mypage')}
        />
      </StyledIconMyPage>
      <StyledLog>
        <StyledLogin
          src={login}
          alt="login"
          onClick={() => handleNavigate('members/login')}
        />
      </StyledLog>
    </StyledHeader>
  );
};

export default Header;

const StyledHeader = styled.header`
  width: 100%;
  margin-top: 20px;
  padding-bottom: 20px;
  border-bottom: 1px solid #466093;
  position: sticky;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const StyledLogo = styled.img`
  margin-left: 30px;
  align-self: center;
  cursor: pointer;
  height: 80%;
  transition: all 0.2s;
  &:hover {
    background-color: ;
  }
`;

const StyledLogin = styled.img`
  margin-left: 50px;
  align-self: center;
  cursor: pointer;
  height: 80%;
  transition: all 0.2s;
  &:hover {
    background-color: ;
  }
`;

const StyledIconSearch = styled.div`
  margin-right: 40px;
`;

const StyledIconAsk = styled.div`
  margin-right: auto;
`;

const StyledIconMyPage = styled.div`
  margin-left: 20px;
  margin-right: 0px;
`;

const StyledLogo1 = styled.div`
  margin: 0 40px;
  height: 100%;
  display: flex;
`;
const StyledLog = styled.div`
  padding-right: 70px;
  height: 100%;
  display: flex;
`;

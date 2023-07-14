'use client';
import MoovDa from '@/assets/moovdaLogo.svg';
import { useDispatch } from 'react-redux';
import {
  faMagnifyingGlass,
  faPen,
  faRightToBracket,
  faRightFromBracket,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useRouter } from 'next/navigation';
import {
  StyledHeader,
  StyledIconAsk,
  StyledIconMyPage,
  StyledIconSearch,
  StyledLog,
  StyledLogo,
  StyledBody,
} from './Header.styled';
import { useSession, signIn, signOut } from 'next-auth/react';
import { setLoginState } from '@/redux/features/loginSlice';

const Header = () => {
  const router = useRouter();
  const { data: session, status } = useSession();
  const dispatch = useDispatch();

  const handleSingOut = () => {
    dispatch(setLoginState(false));
    localStorage.clear();
    signOut();
  };
  return (
    <StyledBody>
      <StyledHeader>
        <StyledLogo>
          <MoovDa onClick={() => router.push('/')} />
        </StyledLogo>
        <StyledIconSearch>
          <FontAwesomeIcon
            icon={faMagnifyingGlass}
            style={{ color: 'white' }}
            size="xl"
            onClick={() => router.push('/search')}
          />
        </StyledIconSearch>
        <StyledIconAsk>
          <FontAwesomeIcon
            icon={faPen}
            style={{ color: 'white' }}
            size="xl"
            onClick={() => router.push('/questions')}
          />
        </StyledIconAsk>
        <StyledIconMyPage>
          <FontAwesomeIcon
            icon={faUser}
            style={{ color: 'white' }}
            size="xl"
            onClick={() => router.push('/mypage')}
          />
        </StyledIconMyPage>
        {session ? (
          <StyledLog onClick={handleSingOut}>
            LogOut
            <p>{session.user?.name}님 환영합니다.</p>
          </StyledLog>
        ) : (
          <StyledLog onClick={() => router.push('/login')}>LogIn</StyledLog>
        )}
      </StyledHeader>
    </StyledBody>
  );
};

export default Header;

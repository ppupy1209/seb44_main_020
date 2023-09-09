'use client';
import MoovDa from '@/assets/moovdaLogo.svg';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import {
  faMagnifyingGlass,
  faPen,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useRouter } from 'next/navigation';
import { useState, useEffect } from 'react';
import {
  StyledHeader,
  StyledIconAsk,
  StyledIconMyPage,
  StyledIconSearch,
  StyledLog,
  StyledLogo,
  StyledBody,
} from './Header.styled';
import jwtDecode from 'jwt-decode';
import { setLoginState } from '@/redux/features/loginSlice';
import { setMemberId, setNickname } from '@/redux/features/authSlice';
import { responseUserInfo } from '@/redux/features/userinfoSlice';

interface DecodedAccessToken {
  memberId: number | null;
  nickname: string | null;
}

const Header = () => {
  const router = useRouter();
  const dispatch = useDispatch();
  const loginState = useSelector((state: RootState) => state.login);
  const memberId = useSelector((state: RootState) => state.auth.memberId);
  const nickname = useSelector((state: RootState) => state.auth.nickname);

  useEffect(() => {
    if (typeof window !== 'undefined') {
      const searchParams = new URLSearchParams(window.location.search);
      const Authorization: any = searchParams.get('Authorization');
      const refreshToken = searchParams.get('refresh_token');
      dispatch(setLoginState(false));

      if (Authorization !== null) {
        const decodedAccessToken: DecodedAccessToken = jwtDecode(Authorization);
        const memberId: any = Number(decodedAccessToken?.memberId);
        const nickname: any = decodedAccessToken?.nickname;

        dispatch(setMemberId(memberId));
        dispatch(setNickname(nickname));

        localStorage.setItem('Authorization', Authorization);
        const storedAccessToken = localStorage.getItem('Authorization');
        if (storedAccessToken !== null) {
          dispatch(setLoginState(true));
        } else {
          dispatch(setLoginState(false));
          localStorage.removeItem('Authorization');
        }
      }
      if (Authorization || refreshToken) {
        const newUrl = window.location.origin + window.location.pathname;
        history.replaceState({}, document.title, newUrl);
      }
    }
  }, [router, dispatch]);

  const handleMypageClick = () => {
    if (loginState === false) {
      alert('로그인 후 이용하세요!');
    } else if (memberId) {
      router.push(`/mypage/${memberId}`);
    }
  };
  const handleLogout = () => {
    dispatch(setLoginState(false));
    dispatch(setMemberId(null));
    dispatch(setNickname(null));
    localStorage.clear();
    router.push('/');
  };

  useEffect(() => {
    const storedAccessToken = localStorage.getItem('Authorization');
    if (storedAccessToken) {
      dispatch(setLoginState(true));
      const decodedAccessToken: DecodedAccessToken =
        jwtDecode(storedAccessToken);
      const memberId = Number(decodedAccessToken?.memberId);
      const nickname = decodedAccessToken?.nickname;
      dispatch(setMemberId(memberId));
      dispatch(setNickname(nickname));
    }
  }, [dispatch]);

  const storedAccessToken =
    typeof window !== 'undefined'
      ? localStorage.getItem('Authorization')
      : null;
  const isLoggedIn = storedAccessToken !== null;

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
            onClick={handleMypageClick}
          />
        </StyledIconMyPage>
        {isLoggedIn === false ? (
          <StyledLog onClick={() => router.push('/login')}>Login</StyledLog>
        ) : (
          <>
            <StyledLog onClick={handleLogout}>LogOut</StyledLog>
          </>
        )}
      </StyledHeader>
    </StyledBody>
  );
};
export default Header;

'use client';
import { signIn, useSession } from 'next-auth/react';
import * as S from './page.styled';
import { StyledWrapper } from '../../../styles/style';
import LoginLogo from '@/assets/LoginLogo.svg';
import GoogleLogo from '@/assets/GoogleLogo.svg';
import { useDispatch, useSelector } from 'react-redux';
import { setUser, setToken } from '../../../redux/features/authSlice';
import axios from 'axios';

const LoginPage = () => {
  const dispatch = useDispatch();
  const url = `${process.env.REACT_APP_API_URL}/members/login`;
  const { data: session } = useSession();
  dispatch(setUser(session));
  localStorage.setItem('user', JSON.stringify(session));

  const handleLoginReq = async (data: any) => {
    const response = await axios.post(url, data); // 로그인 API 호출
    const Authorization = response.headers.authorization;
    const Refresh = response.headers.refresh;
    localStorage.setItem(
      'token',
      JSON.stringify({
        access: Authorization,
        refresh: Refresh,
      }),
    );
    localStorage.setItem(
      'user',
      JSON.stringify({
        memberId: response.data.memberId,
        username: response.data.username,
        nickname: response.data.nickname,
        email: response.data.email,
      }),
    );
    dispatch(setUser(session)); // 사용자 정보 Redux 상태 업데이트
  };

  const handleSignIn = () => {
    signIn('google');
  };
  const auth = useSelector((state: any) => state.auth);
  console.log(auth.user);
  return (
    <>
      <div style={{ overflowY: 'auto', height: '100vh' }}>
        <S.StyledSection>
          <S.StyledLogo>
            <LoginLogo />
          </S.StyledLogo>
          <S.StyledMessage>
            MoovDa에 오신 걸<br></br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;환영합니다.
          </S.StyledMessage>
          <S.StyledLoginBtn onClick={handleSignIn} onChange={handleLoginReq}>
            <GoogleLogo />
            <S.StyledButtonText>구글계정으로 로그인하기</S.StyledButtonText>
          </S.StyledLoginBtn>
        </S.StyledSection>
      </div>
    </>
  );
};

export default LoginPage;

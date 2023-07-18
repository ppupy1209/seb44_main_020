'use client';
import { signIn, useSession } from 'next-auth/react';
import * as S from './page.styled';
import LoginLogo from '@/assets/LoginLogo.svg';
import GoogleLogo from '@/assets/GoogleLogo.svg';
import { useDispatch, useSelector } from 'react-redux';
import { setUser, setToken } from '../../../redux/features/authSlice';
import axios from 'axios';
import { setLoginState } from '@/redux/features/loginSlice';
import jwtDecode from 'jwt-decode';


const LoginPage = () => {
  const dispatch = useDispatch();
  const url = `${process.env.NEXT_PUBLIC_API_URL}/members/login`;
  const { data: session } = useSession();
  dispatch(setUser(session));

  const handleSignIn = async () => {
    await signIn('google');
    const { data: updatedSession } = useSession();
    try {
      const response = await axios.post(
        url,
        { updatedSession },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        },
      );
      const Authorization = response.headers.authorization;
      const Refresh = response.headers.refresh;
      const decodedToken = jwtDecode(Authorization) as { memberId?: string };
      const memberId = decodedToken?.memberId;
      if (response.status === 200) {
        dispatch(setLoginState(true));
        alert('로그인에 성공하였습니다.');
        localStorage.setItem(
          'token',
          JSON.stringify({
            access: Authorization,
            refresh: Refresh,
            memberId: memberId,
          }),
        );
        localStorage.setItem(
          'user',
          JSON.stringify({
            updatedSession: response.data.updatedSession,
          }),
        );
        dispatch(setUser(response.data.updatedSession)); // 사용자 정보 Redux 상태 업데이트
        dispatch(setToken(response.data.memberId)); // store에 memberId 저장
      } else {
        alert('로그인에 실패하였습니다.');
      }
    } catch (error) {
      console.error('Error', error);
    }
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
          <S.StyledLoginBtn onClick={handleSignIn}>
            <GoogleLogo />
            <S.StyledButtonText>구글계정으로 로그인하기</S.StyledButtonText>
          </S.StyledLoginBtn>
        </S.StyledSection>
      </div>
    </>
  );
};

export default LoginPage;

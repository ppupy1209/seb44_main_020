'use client';
import { signIn } from 'next-auth/react';
import * as S from './page.styled';
import { StyledWrapper } from '../../../styles/style';
import LoginLogo from '@/assets/LoginLogo.svg';
import GoogleLogo from '@/assets/GoogleLogo.svg';
const LoginPage = () => {
  const handleSignIn = () => {
    signIn('google');
  };
  return (
    <StyledWrapper>
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
    </StyledWrapper>
  );
};

export default LoginPage;

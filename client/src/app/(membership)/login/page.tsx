'use client';
import * as S from './page.styled';
import LoginLogo from '@/assets/LoginLogo.svg';
import GoogleLogo from '@/assets/GoogleLogo.svg';
import { GoogleLoginToken } from '@/components/Token/GoogleLoginToken';
import { useRouter } from 'next/navigation';

const LoginPage = () => {
  const router = useRouter();
  const LoginRequestHandlerGoogle = () => {
    window.location.href = `${process.env.NEXT_PUBLIC_API_URL}/oauth2/authorization/google`;
  };

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
          <S.StyledLoginBtn>
            <GoogleLogo />
            <S.StyledButtonText onClick={LoginRequestHandlerGoogle}>
              구글계정으로 로그인하기
            </S.StyledButtonText>
          </S.StyledLoginBtn>
          <GoogleLoginToken />
        </S.StyledSection>
      </div>
    </>
  );
};

export default LoginPage;

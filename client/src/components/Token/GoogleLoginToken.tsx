'use client';

import { useDispatch, useSelector } from 'react-redux';
import { setUser, setToken } from '../../redux/features/authSlice';
import { useEffect } from 'react';
import { useSearchParams } from 'next/navigation';
import { useRouter } from 'next/navigation';
import jwtDecode from 'jwt-decode';

export const GoogleLoginToken = () => {
  const dispatch = useDispatch();
  const router = useRouter();

  useEffect(() => {
    const searchParams = new URLSearchParams(window.location.search);
    const accessToken = searchParams.get('access_token');
    const refreshToken = searchParams.get('refresh_token');
    const nickname = searchParams.get('nickname');
    const memberId = searchParams.get('memberId');

    if (accessToken && refreshToken && nickname && memberId) {
      localStorage.setItem('accessToken', accessToken);
      localStorage.setItem('refreshToken', refreshToken);
      localStorage.setItem('nickname', nickname);
      localStorage.setItem('memberId', memberId);

      const decodedAccessToken: any = jwtDecode(accessToken);
      console.log(decodedAccessToken.nickname);
      console.log(accessToken);
      dispatch(setUser({ nickname, memberId }));
      dispatch(setToken({ accessToken, refreshToken }));

      router.push('/movies/main');
    }
  }, [dispatch, router]);

  return (
    <>
      <div>Loading..</div>
    </>
  );
};

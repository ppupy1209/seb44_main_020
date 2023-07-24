import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { Content } from 'next/font/google';
// import { RootState } from '../store/store';

interface LoginState {
  userInfo: {
    nickname: string | null;
    memberId: string | null;
  };
  tokens: {
    accessToken: string | null;
    refreshToken: string | null;
  };
}

export const authSlice = createSlice({
  name: 'login',
  initialState: {
    nickname: null,
    memberId: null,
    accessToken: null,
    refreshToken: null,
  },
  reducers: {
    setUser(state, action) {
      state.nickname = action.payload;
      state.memberId = action.payload;
    },
    setToken(state, action) {
      state.accessToken = action.payload;
      state.refreshToken = action.payload;
    },
  },
});

export default authSlice.reducer; // reducer 해주면 리턴이 됨
export const { setUser, setToken } = authSlice.actions;

// export const selectCurrentUser = (state: RootState) => state.auth;
// export const selectCurrentToken = (state: RootState) => state.auth;

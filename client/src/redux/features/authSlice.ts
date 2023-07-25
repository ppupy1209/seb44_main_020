import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { Content } from 'next/font/google';
// import { RootState } from '../store/store';

interface LoginState {
  userInfo: {
    nickname: string | null;
    memberId: string | null;
  };
}

export const authSlice = createSlice({
  name: 'login',
  initialState: {
    nickname: null,
    memberId: null,
  },

  reducers: {
    setMemberId(state, action) {
      state.memberId = action.payload;
    },
    setNickname(state, action) {
      state.nickname = action.payload;
    },
  },
});

export default authSlice.reducer; // reducer 해주면 리턴이 됨
export const { setMemberId, setNickname } = authSlice.actions;

// export const selectCurrentUser = (state: RootState) => state.auth;
// export const selectCurrentToken = (state: RootState) => state.auth;

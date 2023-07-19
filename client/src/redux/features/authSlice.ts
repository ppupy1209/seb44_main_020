import { createSlice } from '@reduxjs/toolkit';
// import { RootState } from '../store/store';

export const authSlice = createSlice({
  name: 'login',
  initialState: {
    user: null,
    token: null,
    memberId: null,
  },
  reducers: {
    setUser(state, action) {
      state.user = action.payload;
    },
    setToken(state, action) {
      state.token = action.payload;
    },
  },
});

export default authSlice.reducer; // reducer 해주면 리턴이 됨
export const { setUser, setToken } = authSlice.actions;

// export const selectCurrentUser = (state: RootState) => state.auth;
// export const selectCurrentToken = (state: RootState) => state.auth;

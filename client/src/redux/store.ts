import {configureStore}from '@reduxjs/toolkit';
import showDeletReducer from '@/redux/features/deleteSlice'
import loginReducer from '@/redux/features/authSlice';

export const store = configureStore({
  reducer: {
    showDelete: showDeletReducer,
    login: loginReducer,
  },
});

export type RootState=ReturnType<typeof store.getState>;
export type AppDispatch=typeof store.dispatch;
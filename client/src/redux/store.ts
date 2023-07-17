import {configureStore}from '@reduxjs/toolkit';
import showDeletReducer from '@/redux/features/deleteSlice'
import loginReducer from '@/redux/features/authSlice';
import draggingReducer from '@/redux/features/dragSlice'
import commentReducer from '@/redux/features/commentSlice';
import starReducer from '@/redux/features/starSlice'

export const store = configureStore({
  reducer: {
    showDelete: showDeletReducer,
    login: loginReducer,
    drag:draggingReducer,
    comment:commentReducer,
    star:starReducer,
  },
});

export type RootState=ReturnType<typeof store.getState>;
export type AppDispatch=typeof store.dispatch;
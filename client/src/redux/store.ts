import {configureStore}from '@reduxjs/toolkit';
import showDeletReducer from '@/redux/features/deleteSlice'

export const store= configureStore({
    reducer:{
        showDelete:showDeletReducer,
    },
})

export type RootState=ReturnType<typeof store.getState>;
export type AppDispatch=typeof store.dispatch;
import {createSlice} from '@reduxjs/toolkit';

export type Comment={
    isOpen:boolean;
}

const initialState={
    isOpen:false,
} as Comment

export const comment=createSlice({
    name:"comment",
    initialState,
    reducers:{
        open:(state)=>{
            state.isOpen=true;
        },
        close:(state)=>{
            state.isOpen=false;
        }
    }
})

export const { open, close}=comment.actions;
export default comment.reducer;
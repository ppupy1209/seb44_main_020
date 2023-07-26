import {createSlice} from '@reduxjs/toolkit';

export type Comment={
    isOpen?:boolean;
    content?:string;
    commentId?:number|null;
}

const initialState={
    isOpen:false,
    content:'',
    commentId:null
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
        },
        getContent:(state,action)=>{
            state.content=action.payload;
        },
        getCommentId:(state,action)=>{
            state.commentId=action.payload;
        }
        }

    }
)

export const { open, close,getContent,getCommentId}=comment.actions;
export default comment.reducer;
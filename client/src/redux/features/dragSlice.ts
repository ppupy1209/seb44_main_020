import {createSlice} from '@reduxjs/toolkit';

 type DragState={
    value:boolean;
}

const initialState={
    value:false,
} as DragState

export const dragging=createSlice({
    name:"drag",
    initialState,
    reducers:{
        dragOn:(state)=>{
            state.value=true
        },
        dragOff:(state)=>{
            state.value=false
        }

    }
})

export const { dragOn, dragOff}=dragging.actions;
export default dragging.reducer;
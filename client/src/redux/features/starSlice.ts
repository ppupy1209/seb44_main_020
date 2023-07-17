import { createSlice,PayloadAction } from '@reduxjs/toolkit';

interface StarState {
    selectedStar: number| null;
  }

const starSlice = createSlice({
  name: 'star',
  initialState: {
    selectedStar: null,
  }as StarState,
  reducers: {
    selectStar: (state, action: PayloadAction<number>) => {
      state.selectedStar = action.payload;
    },
  },
});

export const { selectStar } = starSlice.actions;
export default starSlice.reducer;
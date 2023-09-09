import { QuestionDetailResponse } from '@/app/questions/[questionId]/page';
import { PayloadAction, createSlice } from '@reduxjs/toolkit';

export interface QuestionIdState {
  questionId?: number | null;
}

const initialState: QuestionIdState = {
  questionId: null,
};

export const QuestionIdSlice = createSlice({
  name: 'questionId',
  initialState,
  reducers: {
    setQuestionId: (state, action: PayloadAction<number>) => {
      state.questionId = action.payload;
    },
  },
});

export const { setQuestionId } = QuestionIdSlice.actions;

export default QuestionIdSlice.reducer;

'use client';

import { styled } from 'styled-components';

export const QuestionBoxGroup = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const QuestionBox = styled.div`
  width: 1024px;
  background-color: #162135;
  /* 페이지에서 설정 */
  /* margin: 50px auto; */
  padding: 1rem;
  border-radius: 12px;
  border: 1px solid #616c7f;
  display: flex;
  flex-direction: column;
  gap: 4px;
  margin: 0.75rem 1rem;
  cursor: pointer;
  &:hover {
    border: 1px solid white;
    background-color: rgba(66, 99, 235, 0.5);
  }
`;

export const BoxTop = styled.div`
  display: flex;
  padding: 0 0.5rem 0 0.5rem;
`;

export const Name = styled.span`
  font-size: 0.75rem;
  color: gray;
`;

export const BoxMiddle = styled.div`
  display: flex;
  padding: 0 0.5rem 0.5rem 0.5rem;
`;

export const Title = styled.h4`
  color: white;
`;

export const BoxBottom = styled.div`
  display: flex;
  justify-content: space-between;
  border-top: 0.1px solid #616c7f;
  padding: 0.5rem 0.5rem 0 0.5rem;
`;

export const Comment = styled.div``;

export const CommentCount = styled.span`
  font-size: 0.75rem;
  margin-left: 4px;
  color: gray;
`;

export const Time = styled.div`
  font-size: 0.75rem;
  color: gray;
`;

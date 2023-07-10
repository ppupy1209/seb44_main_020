'use client';

import { styled } from 'styled-components';

export const TalkPage = styled.div`
  background-color: #111321;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const TalkPageBox = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Header = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 0.5rem;
  padding: 0.5rem;
  max-width: 1024px;
`;

export const Title = styled.h1`
  color: white;
`;

export const ButtonBox = styled.div``;

export const Button = styled.button`
  padding: 12px 24px;
  border-radius: 8px;
  background-color: rgba(66, 99, 235, 0.5);
  &:hover {
    background-color: rgba(255, 255, 255, 0.9);
    color: #111321;
    font-weight: bold;
  }
  cursor: pointer;
  font-weight: bold;
  color: white;
`;

export const QuestionBox = styled.div`
  width: 1024px;
`;

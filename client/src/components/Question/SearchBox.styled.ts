'use client';

import styled from 'styled-components';

export const SearchBoxGroup = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const SearchBox = styled.div`
  margin: 0.75rem 1rem;
  width: 1024px;
  background-color: rgba(255, 255, 255, 0.7);
  border-radius: 4px;
  padding: 1rem;
`;

export const MovieSelector = styled.div``;

export const MoviePickButton = styled.button`
  width: 100%;
  height: 50px;
  margin-bottom: 8px;
  font-weight: bold;
  font-size: medium;
  cursor: pointer;
`;

export const AnswerCreateBox = styled.div`
  height: 152px;
`;

export const Textarea = styled.textarea`
  width: 100%;
  height: 142px;
  resize: none;
`;

export const ButtonBox = styled.div`
  display: flex;
  justify-content: end;
`;

export const Button = styled.button`
  padding: 12px 24px;
  border-radius: 4px;
  width: 100px;
  background-color: #111321;
  &:hover {
    background-color: rgba(108, 99, 255, 0.3);
  }
  cursor: pointer;
  color: white;
`;

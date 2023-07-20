'use client';
import styled from 'styled-components';

export const PageButtonGroup = styled.div`
  display: flex;
  justify-content: center;
  gap: 50px;
  padding-top: 50px;
`;

export const PageButtonBox = styled.li`
  display: inline;
`;

export const PageButton = styled.button`
  background-color: #01123d;
  border: none;
  color: #ffffff;
  width: 30px;
  height: 32px;
  border-radius: 50%;
  &:hover {
    background-color: rgba(158, 169, 219, 0.5);
  }
  &.active {
    background-color: rgba(127, 146, 224, 0.7);
    filter: drop-shadow(1px 1px 7px rgba(127, 146, 224));
  }
`;

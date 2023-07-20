'use client';

import styled from 'styled-components';

export const ModalWrapper = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9999;
`;

export const ModalContent = styled.div`
  background-color: white;
  padding: 2rem;
  color: black;
`;

export const SearchedListBox = styled.div`
  padding: 1rem;
  border: 1px solid red;
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
  width: 384px;
  height: 384px;
  overflow: auto;
  flex-shrink: 0;
`;

export const SearchedMovieBox = styled.div`
  padding: 0.25rem 0.75rem;
  border-left: 4px solid grey;
  &:hover {
    background-color: red;
    cursor: pointer;
  }
  display: flex;
`;

export const SearchedMovieTitle = styled.p`
  padding-top: 0.25rem;
  font-weight: bold;
`;

export const SearchInput = styled.input`
  padding: 0.25rem;
  display: flex;
  flex: 1;
  margin-right: 0.5rem;
`;

export const SearchContainer = styled.div`
  display: flex;
`;

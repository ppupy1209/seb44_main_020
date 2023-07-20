'use client';

import styled from 'styled-components';
export const Body = styled.body`
  hight: 100%
  width: 100%;
`;

// poster
export const MoviesWrapper = styled.main`
  display: flex;
  margin-right: 20px;
`;
export const GridContainer = styled.div`
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: 60px;
  width: 1400px;
  max-width: 100%;
  text-align: center;
`;

export const MovieWrapper = styled.div`
  flex-grow: 1;
`;
export const Poster = styled.img`
  width: 200px;
  height: 230px;
  object-fit: cover;
  grow: 1;
  border radius: 10px;
`;

export const Title = styled.h3`
  margin-top: 10px;
  text-align: center;
`;

export const MovieInfo = styled.ul`
  list-style-type: none;
  padding: 0;
  margin-top: 5px;
  text-align: center;
`;

// Search
export const SearchWrapper = styled.div`
  display: flex;
  justify-content: center;
  padding-bottom: 30px;
`;
export const SearchButton = styled.button`
  width: 10px;
  padding: 8px 16px;
  background-color: #337ab7;
  color: #fff;
  border: none;
  border-radius: 10px;
  font-size: 16px;
  cursor: pointer;
`;
export const SearchInput = styled.input`
  width: 500px;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 10px;
  font-size: 16px;
  text-align: center;
`;
export const SearchIcon = styled.div`
  transform: translateY(-130%);
  cursor: pointer;
  width: 20px;
`;
export const SearchInputWrapper = styled.div`
  position: relative;
`;

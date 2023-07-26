'use client';
import styled, { css } from 'styled-components';

export const Container = styled.div`
  display: flex;
  background-color: #01123d;
  height: 100vh;
`;

export const StyledNav = styled.nav`
  width: 250px;
  height: 100%;
  margin-top: 5px;
  padding-bottom: 20px;
  position: sticky;
  display: flex;
  align-items: center;
  flex-direction: column;
`;
export const Button = styled.div<{ active: boolean }>`
  font-weight: ${(props) => (props.active ? 'bold' : 'normal')};
  margin-top: 10px;
  display: flex;
  font-size: x-large;
  background-color: #01123d;
  cursor: pointer;
  transition: background-color 0.3s ease;
  &:hover {
    color: black;
  }
`;
export const Buttondetail = styled.div<{ active: boolean }>`
  margin-top: 5px;
  display: flex;
  background-color: #01123d;
  font-weight: ${(props) => (props.active ? 'bold' : 'normal')};
  border: 2px solid ${(props) => (props.active ? 'white' : 'none')};
  justify-content: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
  &:hover {
    color: black;
  }
`;

export const Dropdown = styled.div`
  margin-top: 10px;
`;

export const MoviesWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
`;
export const SearchInput = styled.input`
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
`;
export const DropdownWrapper = styled.div`
  position: relative;
`;

export const Dropdown1 = styled.div`
  background-color: #01123d;
  top: 100%;
  left: 0;
  padding: 10px;
  z-index: 1;
`;

export const SliderWrapper = styled.div`
  display: flex;
  align-items: center;
  margin-top: 5px;
  flex-direction: column; /* 수정된 부분 */
`;

export const SliderLabel = styled.span`
  margin-right: 10px;
`;

export const Slider = styled.input`
  flex: 1;
`;

export const SliderValue = styled.span`
  margin-left: 10px;
  
`;

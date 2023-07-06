'use client';

import styled from 'styled-components';
//조정해야할 사이즈나 여백이 있을 때에는 다음과 형식으로 props를 전달하여 주세요.
//속성: ${(props)=>props.속성||'처음 적혀있던 기본값'};

export const Container = styled.div<{ width?: string }>`
  display: flex;
  flex-direction: column;
  width: ${(props) => props.width || '250px'};
  height: auto;
  gap: 5px;
  cursor: pointer;
`;

export const PosterImg = styled.img`
  border-radius: 20px;
`;

export const Title = styled.div`
  display: flex;
  justify-content: center;
  font-size: 20px;
  margin-top: 10px;
  margin-top: 30px;
`;
export const TitleText = styled.div<{ 'font-size'?: string }>`
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  max-width: 230px;
  color: #e2e2e2;
  font-size: ${(props) => props['font-size'] || '20px'};
`;
export const Star = styled.div`
  display: flex;
  justify-content: center;
`;

export const Delete = styled.div`
  position: absolute;
  left: 220px;
  top: 10px;
`;

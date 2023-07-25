'use client';

import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  background-color: #01123d;
  margin: 60px 0 ;
`;

export const Left = styled.div`
  background-color: #01123d;
  width: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1;
`;

export const Right = styled.div`
  margin: 100px 0;
  width: 50%;
  display: flex;
  justify-content: flex-end;
`;

export const Poster = styled.div`
  width: 580px;
  padding-top: 57px;
  display: flex;
  justify-content: center;
  margin: 0 auto;
  overflow: hidden;
`;
export const TextContainer = styled.div``;

export const SmallText = styled.div`
  color: #466093;
  font-size: 20px;
  line-height: 1.5em;
  letter-spacing: 2px;
  display: flex;
  flex-direction: column;
  gap: 15px;
  text-align: center;
`;

export const MidText = styled.div`
  color: #e6e6e6;
  margin-top: 50px;
  font-size: 30px;
  font-weight: 700;
  letter-spacing: 2px;
  text-align: center;
  > span {
    color: #5775f0;
  }
`;

export const LargeText = styled.div`
  color: #ffffff;
  margin-top: 30px;
  font-size: 50px;
  font-weight: bolder;
  letter-spacing: 4px;
  text-align: center;
`;

export const TextBox = styled.div`
  background-color: #0f2663;
  border-radius: 20px;
  padding: 1px;
`;

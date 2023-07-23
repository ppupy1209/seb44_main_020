'use client';

import { styled } from 'styled-components';
import HeaderLogo from '@/assets/questionsvg.svg';

export const PageGroup = styled.div`
  background-color: #01123d;
  /* height: 120vh; */
`;

export const Header = styled.div`
  background-color: #01123d;
`;

export const PageTitleBox = styled.div`
  max-width: 1024px;
  margin: 0 auto;
  padding: 180px 16px;
  display: flex;
  flex-direction: column;
  position: relative;
`;

export const Image = styled(HeaderLogo)`
  position: absolute;
  /* 오른쪽 여백 0 */
  top: 50%;
  right: 0;
  transform: translateY(-50%);
`;

export const Title = styled.h1`
  font-size: 40px;
  color: white;
  text-shadow: -5px 0 0 black;
  margin-bottom: 48px;
`;

export const TitleMessageBox = styled.div`
  color: lightgrey;
  text-shadow: -2px 0 0 black;
`;

export const TitleFirstMsg = styled.p`
  margin-bottom: 12px;
`;

export const TitleSecondMsg = styled.p``;

export const PageBody = styled.div`
  padding-bottom: 3rem;
`;

export const PageBodyContent = styled.div`
  padding: 0 1rem 3rem 1rem;
`;

export const PageBodyItem = styled.div`
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 16px;
  max-width: 832px;
  margin: 0 auto;
  padding: 1rem;
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

export const Search = styled.div`
  width: 100%;
`;

export const SearchTitle = styled.p`
  color: black;
  margin-bottom: 8px;
`;

export const SearchInput = styled.input`
  padding: 16px;
  border-radius: 8px;
  width: 100%;
  border: 1px solid white;
`;

export const Content = styled.div`
  height: 330px;
`;

export const ContentTitle = styled.p`
  color: black;
  margin-bottom: 8px;
`;

export const ContentDescriptionDiv = styled.div`
  margin-bottom: 8px;
`;

export const ContentDescription = styled.span`
  color: dark grey;
  font-size: small;
`;

export const AskTextArea = styled.textarea`
  height: 176px;
  width: 100%;
  padding: 16px;
  border-radius: 8px;
  resize: none;
`;

export const ButtonBox = styled.div`
  display: flex;
  justify-content: flex-end;
`;

export const Button = styled.button`
  padding: 12px 24px;
  border-radius: 8px;
  width: 100px;
  background-color: #01123d;
  &:hover {
    background-color: #6c63ff;
  }
  cursor: pointer;
  color: white;
`;

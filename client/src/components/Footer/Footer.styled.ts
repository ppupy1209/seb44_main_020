'use client';

import styled from 'styled-components';

export const StyledContainer = styled.div`
  position: relative;
  min-height: 20vh;
`;
export const StyledFooter = styled.footer`
  position: absolute;
  bottom: 0;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #01123d;
  color: #bbbbbb;
`;

export const StyledSection = styled.div`
  flex: 1;
  padding: 0 12px;
  display: flex;
  align-items: center;
  color: #bbbbbb;
`;

export const StyledName = styled.div`
  flex-direction: column;
  align-items: center;
  width: 100%;
  padding-left: 50px;
`;

export const StyledGitHub = styled.div`
  flex-direction: column;
  align-items: center;
  width: 100%;
  padding-right: 30px;
`;

export const StyledLink = styled.a`
  color: #bbbbbb;
  text-decoration: none;
`;

export const StyledA = styled.p`
  padding: 0 4px;
  font-size: small;
  color: #bbbbbb;
`;

export const StyledN = styled(StyledA)`
  font-size: large;
`;

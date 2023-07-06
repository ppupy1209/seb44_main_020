import styled from 'styled-components';

export const StyledFooter = styled.footer`
  width: 100%;
  height: 200px;
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

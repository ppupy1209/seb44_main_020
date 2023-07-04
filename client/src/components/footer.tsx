import styled from 'styled-components';

const Footer = () => {
  return (
    <StyledFooter>
      <StyledDiv>
        <StyledName>
          <StyledN>Contributors</StyledN>
          <StyledP>FE 전수빈&nbsp;&nbsp;BE 김민성</StyledP>
          <StyledP>FE 강예현&nbsp;&nbsp;BE 김민성</StyledP>
          <StyledP>FE 안현지&nbsp;&nbsp;BE 김연우</StyledP>
        </StyledName>
      </StyledDiv>
      <StyledDiv>
        <StyledGitHub>
          <StyledN>GitHub</StyledN>
          <StyledP>
            전수빈:&nbsp;
            <StyledLink href="https://github.com/soobbb">
              https://github.com/soobbb
            </StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            김민성:&nbsp;
            <StyledLink href="https://github.com/minseong3">
              https://github.com/minseong3
            </StyledLink>
          </StyledP>
          <StyledP>
            강예현:&nbsp;
            <StyledLink href="https://github.com/YeaHkode">
              https://github.com/YeaHkode
            </StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 김연우:&nbsp;
            <StyledLink href="https://github.com/ppupy1209">
              https://github.com/ppupy1209
            </StyledLink>
          </StyledP>
          <StyledP>
            안현지:&nbsp;
            <StyledLink href="https://github.com/hjthebunny">
              https://github.com/hjthebunny
            </StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp; 정민우:&nbsp;
            <StyledLink href="https://github.com/feebuno">
              https://github.com/feebuno
            </StyledLink>
          </StyledP>
        </StyledGitHub>
      </StyledDiv>
      <StyledDiv>
        <StyledName>
          <StyledN>[FE] Tech Stack</StyledN>
          <StyledP>React Typescript</StyledP>
          <StyledP>StyledComponent</StyledP>
          <StyledP>Redux-tookit Axios</StyledP>
        </StyledName>
      </StyledDiv>
      <StyledDiv>
        <StyledName>
          <StyledN>[BE] Tech Stack</StyledN>
          <StyledP>Java Spring</StyledP>
          <StyledP>Java Spring</StyledP>
          <StyledP>Java Spring</StyledP>
        </StyledName>
      </StyledDiv>
    </StyledFooter>
  );
};

export default Footer;

const StyledFooter = styled.footer`
  width: 100%;
  height: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #01123d;
  color: #bbbbbb;

`;

const StyledDiv = styled.div`
  padding: 0 12px;
  display: flex;
  align-items: center;
  color: #bbbbbb;
`;
const StyledName = styled.div`
  flex-direction: column;
  align-items: center;
  width: 200px;
`;
const StyledGitHub = styled.div`
  flex-direction: column;
  align-items: center;
  width: 440px;
`;

const StyledLink = styled.a`
  color: #bbbbbb;
  text-decoration: none;
`;

const StyledA = styled.p`
  padding: 0 4px;
  font-size: small;
  color: #bbbbbb;
`;
const StyledP = styled(StyledA)``;

const StyledN = styled(StyledA)`
  font-size: large;
`;

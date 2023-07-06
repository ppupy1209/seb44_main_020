import * as Styled from './Footer.styled';
const Footer = () => {
  return (
    <Styled.StyledFooter>
      <Styled.StyledSection>
        <Styled.StyledName>
          <Styled.StyledN>Contributors</Styled.StyledN>
          <Styled.StyledA>FE 전수빈&nbsp;&nbsp;BE 김연우</Styled.StyledA>
          <Styled.StyledA>FE 강예현&nbsp;&nbsp;BE 김민성</Styled.StyledA>
          <Styled.StyledA>FE 안현지&nbsp;&nbsp;BE 정민우</Styled.StyledA>
        </Styled.StyledName>
      </Styled.StyledSection>
      <Styled.StyledSection>
        <Styled.StyledGitHub>
          <Styled.StyledN>GitHub</Styled.StyledN>
          <Styled.StyledA>
            전수빈:&nbsp;
            <Styled.StyledLink href="https://github.com/soobbb">
              soobbb
            </Styled.StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            김연우:&nbsp;
            <Styled.StyledLink href="https://github.com/ppupy1209">
              ppupy1209
            </Styled.StyledLink>
          </Styled.StyledA>
          <Styled.StyledA>
            강예현:&nbsp;
            <Styled.StyledLink href="https://github.com/YeaHkode">
              YeaHkode
            </Styled.StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 김민성:&nbsp;
            <Styled.StyledLink href="https://github.com/minseong3">
              minseong3
            </Styled.StyledLink>
          </Styled.StyledA>
          <Styled.StyledA>
            안현지:&nbsp;
            <Styled.StyledLink href="https://github.com/hjthebunny">
              hjthebunny
            </Styled.StyledLink>
            &nbsp;&nbsp;&nbsp;&nbsp; 정민우:&nbsp;
            <Styled.StyledLink href="https://github.com/feebuno">
              feebuno
            </Styled.StyledLink>
          </Styled.StyledA>
        </Styled.StyledGitHub>
      </Styled.StyledSection>
      <Styled.StyledSection>
        <Styled.StyledName>
          <Styled.StyledN>[FE] Tech Stack</Styled.StyledN>
          <Styled.StyledA>React Typescript</Styled.StyledA>
          <Styled.StyledA>StyledComponent</Styled.StyledA>
          <Styled.StyledA>Redux-tookit Axios</Styled.StyledA>
        </Styled.StyledName>
      </Styled.StyledSection>
      <Styled.StyledSection>
        <Styled.StyledName>
          <Styled.StyledN>[BE] Tech Stack</Styled.StyledN>
          <Styled.StyledA>Java Spring</Styled.StyledA>
          <Styled.StyledA>Java Spring</Styled.StyledA>
          <Styled.StyledA>Java Spring</Styled.StyledA>
        </Styled.StyledName>
      </Styled.StyledSection>
    </Styled.StyledFooter>
  );
};

export default Footer;

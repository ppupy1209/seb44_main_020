import * as Styled from './Footer.styled';
const Footer = () => {
  return (
    <Styled.Wrapper>
      <Styled.Container>
        <Styled.Section>
          <Styled.Title>Contributors @github id</Styled.Title>
          <Styled.Content>
            <Styled.ContentText>
              FE 강예현
              <Styled.GithubId href="https://github.com/YeaHkode">
                @YeaHkode
              </Styled.GithubId>
            </Styled.ContentText>
            <Styled.ContentText>
              FE 안현지
              <Styled.GithubId href="https://github.com/hjthebunny">
                @hjthebunny
              </Styled.GithubId>
            </Styled.ContentText>
            <Styled.ContentText>
              FE 전수빈
              <Styled.GithubId href="https://github.com/soobbb">
                @soobbb
              </Styled.GithubId>
            </Styled.ContentText>
            <Styled.ContentText>
              BE 김민성
              <Styled.GithubId href="https://github.com/minseong3">
                @minseong3
              </Styled.GithubId>
            </Styled.ContentText>
            <Styled.ContentText>
              BE 김연우
              <Styled.GithubId href="https://github.com/ppupy1209">
                @ppupy1209
              </Styled.GithubId>
            </Styled.ContentText>
            <Styled.ContentText>
              BE 정민우
              <Styled.GithubId href="https://github.com/feebuno">
                @feebuno
              </Styled.GithubId>
            </Styled.ContentText>
          </Styled.Content>
        </Styled.Section>
        <Styled.Section>
          <Styled.Title>FE Stacks</Styled.Title>
          <Styled.Content>
            <Styled.ContentText>ReactJS</Styled.ContentText>
            <Styled.ContentText>NextJS</Styled.ContentText>
            <Styled.ContentText>TypeScript</Styled.ContentText>
            <Styled.ContentText>Styled-Components</Styled.ContentText>
            <Styled.ContentText>Redux-Toolkit</Styled.ContentText>
            <Styled.ContentText>Vercel</Styled.ContentText>
          </Styled.Content>
        </Styled.Section>
        <Styled.Section>
          <Styled.Title>BE Stacks</Styled.Title>
          <Styled.Content>
            <Styled.ContentText>Java</Styled.ContentText>
            <Styled.ContentText>mySQL</Styled.ContentText>
            <Styled.ContentText>AWS</Styled.ContentText>
            <Styled.ContentText>JPA</Styled.ContentText>
            <Styled.ContentText>JWT</Styled.ContentText>
            <Styled.ContentText>Spring Boot</Styled.ContentText>
            <Styled.ContentText>Spring Security</Styled.ContentText>
          </Styled.Content>
        </Styled.Section>
      </Styled.Container>
    </Styled.Wrapper>
  );
};

export default Footer;

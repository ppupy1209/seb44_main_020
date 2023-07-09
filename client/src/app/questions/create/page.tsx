'use client';

import { WebEditor } from '@/components/Question/Webeditor';
import * as S from '@/app/questions/create/page.styled';
import { useId, useState } from 'react';

const QuestionCreatePage = () => {
  const [titleValue, setTitleValue] = useState<string>('');
  const [contentValue, setContentValue] = useState<string>('');

  const onSubmit = (event: React.MouseEvent<HTMLButtonElement>) => {
    if (titleValue.length < 5 || titleValue.length > 30) {
      alert('제목은 5자 이상, 30자 이하로 입력해주세요.');
      return;
    }
    if (contentValue.length < 10) {
      alert('내용은 10자 이상 입력해주세요.');
      return;
    }
  };

  return (
    <S.PageGroup>
      <Title />
      <S.PageBody>
        <S.PageBodyContent>
          <S.PageBodyItem>
            <SearchBox value={titleValue} setValue={setTitleValue} />
            <S.Content>
              <S.ContentTitle>
                원하는 영화에 대한 설명을 최대한 자세히 작성해주세요.
              </S.ContentTitle>
              <WebEditor value={contentValue} setValue={setContentValue} />
            </S.Content>
            <S.ButtonBox>
              <S.Button onClick={onSubmit}>질문하기</S.Button>
            </S.ButtonBox>
          </S.PageBodyItem>
        </S.PageBodyContent>
      </S.PageBody>
    </S.PageGroup>
  );
};

const Title = () => {
  return (
    <S.Header>
      <S.PageTitleBox>
        <S.Image />
        <S.Title>인생 영화를 찾고 싶으신가요?</S.Title>
        <S.TitleMessageBox>
          <p>
            회원님의 취향에 꼭 맞는 영화를 MoovDa 회원들에게 추천받아보세요!
          </p>
          <p>몇 가지 정보만 입력하시면 인생 영화를 찾을 수 있어요.</p>
        </S.TitleMessageBox>
      </S.PageTitleBox>
    </S.Header>
  );
};

interface SearchBoxProps {
  value: string;
  setValue: (nextValue: string) => void;
}

const SearchBox = ({ value, setValue }: SearchBoxProps) => {
  const titleId = useId();

  const onChangeSearchTitle = (event: React.ChangeEvent<HTMLInputElement>) => {
    const title = event.target.value;
    setValue(title);
  };

  return (
    <S.Search>
      <label htmlFor={titleId}>
        <S.SearchTitle>어떤 영화를 추천받고 싶은지 입력해주세요.</S.SearchTitle>
      </label>
      <S.SearchInput
        type="text"
        id={titleId}
        value={value}
        onChange={onChangeSearchTitle}
        placeholder="예: 추석에 온 가족이 같이 볼 수 있는 영화 추천해주세요"
      />
    </S.Search>
  );
};

export default QuestionCreatePage;

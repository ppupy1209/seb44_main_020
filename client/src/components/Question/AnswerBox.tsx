import * as S from '@/components/Question/AnswerBox.styled';

const AnswerBox = () => {
  return (
    <S.AnswerBox>
      <AnswerBoxTop />
      <S.AnswerBoxMid>
        <S.ContentBox>
          <div>내용</div>
        </S.ContentBox>
      </S.AnswerBoxMid>
      <AnswerBoxBottom />
    </S.AnswerBox>
  );
};

const AnswerBoxTop = () => {
  return (
    <S.BoxTop>
      <S.LeftBox>
        <div>닉네임</div>
        <div>time</div>
      </S.LeftBox>
      <S.RightBox>
        <button>수정</button>
        <button>삭제</button>
      </S.RightBox>
    </S.BoxTop>
  );
};

const AnswerBoxBottom = () => {
  return (
    <S.BoxBottom>
      <S.SelectedMovieBox>
        <div>포스터</div>
        <S.MovieInfo>
          <p>제목</p>
          <p>개봉년도</p>
        </S.MovieInfo>
      </S.SelectedMovieBox>
    </S.BoxBottom>
  );
};

export default AnswerBox;

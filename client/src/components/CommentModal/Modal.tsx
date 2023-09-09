'use client';
import React, { useState, useCallback } from 'react';
import { useParams } from 'next/navigation';
import axios from 'axios';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import { close } from '@/redux/features/commentSlice';
import { selectStar } from '@/redux/features/starSlice';
import { getContent } from '@/redux/features/commentSlice';
import CloseIcon from '@/assets/close.svg';
import * as S from './Modal.styled';

export function CommentModal() {
  const { movieId } = useParams();
  const selectedStar = useSelector(
    (state: RootState) => state.star.selectedStar,
  );
  const contentToEdit = useSelector(
    (state: RootState) => state.comment.content,
  );
  const commentID = useSelector((state: RootState) => state.comment.commentId);
  const [newComment, setNewComment] = useState(contentToEdit);
  const dispatch = useDispatch();

  const handleClose = () => {
    dispatch(close());
    dispatch(getContent(''));
  };

  const handleAddComent = useCallback(() => {
    if (selectedStar !== 0 && selectedStar !== null) {
      if (
        newComment?.length &&
        newComment.length >= 10 &&
        newComment.length <= 40
      ) {
        axios
          .post(
            `${process.env.NEXT_PUBLIC_API_URL}/comments/${movieId}`,
            { content: newComment, star: selectedStar },
            {
              headers: {
                'Content-Type': 'application/json',
                Authorization: localStorage.getItem('Authorization'),
              },
            },
          )
          .then(() => {
            alert('코멘트가 등록되었습니다');
            dispatch(close());
            location.reload();
          })
          .catch((error) => {
            console.log(error.message);
          });
      } else {
        alert('코멘트는 10글자 이상 40글자 이하로 작성해야 합니다.');
      }
    } else {
      alert('별점을 입력해야 합니다.');
    }
  }, [movieId, newComment, selectedStar]);

  const handleUpdate = useCallback(() => {
    if (
      newComment?.length &&
      newComment.length >= 10 &&
      newComment.length <= 40
    ) {
      axios
        .patch(
          `${process.env.NEXT_PUBLIC_API_URL}/comments/${commentID}`,
          { content: newComment, star: selectedStar },
          {
            headers: {
              'Content-Type': 'application/json',
              Authorization: localStorage.getItem('Authorization'),
            },
          },
        )
        .then(() => {
          alert('코멘트가 수정되었습니다');
          dispatch(close());
          dispatch(getContent(''));
          location.reload();
        })
        .catch((error) => {
          console.log(error.message);
        });
    } else {
      alert('코멘트는 10글자 이상 40글자 이하로 작성해야 합니다.');
    }
  }, [commentID, newComment, selectedStar]);

  return (
    <S.ModalBackdrop>
      <S.ModalContainer>
        <S.CloseBtn onClick={handleClose}>
          <CloseIcon />
        </S.CloseBtn>
        <S.StarrateWrapper>
          <Starrate />
        </S.StarrateWrapper>
        <S.Content
          placeholder="코멘트 입력 (10자 이상 40자 이하)"
          value={newComment}
          onChange={(e: {
            target: { value: React.SetStateAction<string | undefined> };
          }) => setNewComment(e.target.value)}
        ></S.Content>
        <S.SubmitBtn onClick={contentToEdit ? handleUpdate : handleAddComent}>
          등록
        </S.SubmitBtn>
      </S.ModalContainer>
    </S.ModalBackdrop>
  );
}

function Starrate() {
  const dispatch = useDispatch();

  const starValues = [5, 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0.5];

  const handleClick = (star: number) => {
    dispatch(selectStar(star));
  };
  return (
    <S.StarratingWrapper>
      <S.Starrating>
        <S.Text>별점 주기</S.Text>
        <S.StarArr>
          {starValues.map((value, index) => (
            <React.Fragment key={index}>
              <S.Input
                type="radio"
                name="reviewStar"
                value={value}
                id={`rate${index + 1}`}
                onClick={() => handleClick(value)}
              />
              <label htmlFor={`rate${index + 1}`}>
                {index % 2 === 0 ? <RightStar /> : <LeftStar />}
              </label>
            </React.Fragment>
          ))}
        </S.StarArr>
      </S.Starrating>
    </S.StarratingWrapper>
  );
}

function RightStar() {
  return (
    <S.RightStar
      viewBox="0 0 5 10"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M9.25064e-05 2.14372e-05C0.149555 -0.00107946 0.296263 0.0402428 0.42318 0.119189C0.550096 0.198136 0.652012 0.311467 0.717093 0.446021L1.82809 2.69802L4.31409 3.05902C4.46196 3.08033 4.60091 3.14261 4.7152 3.23882C4.82949 3.33503 4.91455 3.46132 4.96077 3.60339C5.00698 3.74545 5.01248 3.89762 4.97666 4.04266C4.94084 4.18769 4.86513 4.3198 4.75809 4.42402L2.95809 6.17702L3.38309 8.65302C3.40837 8.8001 3.39201 8.95131 3.33586 9.08957C3.2797 9.22784 3.186 9.34764 3.06533 9.43544C2.94465 9.52323 2.80183 9.57553 2.653 9.58641C2.50416 9.5973 2.35525 9.56633 2.22309 9.49702L9.25064e-05 8.32802V2.14372e-05Z"
        fill="black"
      />
    </S.RightStar>
  );
}

function LeftStar() {
  return (
    <S.LeftStar
      viewBox="0 0 5 10"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M4.99991 2.14372e-05C4.85044 -0.00107946 4.70374 0.0402428 4.57682 0.119189C4.4499 0.198136 4.34799 0.311467 4.28291 0.446021L3.17191 2.69802L0.685907 3.05902C0.538041 3.08033 0.399094 3.14261 0.284803 3.23882C0.170513 3.33503 0.0854451 3.46132 0.0392343 3.60339C-0.00697652 3.74545 -0.0124841 3.89762 0.0233356 4.04266C0.0591553 4.18769 0.134871 4.3198 0.241907 4.42402L2.04191 6.17702L1.61691 8.65302C1.59163 8.8001 1.60799 8.95131 1.66414 9.08957C1.7203 9.22784 1.814 9.34764 1.93467 9.43544C2.05535 9.52323 2.19817 9.57553 2.347 9.58641C2.49584 9.5973 2.64475 9.56633 2.77691 9.49702L4.99991 8.32802V2.14372e-05Z"
        fill="black"
      />
    </S.LeftStar>
  );
}

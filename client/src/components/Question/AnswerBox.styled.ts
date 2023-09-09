'use client';

import styled from 'styled-components';

export const AnswerBoxGroup = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const AnswerBox = styled.div`
  background-color: #334163;
  width: 1024px;
  border-radius: 12px;
  margin: 1rem;
  padding: 1rem;
  border-top: 0.5px solid #8a97ab;
`;

export const BoxTop = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: 0.5px solid #8a97ab;
`;

export const LeftBox = styled.div`
  display: flex;
  gap: 8px;
  margin: 0px 0px 8px 8px;
`;

export const Nickname = styled.p`
  display: flex;
  align-items: center;
  cursor: pointer;
  color: white;
  font-size: 0.75rem;
`;

export const Time = styled.p`
  color: #8a97ab;
  font-size: 0.75rem;
  display: flex;
  align-items: center;
`;

export const RightBox = styled.div`
  display: flex;
  gap: 8px;
  margin: 0px 8px 8px 0px;
`;

export const EditBtn = styled.button`
  width: 28px;
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0);
  border-color: rgba(255, 255, 255, 0);
  color: white;
  font-size: 0.75rem;
`;

export const DeleteBtn = styled.button`
  width: 28px;
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0);
  border-color: rgba(255, 255, 255, 0);
  color: white;
  font-size: 0.75rem;
`;

export const AnswerBoxMid = styled.div`
  margin: 12px 8px 0px 8px;
`;

export const ContentBox = styled.div``;

export const BoxBottom = styled.div`
  margin: 16px 8px 0px 0px;
`;

export const SelectedMovieBox = styled.div`
  display: flex;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 4px;
  width: 32%;
  padding: 0.5rem;
  gap: 12px;
  cursor: pointer;
  border-left: 10px solid #111321;
`;

export const Poster = styled.div`
  display: flex;
  height: 64px;
`;

export const MovieInfo = styled.div`
  font-size: 0.75rem;
  margin-top: 2px;
  display: flex;
  flex-direction: column;
  gap: 4px;
`;

export const MovieTitle = styled.p`
  margin-top: 0.25rem;
  font-weight: 700;
  color: black;
`;

export const MovieReleaseDate = styled.p`
  color: #5d5d5d;
`;

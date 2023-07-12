'use client';

import styled from 'styled-components';

export const Container=styled.div`
width:500px;
height: 300px;
background-color:white;`;

export const Wrapper=styled.div`
padding:30px;
position: relative;
border: 1px solid black;
height: 100%;
`;

export const Top=styled.div`
display:flex;
padding-bottom: 20px;
border-bottom: 1px solid black;
position: relative;
border: 1px solid black;
`;

export const Left=styled.div``;

export const Nickname=styled.div``;

export const CreatedAt=styled.div``;

export const Right=styled.div`
position:absolute;
right:0;`;

export const starrate=styled.div``;

export const Content=styled.div`
margin-top:20px;`;

export const Bottom=styled.div`
position: relative;
display:flex;
bottom: 0;
margin-bottom: 30px;
gap:10px;
`;
// export const BottomWrapper=styled.div`
// position:relative;
// `;

export const LikeBtn=styled.div``;

export const BtnWrapper=styled.div`
display: flex;
gap: 10px;
position: absolute;
right: 0;
`;

export const EditBtn=styled.button`
width:100px`;

export const DeleteBtn=styled(EditBtn)``;
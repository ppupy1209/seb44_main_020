'use client';

import styled from 'styled-components';

export const Container=styled.div`
width:400px;
height: 300px;
background-color:white;
padding:30px;
border-radius:10px;
`;

export const Wrapper=styled.div`
position: relative;
/* border: 1px solid black; */
height: 100%;
display:flex;
flex-direction: column;
justify-content: space-between;
`;

export const Top=styled.div`
display:flex;
padding-bottom: 20px;
border-bottom: 1px solid black;
/* border: 1px solid black; */
`;

export const Left=styled.div``;

export const Nickname=styled.div``;

export const CreatedAt=styled.div``;

export const Right=styled.div`
position:absolute;
right:0;`;

export const starrate=styled.div``;

export const Content=styled.div`
margin:20px 0;
/* border: 1px solid black; */
flex:1;`;

export const Bottom=styled.div`
/* border: 1px solid black; */
display:flex;
position:relative;
align-items: center;
`;

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
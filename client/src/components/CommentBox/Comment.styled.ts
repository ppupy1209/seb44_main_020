'use client';

import styled from 'styled-components';

export const Container=styled.div`
width:350px;
height: 300px;
background-color:rgba(239,239,239,0.6);
border: 1.5px solid #ffffff;
padding:30px;
border-radius:10px;
color: #01123D;
&:hover{
    background-color: #ffffff;
}
`;

export const Wrapper=styled.div`
position: relative;
height: 100%;
display:flex;
flex-direction: column;
justify-content: space-between;
`;

export const Top=styled.div`
display:flex;
padding-bottom: 15px;
border-bottom: 1px solid black;
`;

export const Left=styled.div`
display:flex;
flex-direction:column;
gap:10px;`;

export const Nickname=styled.div`
font-weight: bold;
cursor: pointer;
`;

export const CreatedAt=styled.div`
font-size:14px;`;

export const Right=styled.div`
position:absolute;
right:0;
display:flex;
align-items:center;
gap:10px;`;

export const StarIcon=styled.div``

export const starrate=styled.div``;

export const Content=styled.div`
margin:20px 0;
flex:1;`;

export const Bottom=styled.div`
display:flex;
position:relative;
align-items: center;
`;
export const LikeWrapper=styled.div`
display:flex;
gap: 10px;
`;

export const LikeBtn=styled.div`
cursor: pointer;
>svg{fill:#E7E7E7;
&:hover{
fill:#E96E75;
}}
&.liked{
    >svg{
        fill:#E96E75;
    }
}`;

export const LikeCount=styled.div`
font-size:14px`;

export const BtnWrapper=styled.div`
display: flex;
gap: 10px;
position: absolute;
right: 0;
`;

export const EditBtn=styled.button`
width:50px;
border:none;
background-color:transparent;
cursor: pointer;`;

export const DeleteBtn=styled(EditBtn)``;
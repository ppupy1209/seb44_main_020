'use client'
import styled from 'styled-components';

export const Wrapper=styled.div`
margin: 50px 90px 50px 90px;
`;

export const MovieInfoWrapper=styled.div`
display:flex;
justify-content:center;
gap:100px;`;

export const PosterStar=styled.div`
width: fit-content;
display:flex;
flex-direction: column;
text-align:center;
gap:40px;`;

export const PosterImg=styled.img`
width:350px;
height:auto;
border-radius:20px;`

export const MyStar=styled.div`
display:flex;
align-items:center;
justify-content:center;
gap:20px;`;

export const MystarIcon=styled.div``;
export const MyStarNum=styled.div`
color:#00FFD1;`;

export const MovieInfo=styled.div`
position: relative;
`;

export const Title=styled.h1`
letter-spacing:2px;
font-size:40px ;
max-width: 400px;
`;

export const DetailWrapper=styled.div`
margin-top: 40px;
display:flex;
flex-direction:column;
gap:10px;
`;

export const DateAndCountry=styled.div``;

export const Genre=styled.div``;

export const RunningTime=styled.div``;

export const StarAvg=styled.div`
width:100px;
height:100px;
background-color:#9EA9D8;
position:absolute;
right:0;
display:flex;
gap:10px;
flex-direction:column;
justify-content:center;
align-items:center;`;

export const avNum=styled.div`
font-size:30px;
color: #01123D;
font-weight:bold;`;

export const avText=styled.div`
color: #01123D;
font-size: 14px;
`;

export const Summary=styled.div`
border-top:1px solid #283A6D;
padding-top: 40px;
margin-top: 40px;
width:600px;
line-height: 1.5em;
text-align: justify;
`;

export const ToWatchBtn=styled.button`
display: flex;
gap: 10px;
justify-content: center;
align-items: center;
height:40px;
padding: 10px;
width: 200px;
background-color: #283A6D;
border: 2px solid #5973B6;
border-radius:5px;
color: #ffffff;
cursor: pointer;
font-weight: 400;
&:hover{
    background-color:#5973B6 ;
    border: 2px solid #283A6D; 
}`;

export const WatchedBtn=styled(ToWatchBtn)``;

export const BtnWrapper=styled.div`
margin-top: 50px;
display:flex;
gap:20px;
`;

export const SectionWrapper=styled.div`
margin-top: 40px;
border-top: 1px solid #466093;
padding-top: 40px;
color: #466093;`;

export const SectionContainer=styled.div`
margin:0 50px;`;

export const SectionTitle=styled.h2``;

export const StaffList=styled.div`
margin: 50px ;
display: grid;
grid-template-columns: repeat(4, 1fr);
place-items:center;
grid-gap:60px;`;

export const CommentList=styled(StaffList)`
display:grid;
grid-template-columns: repeat(3, 1fr);
place-items:center;
grid-gap:60px;`;

export const PageButtonGroup = styled.div`
  display: flex;
  justify-content: center;
  gap: 10px;
`;

export const PageButtonBox = styled.li`
  display: inline;
`;

export const PageButton = styled.button`
background-color: #01123D;
border: none;
color: #ffffff;
width: 30px;
height: 32px;
border-radius: 50%;
&:hover {
    background-color: rgba(158,169,219,0.5);
}
&.active{
    background-color: rgba(127,146,224,0.7);
    filter:drop-shadow(1px 1px 7px rgba(127,146,224))
}

`;

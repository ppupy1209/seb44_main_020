import styled from 'styled-components';

export const Container=styled.div<{height?:string}>`
  display: flex;
  flex-direction: column;
  width: ${(props)=>props.height||'250px'};
  height: auto;
    
`;


export const PosterImg=styled.img`
    border-radius: 20px;
`;

export const Title = styled.div`
display: flex;
justify-content: center;
font-size: 20px;
margin-top: 10px;

`;
export const TitleText=styled.div`
overflow: hidden;
white-space: nowrap;
text-overflow: ellipsis;
max-width: 230px;
`;
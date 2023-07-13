import styled from 'styled-components'

export const ModalBackdrop=styled.div`
  position: fixed; 
  top: 0; bottom: 0; left: 0; right:0;
  background: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 5;`

export const CloseBtn = styled.div`
position: absolute;
right: 24px;
top: 24px;
color: black;
cursor: pointer;
`;

export const ModalContainer=styled.div`
width:500px;
height:450px;
background-color:white;
border-radius: 10px;
position: relative;
`
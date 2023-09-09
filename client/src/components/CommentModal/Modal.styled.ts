import styled from 'styled-components'

export const ModalBackdrop=styled.div`
  position: fixed; 
  top: 0; bottom: 0; left: 0; right:0;
  background: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 5;`

export const ModalContainer=styled.div`
width:500px;
height:450px;
background-color:#1F305F;
border-radius: 10px;
position: relative;
display: flex;
flex-direction: column;
justify-content: space-between;
align-items: center;
padding: 30px;
box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.75);
`

export const CloseBtn = styled.div`
position: absolute;
right: 30px;
top: 24px;
cursor: pointer;
`;

export const StarrateWrapper=styled.div`
width: 100%;
height:20%;
border-radius: 5px; 
display:flex;
justify-content:center;
align-items:center;`

export const Content=styled.textarea`
width: 100%;
height: 60%;
border-radius: 5px;
background-color:#01123D;
color:white;
padding: 10px;
resize:none;
border:none;
&:focus{
  outline: 2px solid #466093;
}`

export const SubmitBtn=styled.button`
height:10%;
width:100%;
border-radius: 5px;
background-color: #466093;
border: 2px solid #5973B6;
color: #ffffff;
cursor: pointer;
 &:hover{
    background-color:#5973B6 ;
     border: 2px solid #283A6D; 
     }
`
export const StarratingWrapper=styled.form`
width:100%;
`
export const Starrating=styled.div`
display:flex;
justify-content: center;
align-items: center;
position: relative;
`

export const Text=styled.div`
position: absolute;
left: 0;
margin-left:10px;`;

export const StarArr=styled.div`
display:flex;
flex-direction: row-reverse;
>label:hover{
>svg{
>path{fill:#00FFD1;}
}
}
>label:hover~label{
>svg{
>path{fill:#00FFD1}
}
}
`

export const LeftStar=styled.svg`
  width: 15px;
  height: 30px;
`
export const RightStar=styled(LeftStar)`
margin-right: 10px;
`

export const Input =styled.input`
display:none;
&:checked~label{
  >svg{
>path{fill:#00FFD1;}
}
}`

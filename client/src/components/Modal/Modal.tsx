'use client'
import * as S from './Modal.styled'
import { useDispatch} from 'react-redux';
import { close } from '@/redux/features/commentSlice';
import CloseIcon from '@/assets/close.svg'
import EmptyStar from '@/assets/emptyStar.svg'
import HalfStar from '@/assets/halfStar.svg'
import FullStar from '@/assets/fullStar.svg'

import { useState } from 'react';


export function CommentModal(){
const dispatch=useDispatch();
const handleClose=()=>{
    dispatch(close())
}
    return(
        <S.ModalBackdrop>
<S.ModalContainer>
    <S.CloseBtn onClick={handleClose}><CloseIcon/></S.CloseBtn>
    <S.StarrateWrapper><Starrate /></S.StarrateWrapper>
    <S.Content>코멘트 내용</S.Content>
    <S.SubmitBtn>등록</S.SubmitBtn>
</S.ModalContainer>
        </S.ModalBackdrop>
    )
}

function Starrate(){
    const arr=[1,2,3,4,5];
    const stars=arr.map((i)=>(
        <EmptyStar key={i} width="40" height="40"/>
    ))
    return(
        <S.Starrating>
            <S.Text>별점 주기</S.Text>
            <S.Star>{stars}</S.Star>
        </S.Starrating>
    )

}

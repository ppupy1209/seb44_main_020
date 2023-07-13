'use client'
import * as S from './Modal.styled'
import { useDispatch} from 'react-redux';
import { close } from '@/redux/features/commentSlice';


export function CommentModal(){
const dispatch=useDispatch();
const handleClose=()=>{
    dispatch(close())
}
    return(
        <S.ModalBackdrop>
<S.ModalContainer>
    <S.CloseBtn onClick={handleClose}>X</S.CloseBtn>
</S.ModalContainer>
        </S.ModalBackdrop>
    )
}
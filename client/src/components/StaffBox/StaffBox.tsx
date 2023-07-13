'use client'
import * as S from './StaffBox.styled'

interface Props {
    data: {
      position?:string;
      role?: string;
      name?: string;
    };
  }

export function StaffBox({data}:Props) {
    return(
        <S.Container>
            <S.Name>{data.name}</S.Name>
            <S.Role>{data.role?(`${data.position} | ${data.role}`):(`${data.position}`)}</S.Role>
        </S.Container>
    )
}
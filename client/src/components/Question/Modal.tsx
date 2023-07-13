'use client';

import React, { useState } from 'react';
import * as S from '@/components/Question/Modal.styled';
import Link from 'next/link';
import { usePathname } from 'next/navigation';

const Modal = () => {
  const pathname = usePathname();

  return (
    <S.ModalGroup>
      <S.ModalBox>
        모달창
        <Link href={pathname} replace>
          <button>Close Modal</button>
        </Link>
      </S.ModalBox>
    </S.ModalGroup>
  );
};

export default Modal;

'use client';

import React, { useState } from 'react';
import * as S from '@/components/Question/Modal.styled';

interface ModalProps {
  isOpen: boolean;
  closeModal: () => void;
}

const Modal = ({ isOpen, closeModal }: ModalProps) => {
  if (!isOpen) {
    return;
  }

  return (
    <S.ModalGroup>
      <S.ModalBox>
        모달창
        <button onClick={closeModal}>Close Modal</button>
      </S.ModalBox>
    </S.ModalGroup>
  );
};

export default Modal;

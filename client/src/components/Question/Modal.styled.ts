'use client';

import styled from 'styled-components';

export const ModalGroup = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9999;
`;

export const ModalBox = styled.div`
  background-color: white;
  padding: 2rem;
  color: black;
`;

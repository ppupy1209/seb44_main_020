import React from 'react';
import * as S from './Pagination.styled';

interface PaginationProps {
  pageNumbers: number[];
  currentPage: number;
  setCurrentPage: React.Dispatch<React.SetStateAction<number>>;
  handlePreviousPage: () => void;
  handleNextPage: () => void;
  fetchDataWithPage: (page: number) => void;
}

const Pagination: React.FC<PaginationProps> = ({
  pageNumbers,
  currentPage,
  setCurrentPage,
  handlePreviousPage,
  handleNextPage,
  fetchDataWithPage,
}) => {
  const handleClick = (pageNumber: number): void => {
    setCurrentPage(pageNumber);
    fetchDataWithPage(pageNumber);
  };

  return (
    <div>
      <nav>
        <S.PageButtonGroup>
          <S.PageButtonBox onClick={handlePreviousPage}>
            <S.PageButton>&lt;</S.PageButton>
          </S.PageButtonBox>
          {pageNumbers.map((pageNumber) => (
            <S.PageButtonBox
              key={pageNumber}
              onClick={() => handleClick(pageNumber)}
            >
              <S.PageButton
                className={currentPage === pageNumber ? 'active' : ''}
              >
                {pageNumber}
              </S.PageButton>
            </S.PageButtonBox>
          ))}
          <S.PageButtonBox onClick={handleNextPage}>
            <S.PageButton>&gt;</S.PageButton>
          </S.PageButtonBox>
        </S.PageButtonGroup>
      </nav>
    </div>
  );
};

export default Pagination;

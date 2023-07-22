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
  const MAX_PAGES_DISPLAYED = 10; // 표시되는 최대 페이지 번호 수
  const handleClick = (pageNumber: number): void => {
    setCurrentPage(pageNumber);
    fetchDataWithPage(pageNumber);
  };

  // 표시할 페이지 번호 로직
  const getPageRange = (): number[] => {
    if (currentPage <= MAX_PAGES_DISPLAYED / 2) {
      return pageNumbers.slice(0, MAX_PAGES_DISPLAYED);
    } else if (currentPage >= pageNumbers.length - MAX_PAGES_DISPLAYED / 2) {
      return pageNumbers.slice(pageNumbers.length - MAX_PAGES_DISPLAYED);
    } else {
      const start = currentPage - Math.floor(MAX_PAGES_DISPLAYED / 2);
      const end = currentPage + Math.ceil(MAX_PAGES_DISPLAYED / 2) - 1;
      return pageNumbers.slice(start - 1, end);
    }
  };

  const pageRange = getPageRange();

  return (
    <div>
      <nav>
        <S.PageButtonGroup>
          <S.PageButtonBox onClick={handlePreviousPage}>
            <S.PageButton>&lt;</S.PageButton>
          </S.PageButtonBox>
          {/* 이미 범위에 있지 않은 경우 첫 번째 페이지 번호 표시 */}
          {pageRange[0] !== 1 && (
            <S.PageButtonBox onClick={() => handleClick(1)}>
              <S.PageButton>1</S.PageButton>
            </S.PageButtonBox>
          )}
          {/* 첫 번째 페이지 번호가 1이 아닌 경우 줄임표 표시 */}
          {pageRange[0] > 2 && <span>...</span>}
          {/* 범위의 페이지 번호 표시 */}
          {pageRange.map((pageNumber) => (
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
          {/* 마지막 페이지 번호가 마지막 페이지가 아닌 경우 줄임표 표시 */}
          {pageRange[pageRange.length - 1] < pageNumbers.length - 1 && (
            <span>...</span>
          )}
          {/* 이미 범위에 있지 않은 경우 마지막 페이지 번호 표시 */}
          {pageRange[pageRange.length - 1] !== pageNumbers.length && (
            <S.PageButtonBox onClick={() => handleClick(pageNumbers.length)}>
              <S.PageButton>{pageNumbers.length}</S.PageButton>
            </S.PageButtonBox>
          )}
          <S.PageButtonBox onClick={handleNextPage}>
            <S.PageButton>&gt;</S.PageButton>
          </S.PageButtonBox>
        </S.PageButtonGroup>
      </nav>
    </div>
  );
};

export default Pagination;

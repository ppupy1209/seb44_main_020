import React from 'react';
import GlobalStyle from './Globalstyle';

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { MainPage } from './pages/Home/MainPage/MainPage';
import { MyPage } from './pages/Membership/MyPage/MyPage';
import { LoginPage } from './pages/Membership/LoginPage/LoginPage';
import { SignupPage } from './pages/Membership/SignupPage/SignupPage';
import { SearchPage } from './pages/Search/SearchPage/SearchPage';
import { QuestionCreatePage } from './pages/Question/QuestionCreatePage/QuestionCreatePage';
import { QuestionDetailPage } from './pages/Question/QuestionDetailPage/QuestionDetailPage';
import { QuestionListPage } from './pages/Question/QuestionListPage/QuestionListPage';
import { MovieDetailPage } from './pages/Detail/MovieDetailPage/MovieDetailPage';

function App() {
  return (
    <>
    <GlobalStyle />
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/members/mypage" element={<MyPage />} />
        <Route path="/members/login" element={<LoginPage />} />
        <Route path="/members/signup" element={<SignupPage />} />
        <Route path="/moives/search" element={<SearchPage />} />
        <Route path="/questions/ask" element={<QuestionCreatePage />} />
        <Route path="/questions/detail" element={<QuestionDetailPage />} />
        <Route path="/questions/list" element={<QuestionListPage />} />
        <Route path="/movies" element={<MovieDetailPage />} />
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;

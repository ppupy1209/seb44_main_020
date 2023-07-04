import React from 'react';
import GlobalStyle from './Globalstyle';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import { MainPage } from './pages/Home/MainPage/MainPage';
import { MyPage } from './pages/Membership/MyPage/MyPage';
import { LoginPage } from './pages/Membership/LoginPage/LoginPage';
import { SignupPage } from './pages/Membership/SignupPage/SignupPage';
import { SearchPage } from './pages/Search/SearchPage/SearchPage';
import { QuestionCreatePage } from './pages/Question/QuestionCreatePage/QuestionCreatePage';
import { QuestionDetailPage } from './pages/Question/QuestionDetailPage/QuestionDetailPage';
import { QuestionListPage } from './pages/Question/QuestionListPage/QuestionListPage';
import { MovieDetailPage } from './pages/Detail/MovieDetailPage/MovieDetailPage';
import { Root } from './pages/Root/Root';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Root />,
    errorElement: <MainPage />,
    children: [
      { index: true, element: <MainPage /> },
      { path: 'members/mypage', element: <MyPage /> },
      { path: 'members/login', element: <LoginPage /> },
      { path: 'members/signup', element: <SignupPage /> },
      { path: 'moives/search', element: <SearchPage /> },
      { path: 'questions/ask', element: <QuestionCreatePage /> },
      { path: 'questions/detail', element: <QuestionDetailPage /> },
      { path: 'questions/list', element: <QuestionListPage /> },
      { path: 'movies', element: <MovieDetailPage /> },
    ],
  },
]);
function App() {
  return (
    <>
      <GlobalStyle />
      <RouterProvider router={router} />;
    </>
  );
}

export default App;

import { Outlet } from 'react-router-dom';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import { StyledRoot } from '../../styles/style';
export const Root = () => {
  return (
    <StyledRoot >
      <Header />
      <Outlet />
      <Footer />
    </StyledRoot>
  );
};

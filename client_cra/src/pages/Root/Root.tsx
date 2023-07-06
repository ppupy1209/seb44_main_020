import { Outlet } from 'react-router-dom';
import Header from '../../../../client/src/components/Header/Header';
import Footer from '../../../../client/src/components/Footer/Footer';
import { StyledRoot } from '../../../../client/src/styles/style';
export const Root = () => {
  return (
    <StyledRoot>
      <Header />
      <Outlet />
      <Footer />
    </StyledRoot>
  );
};

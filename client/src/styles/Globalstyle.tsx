'use client';

import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
*{    
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
body{
    color: white;
    background-color: #01123d;
}
a {
    text-decoration: none;
}
`;

export default GlobalStyle;

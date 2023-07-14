import NextAuth, { Session } from 'next-auth';
import GoogleProvider from 'next-auth/providers/google';
import { setUser, setToken } from '../../../../redux/features/authSlice';
import { useDispatch } from 'react-redux';
import CredentialsProvider from 'next-auth/providers/credentials';

const handler = NextAuth({
  providers: [
    GoogleProvider({
      clientId: process.env.GOOGLE_CLIENT_ID || '',
      clientSecret: process.env.GOOGLE_CLIENT_SECRET || '',
      authorization: {
        params: {
          prompt: 'consent',
          access_type: 'offline',
          response_type: 'code',
        },
      },
    }),
  ],
  // callbacks: {
  //   async jwt({ token, account, profile, member }) {
  //     if (account) {
  //       token.accessToken = account.access_token;
  //       token.id = profile.id;
  //     }
  //     return token;
  //   },
  //   async session({ session, token }: any) {
  //     if (session) {
  //       session.accessToken = token.accessToken;
  //     }
  //     return session;
  //   },
  // },
});

export { handler as GET, handler as POST };

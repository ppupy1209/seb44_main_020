"use client";

import MoovDa from "@/assets/moovdaLogo.svg";
import {
  faMagnifyingGlass,
  faPen,
  faRightToBracket,
  faUser,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Image from "next/image";
import { useRouter } from "next/router";
import {
  StyledHeader,
  StyledIconAsk,
  StyledIconMyPage,
  StyledIconSearch,
  StyledLog,
  StyledLogo,
} from "./Header.styled";

const Header = () => {
  const router = useRouter();

  return (
    <StyledHeader>
      <StyledLogo>
        <Image src={MoovDa} alt="Logo" />
      </StyledLogo>
      <StyledIconSearch>
        <FontAwesomeIcon
          icon={faMagnifyingGlass}
          style={{ color: "white" }}
          size="xl"
          onClick={() => router.push("/moives/search")}
        />
      </StyledIconSearch>
      <StyledIconAsk>
        <FontAwesomeIcon
          icon={faPen}
          style={{ color: "white" }}
          size="xl"
          onClick={() => router.push("questions/ask")}
        />
      </StyledIconAsk>
      <StyledIconMyPage>
        <FontAwesomeIcon
          icon={faUser}
          style={{ color: "white" }}
          size="xl"
          onClick={() => router.push("members/mypage")}
        />
      </StyledIconMyPage>
      <StyledLog>
        <FontAwesomeIcon
          icon={faRightToBracket}
          style={{ color: "white" }}
          size="xl"
          onClick={() => router.push("members/login")}
        />
      </StyledLog>
    </StyledHeader>
  );
};

export default Header;

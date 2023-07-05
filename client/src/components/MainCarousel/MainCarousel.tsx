import React from "react";
import Slider from "react-slick";
import "./slick.css";
import "./slick-theme.css";

interface CarouselProps{
    props:JSX.Element[];
}
export default function MainCarousel({props}:CarouselProps){
    const settings = {
        className: "center",
        centerMode: true,
        centerPadding: "0",
        fade:true,
        // dots: true,
        infinite: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        pauseOnHover:true
    };
    return(
<Slider {...settings}>{props}</Slider>
    );
}
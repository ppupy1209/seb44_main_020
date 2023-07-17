'use client';
import { useDispatch} from 'react-redux';
import React from 'react';
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import { StyledSlider } from './MyCarousel.styled';
import {dragOn, dragOff} from '@/redux/features/dragSlice'

interface CarouselProps {
  props?: JSX.Element[];
}
export default function MyCarousel({ props }: CarouselProps) {
    
    const dispatch=useDispatch();

    const handleDraOn=()=>{
      dispatch(dragOn());
    }
    const handleDragOff=()=>{
      dispatch(dragOff())
    }
    
  const settings = {
    infinite: false,
    speed: 500,
    slidesToShow: 5,
    slidesToScroll: 5,
    beforeChange:handleDraOn,
    afterChange:handleDragOff,
  };
  return <StyledSlider {...settings}>{props}</StyledSlider>;
}
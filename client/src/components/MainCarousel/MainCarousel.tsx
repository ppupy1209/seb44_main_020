'use client';

import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '@/redux/store';
import Slider from 'react-slick';
import './slick.css';
import './slick-theme.css';
import {dragOn, dragOff} from '@/redux/features/dragSlice'

interface CarouselProps {
  props: JSX.Element[];
}
export default function MainCarousel({ props }: CarouselProps) {

  const dispatch=useDispatch();

  const handleDraOn=()=>{
    dispatch(dragOn());
  }
  const handleDragOff=()=>{
    dispatch(dragOff())
  }


  const settings = {
    className: 'center',
    centerMode: true,
    centerPadding: '80px',
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 2000,
    pauseOnHover: true,
    arrows: false,
    beforeChange:handleDraOn,
    afterChange:handleDragOff,
  };

  return <Slider {...settings}>{props}</Slider>;
}

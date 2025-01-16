import React, { useEffect, useState } from 'react';
import './App.css'
import RecepieNavbar from './Components/Navbar';
import RecepieCard from './Components/RecepieCard';
import FilterNavbar from './Components/FilterNavbar';
import { getRecipeById } from './api';



function HomePage() {

  

  return (
    <>
      <RecepieNavbar/>
      <FilterNavbar/>
      <div className='CardHolder'>
      <RecepieCard/>
      <RecepieCard/>
      <RecepieCard/>
      </div>
      
    </>
  );
}

export default HomePage;

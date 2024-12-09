import React from 'react';
import './App.css'
import RecepieNavbar from './Components/Navbar';
import RecepieCard from './Components/RecepieCard';
import FilterNavbar from './Components/FilterNavbar';

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

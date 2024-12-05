import React from 'react';
import './App.css'
import RecepieNavbar from './Components/Navbar';
import RecepieCard from './Components/RecepieCard';

function HomePage() {
  return (
    <>
      <RecepieNavbar/>
      <div className='CardHolder'>
      <RecepieCard/>
      </div>
      
    </>
  );
}

export default HomePage;

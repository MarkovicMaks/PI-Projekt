import React, { useEffect, useState } from 'react';
import './App.css'
import RecepieNavbar from './Components/Navbar';
import RecepieCard from './Components/RecepieCard';
import FilterNavbar from './Components/FilterNavbar';
import axios from "axios"

function HomePage() {

  const [users, setUsers] = useState( []);
  
  useEffect(()=>{
    loadUsers();
  },[]);
  
  const loadUsers = async () => {
  const result = await axios.get ("http://localhost:8080/users");
  console. log(result);
  console. log("Above");
  };

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

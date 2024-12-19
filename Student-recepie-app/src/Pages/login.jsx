import React from 'react';
import '../App.css'
import RecepieNavbar from '../Components/Navbar';
import LoginForm from '../Components/LoginWindow';
function Login() {
  return (
    <>
      
      <div className='SvgBackground'>
      <RecepieNavbar/>
      <LoginForm/>
      </div>
    </>
  );
}

export default Login;
import React from "react";
import "../App.css";
import RecepieNavbar from "../Components/Navbar";
import LoginWindow from "../Components/LoginWindow";
function Login() {
  return (
    <>
      <div className="SvgBackground">
        <RecepieNavbar />
        <div className="LoginCardHolder">
          <LoginWindow />
        </div>
      </div>
    </>
  );
}

export default Login;

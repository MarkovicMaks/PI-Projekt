import React from "react";
import "../App.css";
import RecepieNavbar from "../Components/Navbar";
import RegertrationWindow from "../Components/RegistrationWindow";

function Register() {
  return (
    <>
      <div className="SvgBackground LoginBackgroundimage">
        <RecepieNavbar />
        <div className="LoginCardHolder">
          <RegertrationWindow />
        </div>
      </div>
    </>
  );
}

export default Register;

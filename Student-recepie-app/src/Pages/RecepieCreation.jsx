import React from "react";
import "../App.css";
import RecepieNavbar from "../Components/Navbar";
import CreateWindow from "../Components/CreateRecepie";

function RecepieCreation() {
  return (
    <div className="SvgBackground createBackgroundImege">
      <RecepieNavbar />
      <div className='LoginCardHolder'>
        <CreateWindow/>
      </div>
    </div>
  );
}

export default RecepieCreation;

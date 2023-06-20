import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import NavBar from "./NavBar";

function BasicExample() {
  return (
    <>
      <NavBar></NavBar>

      <div className="jumbotron">
        <div className="mini-jumbotron mt-5">
          <h2>ciao</h2>
          <p>ciao</p>
        </div>
      </div>
    </>
  );
}

export default BasicExample;

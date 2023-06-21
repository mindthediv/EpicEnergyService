import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import Footer from "./Footer"; // Importa il componente Footer
import NavBar from "./NavBar";

function BasicExample() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <>
      <NavBar />
      
      <Footer /> 
    </>
  );
}

export default BasicExample;
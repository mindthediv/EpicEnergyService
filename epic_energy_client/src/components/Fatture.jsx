import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import Footer from "./Footer"; // Importa il componente Footer
import NavBar from "./NavBar";

function BasicExample() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  fetch('https://localhost:api.example.com/data')
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    console.log('Received data:', data);
    // Do something with the received data
  })
  .catch(error => {
    console.error('Error:', error);
    // Handle any errors that occurred during the request
  });

  return (
    <>
      <NavBar />
      
      <Footer />
    </>
  );
}

export default BasicExample;
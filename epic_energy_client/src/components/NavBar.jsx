import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Offcanvas from "react-bootstrap/Offcanvas";
import { AiTwotoneSetting } from "react-icons/ai";
import { Link } from "react-router-dom";
import Logo from "../img/Logo.png";

function Barra() {
    const [showOffcanvas, setShowOffcanvas] = useState(false);
    const [user, setUser] = useState(null);


  const handleOffcanvasClose = () => setShowOffcanvas(false);
  const handleOffcanvasShow = () => setShowOffcanvas(true);

  const userName = localStorage.getItem("username ");
  const token = window.localStorage.getItem("token");

  async function login(userName) {
    try {
      const response = await fetch("http://localhost8080/api/auth/all",
       {
               headers: {
                 Authentication: "Bearer" + token,
             },});
      if(response.ok) {
        let data = await response;
        console.log("sono l oggetto user")
        setUser(data)
      }
    }
      catch (error) {

      }
    }

    useEffect(() => {
      login(userName)
      console.log(userName);
  //     fetch("http://localhost:8080/api/auth/province/all", {
  //       headers: {
  //         Authentication: "Bearer" + token,
  //       },
  //     })
  //       .then((response) => {
  //         if (!response.ok) {
  //           throw new Error("Network response was not ok");
  //         }
  //         return response.json();
  //       })
  //       .then((province) => {
  //         setProvince(province); // Update the state with the fetched data
  //         console.log(province);
  //       })
  //       .catch((error) => {
  //         console.error("Error:", error);
  //         // Handle any errors that occurred during the request
  //       });
     }, []); // Empty dependency array to ensure the effect runs only once
  // const token = window.localStorage.getItem("token");
  


  return (
    <>
      <Navbar
        expand="lg"
        className="p-0 m-0 fixed-top navbar"
        style={{ height: "70px" }}
      >
        <Container fluid className="p-0 m-0">
          <Navbar.Brand href="#home">
            <img
              src={Logo}
              width="100"
              height="100"
              className="d-inline-block align-top"
              alt="React Bootstrap logo"
            />
          </Navbar.Brand>
          <Navbar.Brand href="#home" className="text-light">
            EPIC ENERGY SERVICE
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/home" className="text-light">
                Home
              </Nav.Link>
              <Nav.Link href="/fatture" className="text-light">
                Fatture
              </Nav.Link>
            </Nav>
            <Nav>
              <Nav.Link
                className="text-light"
                onClick={handleOffcanvasShow}
              ></Nav.Link>
            </Nav>
          </Navbar.Collapse>
          <p>{user != null ? (user.userName) : "" }</p> 
          <Button variant="transparent" className="me-2">
            <AiTwotoneSetting onClick={handleOffcanvasShow} className="fs-4" />
          </Button>
          <Offcanvas
            show={showOffcanvas}
            onHide={handleOffcanvasClose}
            placement="end"
            className="canvas"
          >
            <Offcanvas.Header closeButton>
              <Offcanvas.Title className="mx-auto fw-bold">IMPOSTAZIONI</Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
            <hr />

              <Link className="text-decoration-none" to="/login-page">
                <Nav.Link href="#link" className="text-light fs-3">
                  Login
                </Nav.Link>
                <hr className="text-light"/>

              </Link>{" "}
              <Link className="text-decoration-none" to="/register-page">
              <Nav.Link href="#link" className="text-light fs-3">
                  Registrati
                </Nav.Link>
              </Link>{" "}
              <hr />

            </Offcanvas.Body>
          </Offcanvas>
        </Container>
      </Navbar>
    </>
  );
}

export default Barra;
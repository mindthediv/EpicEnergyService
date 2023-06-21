// backdrop-filter: blur(10px);
//   background: rgba(0, 0, 0, 0.461) !important;
import React, { useState } from "react";
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

  const handleOffcanvasClose = () => setShowOffcanvas(false);
  const handleOffcanvasShow = () => setShowOffcanvas(true);

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
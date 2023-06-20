import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import Logo from "../img/Logo.png";

function BasicExample() {
  return (
    <Navbar expand="lg" className="p-0 m-0 fixed-top navbar" style={{height: '70px'}}>
      <Container fluid className="p-0 m-0">
        <Navbar.Brand href="#home">
          <img
            src={Logo}
            width="100"
            height="100"
            className="d-inline-block align-top"
            alt="React Bootstrap logo"
          />
        </Navbar.Brand>{" "}
        <Navbar.Brand href="#home" className="text-light">EPIC ENERGY SERVICE</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home" className="text-light">Home</Nav.Link>
            <Nav.Link href="#link" className="text-light">Link</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default BasicExample;

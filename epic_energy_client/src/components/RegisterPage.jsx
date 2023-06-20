import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import InputGroup from "react-bootstrap/InputGroup";
import { Link } from "react-router-dom";

function RegisterPage() {
  const [validated, setValidated] = useState(false);

  const handleSubmit = (event) => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }

    setValidated(true);
  };

  return (
    <Form
      noValidate
      validated={validated}
      onSubmit={handleSubmit}
      className="w-50 mx-auto mt-5"
    >
      <Form.Group
        md="4"
        controlId="validationCustom01"
        className="w-50 mx-auto"
      >
        <Form.Label>First name</Form.Label>
        <Form.Control
          required
          type="text"
          placeholder="First name"
        />
        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
      </Form.Group>
      <Form.Group
        md="4"
        controlId="validationCustom02"
        className="w-50 mx-auto"
      >
        <Form.Label>Last name</Form.Label>
        <Form.Control
          required
          type="text"
          placeholder="Last name"
        />
        <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
      </Form.Group>
      <Form.Group
        md="4"
        controlId="validationCustomUsername"
        className="w-50 mx-auto"
      >
        <Form.Label>Username</Form.Label>
        <InputGroup hasValidation>
          <Form.Control
            type="text"
            placeholder="Username"
            aria-describedby="inputGroupPrepend"
            required
          />
          <Form.Control.Feedback type="invalid">
            Please choose a username.
          </Form.Control.Feedback>
        </InputGroup>
      </Form.Group>

      <Form.Group
        md="6"
        controlId="validationCustom03"
        className="w-50 mx-auto"
      >
        <Form.Label>City</Form.Label>
        <Form.Control type="text" placeholder="City" required />
        <Form.Control.Feedback type="invalid">
          Please provide a valid city.
        </Form.Control.Feedback>
      </Form.Group>
      <Form.Group
        md="3"
        controlId="validationCustom04"
        className="w-50 mx-auto"
      >
        <Form.Label>State</Form.Label>
        <Form.Control type="text" placeholder="State" required />
        <Form.Control.Feedback type="invalid">
          Please provide a valid state.
        </Form.Control.Feedback>
      </Form.Group>
      <Form.Group
        md="3"
        controlId="validationCustom05"
        className="w-50 mx-auto"
      >
        <Form.Label>Zip</Form.Label>
        <Form.Control type="text" placeholder="Zip" required />
        <Form.Control.Feedback type="invalid">
          Please provide a valid zip.
        </Form.Control.Feedback>
      </Form.Group>

      <Form.Group className="mb-3">
        <Form.Check
          required
          label="Agree to terms and conditions"
          feedback="You must agree before submitting."
          feedbackType="invalid"
        />
      </Form.Group>
      <Button type="submit">Registrati</Button>
      <p>o</p>
      <Button >
        {" "}
        <Link to="/login-page" className="text-light text-decoration-none">
          Login
        </Link>
      </Button>
      <Link to="/login-page" className="nav-link">
              <div className="text-secondary">Already registered? Login!</div>
            </Link>
    </Form>
  
  );
}

export default RegisterPage;

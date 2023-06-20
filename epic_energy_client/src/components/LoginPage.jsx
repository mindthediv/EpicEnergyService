import 'bootstrap/dist/css/bootstrap.min.css';
import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import { Link } from "react-router-dom";


function LoginPage() {
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
    <Form noValidate validated={validated} onSubmit={handleSubmit} className='w-50 mx-auto mt-5'>
      
        <Form.Group as={Col} md="4" controlId="validationCustom01" className='mx-auto '>
          <Form.Label>Username</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="First name"
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
        <Form.Group as={Col} md="4" controlId="validationCustom02" className='mx-auto'>
          <Form.Label>Password</Form.Label>
          <Form.Control
            required
            type="password"
            placeholder="Password"
          />
          <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
        </Form.Group>
      <Button type="submit" className='mx-5 mt-5'>Login</Button>
      <Button type="submit" className='mx-5 mt-5'> <Link to="/register-page" className='text-light text-decoration-none'>Registrati</Link></Button>
    </Form>
  );
}

export default LoginPage;
import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import { Link } from "react-router-dom";


function LoginPage() {
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
    <div className="centered-container">
    <form className="form">
      <p className="title text-center fs-3">Login</p>
      <div className="flex">
        <label>
          <input required placeholder="" type="text" className="input" />
          <span>Usertname</span>
        </label>

        <label>
          <input required placeholder="" type="text" className="input" />
          <span>Password</span>
        </label>
      </div>
      <button className="submit"><Link to="/home" className="text-decoration-none text-light">Login</Link></button>
      <p className="signin">
        don't have an account? <Link to="/register-page">Signup</Link>
      </p>
    </form>
    </div>
  );
}

export default LoginPage;

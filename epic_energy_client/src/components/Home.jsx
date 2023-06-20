import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import nrg from "../img/energy2.jpeg";
import NavBar from "./NavBar";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

function BasicExample() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <>
      <NavBar></NavBar>

      <div className="jumbotron">
        <div className="mini-jumbotron text-light">
          <h1 className="text-center pt-5 fw-bold">
            Siamo qui per cambiare il mondo!
          </h1>
          <br />
          <br />
          <h2 className="text-center">
            Leader nel settore dell'energia rinnovabile con 50.000 sedi in
            Italia e all'estero
          </h2>
        </div>
      </div>
      <div className="article d-flex m-4 text-light">
        <div className="articleTitle d-block mx-4">
          <h2 className="m-2">Titolo articolo</h2>
          <img src={nrg} alt="" width="500" height="200" />
        </div>
        <div className="paragrafo d-block m-3">
          <p className="columns mt-5 fs-5 fw-bold">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias
            ea delectus, quam perferendis autem voluptatem sed debitis corporis
            sequi nam animi adipisci eos omnis repellat temporibus voluptatibus
            harum excepturi consequuntur.
          </p>
        </div>
      </div>

      <div className="article d-flex m-4 text-light">
        <Button variant="primary" onClick={handleShow}>
          Launch demo modal
        </Button>

        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form>
              <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                />
              </Form.Group>
              <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Example textarea</Form.Label>
                <Form.Control as="textarea" rows={3} />
              </Form.Group>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button variant="primary" onClick={handleClose}>
              Save Changes
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    </>
  );
}

export default BasicExample;

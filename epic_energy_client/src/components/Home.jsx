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

      <div className="article m-4 text-light">
        <h1>Prova le offerte</h1>
        <h2>Non perdere le offerte se sei un nuovo cliente</h2>
        <img className="mx-4" src="data:image/jpeg;base64,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" alt="" />
        <Button variant="primary" onClick={handleShow}>
          inviaci i dati
        </Button>

        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form>
              <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Inserisci i tuoi dati</Form.Label>
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="email"
                  placeholder="name@example.com"
                  autoFocus
                  className="mt-3"
                />
              </Form.Group>
              
            </Form>
          </Modal.Body>
          <Modal.Footer>
            
            <Button variant="primary" onClick={handleClose}>
              Invia i dati
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    </>
  );
}

export default BasicExample;

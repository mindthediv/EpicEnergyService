import "bootstrap/dist/css/bootstrap.min.css";
import React, { useEffect, useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Modal from "react-bootstrap/Modal";
import nrg from "../img/energy2.jpeg";
import servizi2 from "../img/servizi2.jpeg";
import servizi3 from "../img/servizi3 copia.jpeg";
import servizi from "../img/servizio.jpeg";
import NavBar from "./NavBar";

function BasicExample() {
  const [show, setShow] = useState(false);
  const token = window.localStorage.getItem("token");

  const [province, setProvince] = useState(null);
  const [municipality, setMunicipality] = useState(null);
  const [selectedProvince, setSelectedProvince] = useState(null);

  //mostra/nascondi modale
  const handleClose = () => setShow(false);
  const handleShow = function () {
    // fetch("http://localhost:8080/api/auth/province/all", {
    //   headers: {
    //     Authentication: "Bearer" + token,
    //   },
    // })
    //   .then((response) => {
    //     if (!response.ok) {
    //       throw new Error("Network response was not ok");
    //     }
    //     return response.json();
    //   })
    //   .then((data) => {
    //     console.log("Received data:", data);
    //     setProvince(data);
    //     console.log(province)
    //   })
    //   .catch((error) => {
    //     console.error("Error:", error);
    //     // Handle any errors that occurred during the request
    //   });

    setShow(true);
  };
  //indirizzo dal modale
  const [formCustomer, setCustomer] = useState({
    companyName: "",
    iva: "",
    email: "",
    pec: "",
    phone: "",
    customerType: "", //dropdown SPA ecc
    user_id: "",
    address: {
      street: "", //a mano
      houseNumber: "", //a mano
      country: "",
      cap: "",
      municipality_id: "", // dropdown
    },
  });
  const handleSubmit = async (event) => {
    event.preventDefault();
    event.stopPropagation();
    handleClose();
  };
  const handleProvinceChange = (event) => {
    setSelectedProvince(event.target.value)
    console.log(selectedProvince);
    handleMunicipality(selectedProvince);
    // Call handleMunicipality or perform any other necessary operations based on the selected province
  };
  const handleChange = (event) => {
    setCustomer({
      ...formCustomer,
      [event.target.name]: event.target.value,
    });
  };
  const handleMunicipality = function (p) {
    // const provincia = p.target.value;
    // console.log(provincia)
    fetch("http://localhost:8080/api/municipality", {
      headers: {
        Authentication: "Bearer" + token,
      },
      body: JSON.stringify(p)
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((municipality) => {
        setMunicipality(municipality); // Update the state with the fetched data
        console.log(municipality);
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle any errors that occurred during the request
      });
  };
  useEffect(() => {
    fetch("http://localhost:8080/api/auth/province/all", {
      method: 'GET',
      headers: {
        Authentication: "Bearer" + token,
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((province) => {
        setProvince(province); // Update the state with the fetched data
        console.log(province);
      })
      .catch((error) => {
        console.error("Error:", error);
        // Handle any errors that occurred during the request
      });
  }, []); // Empty dependency array to ensure the effect runs only once
  return (
    <>
      <NavBar></NavBar>

      <div className="jumbotron">
        <div className="text-light">
          <h1 className="text-center pt-5 fw-bold">
            Siamo qui per cambiare il mondo!
          </h1>
          <h2 className="text-center mt-5">
            Leader nel settore dell'energia rinnovabile con 50.000 sedi in
            Italia e all'estero
          </h2>
        </div>
      </div>

      <div className="article d-flex mt-5 mx-5 text-light">
        <div className="articleTitle d-block mx-4">
          <h2 className="m-2">Scegli EPIC ENERGY SERVICE</h2>
          <img
            src={nrg}
            alt=""
            width="500"
            height="200"
            className="immagine-home"
          />
        </div>
        <div
          className="paragrafo d-block m-3 overflow-auto"
          style={{ maxHeight: "300px" }}
        >
          <p className="columns fs-5 fw-bold">
            Epic Energy Service è una compagnia elettrica che si distingue per
            offrire un'energia pulita e sostenibile. L'azienda si impegna a
            fornire energia proveniente da fonti rinnovabili, come l'energia
            solare, eolica e idroelettrica, riducendo così l'impatto ambientale
            rispetto alle fonti tradizionali di produzione energetica. Ciò che
            rende Epic Energy Service particolarmente interessante per le
            imprese è la sua flessibilità nell'adesione. Infatti, l'azienda
            offre la possibilità di iscriversi sia come titolare di partita IVA
            che come azienda. Questo significa che non solo le imprese possono
            beneficiare dell'energia pulita offerta da Epic Energy Service, ma
            possono anche usufruire di agevolazioni fiscali e vantaggi specifici
            per le aziende. Attraverso l'iscrizione a Epic Energy Service, le
            imprese possono dimostrare il loro impegno per la sostenibilità e
            l'ambiente, riducendo al contempo la loro impronta di carbonio.
            Inoltre, l'utilizzo di energia pulita può anche essere un vantaggio
            competitivo, poiché sempre più consumatori sono alla ricerca di
            aziende che adottano pratiche sostenibili. Epic Energy Service si
            impegna a fornire un servizio affidabile e di qualità alle aziende
            che scelgono di diventare clienti. L'azienda offre soluzioni
            personalizzate per soddisfare le esigenze energetiche specifiche di
            ciascuna impresa, consentendo loro di ottimizzare i costi energetici
            e di contribuire alla transizione verso un futuro più sostenibile.
            In conclusione, Epic Energy Service rappresenta una compagnia
            elettrica che si distingue per il suo impegno a fornire energia
            pulita e sostenibile. Attraverso la sua flessibilità
            nell'iscrizione, offre alle imprese la possibilità di sostenere
            l'ambiente e beneficiare di agevolazioni fiscali, posizionandosi
            così come una scelta interessante per coloro che desiderano adottare
            un approccio sostenibile all'energia.
          </p>
        </div>
      </div>

      <div className="article2 mt-5 mx-5 text-light">
        <h1 className="text-center mb-3">
          Non perdere le offerte se sei un nuovo cliente
        </h1>
        <div className="immagini d-flex">
          <img
            className="mx-4 img-fluid"
            src={servizi}
            alt="servizi"
            style={{ width: "300px" }}
          />
          <img
            className="mx-4 img-fluid"
            src={servizi2}
            alt="servizi"
            style={{ width: "300px" }}
          />
          <img
            className="mx-4 img-fluid"
            src={servizi3}
            alt="servizi"
            style={{ width: "300px" }}
          />
        </div>

        <Button className="button-article mt-3 mx-4" onClick={handleShow}>
          Inviaci i dati
        </Button>
        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form>
              <Form.Group
                className="mb-3"
                controlId="exampleForm.ControlInput1"
              >
                <Form.Label>Inserisci i tuoi dati</Form.Label>
                <Form.Control
                  type="companyName"
                  placeholder="Nome Azienda"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="iva"
                  placeholder="Iva"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="email"
                  placeholder="Email"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="pec"
                  placeholder="Pec"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  type="number"
                  placeholder="Telefono"
                  autoFocus
                  className="mt-3"
                />
                <Form.Control
                  as="select"
                  type="customerType"
                  placeholder="Tipo Cliente"
                  autoFocus
                  className="mt-3"
                >
                  <option value="PA">PA</option>
                  <option value="SAS">SAS</option>
                  <option value="SPA">SPA</option>
                  <option value="SRL">SRL</option>
                </Form.Control>
                <Form.Label className="mt-3">Indirizzo</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Via"
                  name="street"
                  className="mt-3"
                />
                <Form.Control
                  type="text"
                  placeholder="Numero civico"
                  name="houseNumber"
                  className="mt-3"
                />
                <Form.Control
                  type="text"
                  placeholder="Paese"
                  name="country"
                  className="mt-3"
                />
                <Form.Control
                  type="text"
                  placeholder="CAP"
                  name="cap"
                  className="mt-3"
                />
                <Form.Control as="select" className="mt-3" name="province" onChange={handleProvinceChange}>
                  <option value="">Seleziona provincia:</option>
                  {province != null ? (
                    province.map((p) => (
                      <option value={p}>{p.sign}</option>
                    ))
                  ) : (
                    <option>1</option>
                  )}
                </Form.Control>
                <Form.Control as="select" className="mt-3" name="municipality">
                  <option value="">Seleziona un comune:</option>
                  {municipality != null ? (
                    municipality.map((m) => (
                      <option value={m.id}>{m.name}</option>
                    ))
                  ) : (
                    <option>1</option>
                  )}
                </Form.Control>
              </Form.Group>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            <Button type="submit" variant="primary" onClick={handleSubmit}>
              Invia i dati
            </Button>
          </Modal.Footer>
        </Modal>
      </div>
    </>
  );
}

export default BasicExample;

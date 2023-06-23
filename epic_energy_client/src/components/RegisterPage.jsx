import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../img/logonobg.png";

function RegisterPage() {
  
  
  const [validated, setValidated] = useState(false);
  const [formData, setFormData] = useState({
    nome: "",
    cognome: "",
    userName: "",
    email: "",
    password: "",
    contactPhone: ""
  });

  const handleSubmit = async (event) => {
    event.preventDefault();
    event.stopPropagation();

    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      setValidated(true);
      return;
    }

    try {
      const response = await fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      });

      if (response.ok) {
        console.log("Registrazione avvenuta con successo");
        alert("Registrazione avviata con successo");

      } else {
        console.log("Errore durante la registrazione " + formData );
        alert("Errore durante la registrazione");

      }
    } catch (error) {
      console.log("Si è verificato un errore durante la richiesta di registrazione");
      alert(error);
    }
  };

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value
    });
  };

  return (
    <div>
      <Link to="/home">
        <img
          src={Logo}
          width="70"
          height="70"
          className="d-inline align-top m-4"
          alt="React Bootstrap logo"
          style={{ position: "fixed" }}
        />
      </Link>
      <div className="centered-container">
        <form className="form" onSubmit={handleSubmit} noValidate validated={validated}>
          <p className="title text-center fs-3">Registrati</p>
          <p className="message">Registrati e accedi a tutti gli utilizzi dell'app:</p>
          <div className="flex">
            <label>
              <input
                required
                placeholder=""
                type="text"
                className="input"
                name="nome"
                value={formData.nome}
                onChange={handleChange}
              />
              <span>Nome</span>
            </label>
            <label>
              <input
                required
                placeholder=""
                type="text"
                className="input"
                name="cognome"
                value={formData.cognome}
                onChange={handleChange}
              />
              <span>Cognome</span>
            </label>
          </div>
          <label>
            <input
              required
              placeholder=""
              type="text"
              className="input"
              name="userName"
              value={formData.userName}
              onChange={handleChange}
            />
            <span>UserName</span>
          </label>
          <label>
            <input
              required
              placeholder=""
              type="email"
              className="input mt-3"
              name="email"
              value={formData.email}
              onChange={handleChange}
            />
            <span>Email</span>
          </label>
          <label>
            <input
              required
              placeholder=""
              type="password"
              className="input mt-3"
              name="password"
              value={formData.password}
              onChange={handleChange}
            />
            <span>Password</span>
          </label>
          <label>
            <input
              required
              placeholder=""
              type="text"
              className="input mt-3"
              name="contactPhone"
              value={formData.contactPhone}
              onChange={handleChange}
            />
            <span>Telefono</span>
          </label>
          <button className="submit mt-4">Conferma</button>
          <p className="signin">
            Hai già un account? <Link to="/login-page">Accedi</Link>
          </p>
        </form>
      </div>
    </div>
  );
}

export default RegisterPage;

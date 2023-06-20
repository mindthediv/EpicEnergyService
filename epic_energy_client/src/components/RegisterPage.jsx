import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../img/logonobg.png";

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
    <div>
      <Link to="/home">
        <img
          src={Logo}
          width="70"
          height="70"
          className="d-inline align-top m-4"
          alt="React Bootstrap logo"
          style={{position:"fixed"}}
        />
        </Link>
    <div className="centered-container">
      
      <form className="form " onSubmit={handleSubmit}>
        <p className="title text-center fs-3">Registrati</p>
        <p className="message">Registrati e accedi a tutti gli utilizzi dell'app:</p>
        <div className="flex">
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>Nome</span>
          </label>
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>Cognome</span>
          </label>
        </div>
        
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>UserName</span>
          </label>
          <label>
          <input required placeholder="" type="email" className="input mt-3" />
          <span>Email</span>
        </label>
        <label>
          <input required placeholder="" type="password" className="input mt-3" />
          <span>Password</span>
        </label>
       
        <button className="submit mt-4">Conferma</button>
        <p className="signin">
         Hai gia un account? <Link to="/login-page">Accedi</Link>
        </p>
      </form>
    </div>
  </div>
  );
}

export default RegisterPage;

import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import { Link } from "react-router-dom";
import Logo from "../img/logonobg.png";

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
      <div className="centered-container w-100">
        <form className="form">
          <p className="title text-center fs-3">Login</p>
          <div className="flex">
            <label>
              <input required placeholder="" type="text" className="input" />
              <span>UserName</span>
            </label>

            <label>
              <input required placeholder="" type="text" className="input" />
              <span>Password</span>
            </label>
          </div>
          <button className="submit">
            <Link to="/home" className="text-decoration-none text-light">
              Login
            </Link>
          </button>
          <p className="signin">
            Non hai un account? <Link to="/register-page">Registrati</Link>
          </p>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
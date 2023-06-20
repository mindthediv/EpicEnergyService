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

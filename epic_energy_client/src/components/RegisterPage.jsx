import React, { useState } from "react";
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
    <div className="centered-container">
      <form className="form " onSubmit={handleSubmit}>
        <p className="title text-center fs-3">Register</p>
        <p className="message">Signup now and get full access to our app.</p>
        <div className="flex">
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>Firstname</span>
          </label>
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>Lastname</span>
          </label>
        </div>
          <label>
            <input required placeholder="" type="text" className="input" />
            <span>Username</span>
          </label>
        <label>
          <input required placeholder="" type="email" className="input" />
          <span>Email</span>
        </label>

        <label>
          <input required placeholder="" type="password" className="input" />
          <span>Password</span>
        </label>
        <button className="submit mt-4">Submit</button>
        <p className="signin">
          Already have an account? <Link to="/login-page">Sign in</Link>
        </p>
      </form>
    </div>

  );
}

export default RegisterPage;

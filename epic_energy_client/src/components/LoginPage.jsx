import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Logo from "../img/logonobg.png";

function LoginPage() {

  const [formData, setFormData] = useState({
    userName: "",
    password: "",
  });


  const navigate = useNavigate();

  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        let data = await response.json();
        console.log("Login successful" + data.accessToken);
        window.localStorage.setItem("token", data.accessToken);
        navigate("/home");
      } else {
        console.log("Login failed");
        alert("Username or password wrong!");
      }
    } catch (error) {
      console.log("An error occurred while logging in");
      alert(error);
    }
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
      <div className="centered-container w-100">
        <form className="form" onSubmit={handleSubmit}>
          <p className="title text-center fs-3">Login</p>
          <div className="flex">
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
                type="password"
                className="input"
                name="password"
                value={formData.password}
                onChange={handleChange}
              />
              <span>Password</span>
            </label>
          </div>
          <button type="submit" className="submit">
              Login
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

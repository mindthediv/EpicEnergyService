import React from "react";
import "./App.css";
import LoginPage from "./components/LoginPage";
import RegisterPage from "./components/RegisterPage";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  async function fetchTest() {
    try {
      const response = await fetch("http://localhost:8080/api/test");
      if (response.ok) {
        let { data } = await response;
        console.log("sto loggando " + data);
      }
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/register-page" element={<RegisterPage />} />
          <Route path="/login-page" element={<LoginPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

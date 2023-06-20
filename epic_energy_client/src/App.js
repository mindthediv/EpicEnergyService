import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer";
import Home from "./components/Home";
import LoginPage from "./components/LoginPage";
import RegisterPage from "./components/RegisterPage";

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
            <Route path="/home" element={<Home />} />
          </Routes>
          <Footer />

        </BrowserRouter>
      </div>
    );
  }
  
  export default App;
  
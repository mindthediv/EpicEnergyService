import React from 'react';
import "./App.css";
import LoginPage from './components/LoginPage';
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
        <RegisterPage/>
        <LoginPage/>
    </div>
  );
}

export default App;

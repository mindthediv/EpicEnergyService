import React from "react";
import "./App.css";

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
      <header className="App-header">
        <button onClick={() => fetchTest()}>ClickMe</button>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;

import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import nrg from "../img/energy2.jpeg";
import NavBar from "./NavBar";

function BasicExample() {
  return (
    <>
      <NavBar></NavBar>

      <div className="jumbotron">
        <div className="mini-jumbotron text-light">
          <h1 className="text-center pt-5 fw-bold">Siamo qui per cambiare il mondo!</h1>
          <br />
          <br />
          <h2 className="text-center">Leader nel settore dell'energia rinnovabile con 50.000 sedi in Italia e all'estero</h2>
        </div>
      </div>
      
      <div className="article d-flex m-4 text-light">

          <div className="articleTitle d-block mx-4">
          <h2 className="m-2">Titolo articolo</h2>

          <img src={nrg} alt=""
           width="500"
           height="200"
          
           
           />

          </div>
          <div className="paragrafo d-block m-3">
            <p className="columns mt-5 fs-5 fw-bold">Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias ea delectus, quam perferendis autem voluptatem sed debitis corporis sequi nam animi adipisci eos omnis repellat temporibus voluptatibus harum excepturi consequuntur.</p>
          </div>
      </div>
    </>
  );
}

export default BasicExample;

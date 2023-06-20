import React from "react";

const Footer = () => {
  return (
    <footer style={{ textAlign: "center", padding: "10px"}}>
      <p>&copy; {new Date().getFullYear()} Il tuo nome o nome dell'azienda. Tutti i diritti riservati.</p>
    </footer>
  );
};

export default Footer;

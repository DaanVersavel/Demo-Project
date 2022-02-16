import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";

//import axios from "axios";

function App() {
  return (
    <div>

      <h1 style={{color: "grey"}}>Film database</h1>
      <button type="button">
      Toon alle films
      </button>
        <div>Voeg film toe</div>
        <div>
            <form>
                <label htmlFor="name">Naam:</label>
                <input type="text" id="name" name="name"  size="10"></input><br/><br/>

                <label htmlFor="regisseur">Regisseur:</label>
                <input type="text" id="reg" name="reg"  size="10"></input><br/><br/>
                <input type="submit" value="Submit"></input>
            </form>

        </div>
        <div>Film verwijderen</div>
    </div>
  );
}

export default App;

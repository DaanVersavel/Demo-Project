import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";

import axios from "axios";
const api= axios.create({
    baseURL: 'http://localhost:8080/demo'
})


class App extends Component {
    state ={
        films: []
    }
    constructor() {
        super();
        api.get('/').then(res => {
            console.log(res.data)
            this.setState({films:res.data})
        })
    }


    render(){
        return (
            <div>
                <h1 style={{color: "grey"}}>Film database</h1>
                {this.state.films.map(film => <h2 key={film.id}>(film.title)</h2>)}

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
}

export default App;

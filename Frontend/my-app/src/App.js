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
        this.setState({films : null})

    }

    getFilm = async () =>{
        let data = await api.get('/').then(({data})=> data);
        this.setState({
            films: data
        })
    }

    render(){
        return (
            <div>
                <button onClick={this.getFilm}>Toon alle films</button>
                    {this.state.films.map(film => <h2 key={film.id}>{film.title}</h2>)}
            </div>
        );
    }
}

/*{this.state.films.map(film => <h2 key={film.id}>{film.title}</h2>)}*/

/*api.get('/').then(res => {
            console.log(res.data)
            this.setState({films:res.data})
        })


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


            <button onClick={this.getFilm}>Toon alle films</button>
                    {this.state.films.map(film => <h2 key={film.id}>{film.title}</h2>)}
            </div>*/


export default App;

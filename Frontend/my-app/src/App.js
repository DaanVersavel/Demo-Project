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
    deleteFilm = async (id) =>{
        let data = await api.delete(`/${id}`)
    }

    render(){
        return (
            <div class="center">
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Regisseur</th>
                        <th>Jaar</th>
                    </tr>
                </table>
                <button onClick={this.getFilm}>Toon alle films</button>
                    {this.state.films.map(film =>
                        <table>
                        <tr key={film.id}>
                            <th>{film.title}</th>
                            <th>{film.regisseur}</th>
                            <th>{film.jaar}</th>
                        </tr>
                    </table>)}
            </div>
        );
    }
}

/*<button onClick={this.deleteFilm(film.id)}>verwijder</button>
* {this.state.films.map(film => <h2 key={film.id}>{film.title}</h2>)}*/


export default App;


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
            <div >
                <button onClick={this.getFilm}>Toon alle films</button>
                <table className="center">
                    <tr>
                        <th>Title</th>
                        <th>Regisseur</th>
                        <th>Jaar</th>
                    </tr>
                </table>
                    {this.state.films.map(film =>
                        <table class="center">
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

export default App;

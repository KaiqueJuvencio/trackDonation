import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './styles.css';
import compass from '../../assets/compass.png'

export default class Home extends Component {
    
    render() {
        return (
            <div className="home-container">
                <section className="form">
                    <div className="compass-logo-home">
                        <img src={compass} className="App-logo" alt="compass-logo" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>
                    <form>
                        <h1>Bem-Vindo ao Track Donation IRES</h1>

                        <Link className="button" to="/register-receiver">
                            Cadastrar Receptor
                    </Link>
                        <Link className="button" to="/register-donator">
                            Cadastrar Doador
                    </Link>
                        <Link className="button" to="/transmission">
                            Transmissão
                    </Link>
                    </form>
                </section>
                <div className="table-container-info">              
                </div>
            </div>
        )

    }
}
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft, FiShare2 } from 'react-icons/fi';
import "./styles.css";
import compass from '../../assets/compass.png'

import trackDonationApi from '../../services/trackDonationApi';

export default function Transmission() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [authResponse, setAuthResponse] = useState('');

    async function userLogin() {

        if (username === '' || password === '') {
            alert("Login e Senha são necessários. Insira e tente novamente!");
        } else {
            try {
                await trackDonationApi.get('/login?password=' + password + '&username=' + username).then(res => {
                    localStorage.setItem('auth', res.data);
                })
            } catch (err) {
                alert(err);
            }

        }
    }

    return (
        <div className="transmission-container">
            <div className="content">
                <section>
                    <div className="compass-logo">
                        <img src={compass} className="App-logo" alt="compass" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>

                    <div>
                        <h1>Faça Login</h1>
                        <p>Informe o usuário e senha para se autenticar.</p>
                        <form onSubmit={userLogin}>
                            <input
                                placeholder="Usuário"
                                value={username}
                                onChange={e => setUsername(e.target.value)}
                            />
                            <input
                                type="password"
                                placeholder="Senha"
                                value={password}
                                onChange={e => setPassword(e.target.value)}
                            />
                            <button className="button-intern" type="submit">Enviar</button>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    )
}

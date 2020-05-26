import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';
import './styles.css';
import compass from '../../assets/compass.png'

import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterDonator() {
    const [donation, setDonation] = useState('');
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');

    async function registerDonator() {
        console.log(donation);
        try {
            await trackDonationApi.post('/donator/register?donation=' + donation + '&email=' + email + '&name=' + name + '&phone=' + phone)
        } catch (err) {
            alert(err);
        }
    }

    return (
        <div className="register-donator-container">
            <div className="content">
                <section>
                    <div className="compass-logo">
                        <img src={compass} className="App-logo" alt="Virus" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>

                    <h1>Cadastrar Doador</h1>
                    <p>Aqui estão alguns métodos de prevenções para proteger você e sua família.</p>

                    <form onSubmit={registerDonator}>
                        <input
                            placeholder="Doação"
                            value={donation}
                            onChange={e => setDonation(e.target.value)}
                        />
                        <input
                            placeholder="E-mail"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                        <input
                            placeholder="Nome"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                        <input
                            placeholder="Telefone"
                            value={phone}
                            onChange={e => setPhone(e.target.value)}
                        />
                        <button className="button" type="submit">Cadastrar</button>
                    </form>

                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color="#E02041" />
                    Voltar
                </Link>
                </section>
            </div>
        </div>
    );
}
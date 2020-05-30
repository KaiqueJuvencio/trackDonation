import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';
import './styles.css';
import compass from '../../assets/compass.png'

import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterDonator() {
    const [id, setId] = useState('');
    const [donation, setDonation] = useState('');
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');

    const [receivers, setReceiver] = useState([]);

    const ReceiversComponent = (note) => {
        return (
            <table>
                <tr>
                    <th>Id</th>
                    <th>Doação</th>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Data Cadastro</th>
                </tr>
                {receivers.map(receiver => (
                    <tr>
                        <td>{receiver[0]}</td>
                        <td>{receiver[1]}</td>
                        <td>{receiver[2]}</td>
                        <td>{receiver[3]}</td>
                        <td>{receiver[4]}</td>
                        <td>{receiver[5]}</td>
                    </tr>
                ))}
            </table>

        )
    }

    async function handleReceiver() {
        try {
            trackDonationApi.get('/donator').then(res => {
                setReceiver(res.data);
            });
        } catch (err) {
            alert(err);
        }
    }


    async function registerDonator() {
        if (donation === '' || email === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.post('/donator/register?donation=' + donation + '&email=' + email + '&name=' + name + '&phone=' + phone)
            } catch (err) {
                alert(err);
            }
        }
    }

    async function updateDonator() {
        if (id === '' || donation === '' || email === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.put('/donator?donation=' + donation + '&email=' + email + '&id=' + id + '&name=' + name + '&phone=' + phone)
            } catch (err) {
                alert(err);
            }
        }
    }

    async function deleteDonator() {
        if (id === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.delete('/donator?id=' + id)
            } catch (err) {
                alert(err);
            }
        }
    }

    return (
        <div className="register-donator-container">
            <div className="content">
                <section>
                    <div className="compass-logo">
                        <img src={compass} className="App-logo" alt="compass" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>

                    <h1>Cadastrar Doador</h1>
                    <p>Preencha os campos para cadastrar um Doador.</p>

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

                    <h1>Alterar Doador</h1>
                    <p>Preencha os campos para fazer a atualização de um Doador.</p>
                    <form onSubmit={updateDonator}>
                        <input
                            placeholder="Id"
                            value={id}
                            onChange={e => setId(e.target.value)}
                        />
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
                        <button className="button" type="submit">Atualizar</button>
                    </form>

                    <h1>Excluir Doador</h1>
                    <p>Informe o Id do Doador que deseja excluir.</p>
                    <form onSubmit={deleteDonator}>
                        <input
                            placeholder="Id"
                            value={id}
                            onChange={e => setId(e.target.value)}
                        />
                        <button className="button" type="submit">Excluir</button>
                    </form>

                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color="#E02041" />
                    Voltar
                </Link>

                    <button className="button" onClick={handleReceiver} type="button">Listar Receptores</button>
                    <ReceiversComponent />
                </section>
            </div>
        </div>
    );
}
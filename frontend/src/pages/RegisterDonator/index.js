import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';
import './styles.css';
import compass from '../../assets/compass.png'

import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterDonator() {
    const [id, setId] = useState('');
    const [donation, setDonation] = useState('');
    const [donationTest, setDonationTest] = useState('');
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');

    const [openRegister, setOpenRegister] = useState('');
    const [openUpdate, setOpenUpdate] = useState('');
    const [openDelete, setOpenDelete] = useState('');
    const [openSendFeedback, setOpenSendFeedback] = useState('');

    const [receivers, setReceiver] = useState([]);

    const ReceiversComponent = (note) => {
        if (receivers.length != 0) {
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
        } return (<button className="button" onClick={handleReceiver} type="button">Listar Doadores</button>)
    }

    async function handleReceiver() {
        try {
            await trackDonationApi.get('/donator').then(res => {
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

    async function sendFeedbackDonator() {
        if (donation === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.post('/track-donation?donation=' + donation)
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
                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color="#E02041" />
                    Voltar
                    </Link>

                    {(function () {
                        if (openRegister == true) {
                            return (
                                <div>
                                    <h1>Cadastrar Doador</h1>
                                    <p>Preencha os campos para cadastrar um Doador.</p>

                                    <form onSubmit={registerDonator}>
                                        <input
                                            placeholder="Doação"
                                            value={donationTest}
                                            onChange={e => { setDonationTest(e.target.value) }}
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
                                        <button className="button-intern" type="submit">Enviar</button>
                                        <button className="button-intern" onClick={e => setOpenRegister(false)} type="button">Fechar</button>
                                    </form>
                                </div>
                            )
                        }
                        else {
                            return (<button className="button" onClick={e => setOpenRegister(true)} type="button">Cadastrar Doador</button>)
                        }
                    })()}

                    {(function () {
                        if (openUpdate == true) {
                            return (
                                <div>
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
                                        <button className="button-intern" type="submit">Enviar</button>
                                        <button className="button-intern" onClick={e => setOpenUpdate(false)} type="button">Fechar</button>
                                    </form>
                                </div>
                            )
                        } else { return (<button className="button" onClick={e => setOpenUpdate(true)} type="button">Alterar Doador</button>) }
                    })()}

                    {(function () {
                        if (openDelete == true) {
                            return (
                                <div>
                                    <h1>Excluir Doador</h1>
                                    <p>Informe o Id do Doador que deseja excluir.</p>
                                    <form onSubmit={deleteDonator}>
                                        <input
                                            className="input-style-large"
                                            placeholder="Id"
                                            value={id}
                                            onChange={e => setId(e.target.value)}
                                        />
                                        <button className="button-intern" type="submit">Enviar</button>
                                        <button className="button-intern" onClick={e => setOpenDelete(false)} type="button">Fechar</button>
                                    </form>
                                </div>
                            )
                        } else { return (<button className="button" onClick={e => setOpenDelete(true)} type="button">Excluir Doador</button>) }
                    })()}

                    {(function () {
                        if (openSendFeedback == true) {
                            return (
                                <div>
                                    <h1>Enviar Feedback para Doador</h1>
                                    <p>Informe o Nº da Doação para que seja enviado um e-mail com feedback para quem fez essa doação.</p>
                                    <form onSubmit={sendFeedbackDonator}>
                                        <input
                                            placeholder="Nº Doação"
                                            value={donation}
                                            onChange={e => setDonation(e.target.value)}
                                        />
                                        <button className="button-intern" type="submit">Enviar</button>
                                        <button className="button-intern" onClick={e => setOpenSendFeedback(false)} type="button">Fechar</button>
                                    </form>
                                </div>
                            )
                        } else { return (<button className="button" onClick={e => setOpenSendFeedback(true)} type="button">Enviar Feedback</button>) }
                    })()}

                    <ReceiversComponent />
                </section>
            </div>
        </div>
    );
}
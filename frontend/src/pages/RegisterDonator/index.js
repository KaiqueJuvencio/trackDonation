import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft, FiCheckSquare, FiRefreshCw, FiTrash2, FiMail} from 'react-icons/fi';
import './styles.css';
import compass from '../../assets/compass.png'

import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterDonator() {
    const [id, setId] = useState('');
    const [donation, setDonation] = useState('');
    const [email, setEmail] = useState('');
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');

    const [openRegister, setOpenRegister] = useState('');
    const [openUpdate, setOpenUpdate] = useState('');
    const [openDelete, setOpenDelete] = useState('');
    const [openSendFeedback, setOpenSendFeedback] = useState('');

    const [donators, setReceiver] = useState([]);

    const ReceiversComponent = (note) => {
        if (donators.length != 0) {
            return (
                <table>
                    <tr>
                        <th>Idd</th>
                        <th>Doação</th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Data Cadastro</th>
                    </tr>
                    {donators.map(donator => (
                        <tr>
                            <td>{donator[0]}</td>
                            <td>{donator[1]}</td>
                            <td>{donator[2]}</td>
                            <td>{donator[3]}</td>
                            <td>{donator[4]}</td>
                            <td>{donator[5]}</td>
                            <td>
                                <form onSubmit={deleteDonator}>
                                    <td><button class="trash-button" type="submit" onClick={e => setId(donator[0])}><FiTrash2 color="#E02041" /></button></td>
                                </form>
                            </td>           
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
            alert("Nome, N° de doação e e-mail são necessários. Insira e tente novamente!");
        } else {
            try {
                await trackDonationApi.post('/donator?donation=' + donation + '&email=' + email + '&name=' + name + '&phone=' + phone)
            } catch (err) {
                alert(err);
            }
        }
    }

    async function updateDonator() {
        if (id === '') {
            alert("ID é necessário. Insira e tente novamente!");
        } else {
            try {
                await trackDonationApi.put('/donator?donation=' + donation + '&email=' + email + '&id=' + id + '&name=' + name + '&phone=' + phone)
            } catch (err) {
                alert(err);
            }
        }
    }


    async function deleteDonator() {
            try {
                await trackDonationApi.delete('/donator?id=' + id)
            } catch (err) {
                alert(err);
            }
    }

    async function sendFeedbackDonator() {
        if (donation === '') {
            alert("N° de doação é necessário. Insira e tente novamente!");
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
                        <FiArrowLeft size={16} color="#00b670" />
                    Voltar
                    </Link>

                    {(function () {
                        if (openRegister == true) {
                            return (
                                <div>
                                    <h1><FiCheckSquare color="#00b670" />Cadastrar Doador</h1>
                                    <p>Preencha os campos para cadastrar um Doador.</p>

                                    <form onSubmit={registerDonator}>
                                        <input
                                            placeholder="Doação"
                                            value={donation}
                                            onChange={e => { setDonation(e.target.value) }}
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
                                    <h1><FiRefreshCw color="#00b670" />Alterar Doador</h1>
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
                        if (openSendFeedback == true) {
                            return (
                                <div>
                                    <h1><FiMail color="#00b670" />Enviar Feedback para Doador</h1>
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
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft, FiCheckSquare } from 'react-icons/fi';
import "./styles.css";
import compass from '../../assets/compass.png'
import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterReceiver() {
    const [id, setId] = useState('');
    const [donation, setDonation] = useState('');
    const [family, setFamily] = useState('');
    const [name, setName] = useState('');
    const [file, setFile] = useState('');

    const [receivers, setReceiver] = useState([]);

    const ReceiversComponent = (note) => {
        return (
            <table>
                <tr>
                    <th>Id</th>
                    <th>Doação</th>
                    <th>Nome</th>
                    <th>Família</th>
                    <th>Foto</th>
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

    async function registerReceiver() {

        const data = new FormData()
        data.append('file-data', file.selectedFile)
        if (donation === '' || family === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.post('/receiver/register?donation=' + donation + '&family=' + family + '&name=' + name, data, {}).then(res => {
                    console.log(res.statusText)
                })
                alert("Cadastro realizado com sucesso!")
            } catch (err) {
                alert(err);
            }
        }
    }

    async function updateReceiver() {

        const data = new FormData()
        data.append('file-data', file.selectedFile)
        if (donation === '' || family === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.put('/receiver?donation=' + donation + '&family=' + family + '&id='+ id + '&name=' + name, data, {}).then(res => {
                    console.log(res.statusText)
                })
                alert("Cadastro realizado com sucesso!")
            } catch (err) {
                alert(err);
            }
        }
    }

    async function deleteReceiver() {

        const data = new FormData()
        data.append('file-data', file.selectedFile)
        if (id === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.delete('/receiver?id='+ id).then(res => {
                    console.log(res.statusText)
                })
                alert("Cadastro realizado com sucesso!")
            } catch (err) {
                alert(err);
            }
        }
    }

    async function handleReceiver() {
        try {
            trackDonationApi.get('/receiver').then(res => {
                setReceiver(res.data);
            });
        } catch (err) {
            alert(err);
        }
    }

    function onChangeHandler(event) {

        console.log(event.target.files[0])

    }
    return (
        <div className="symptoms-container">
            <div className="content">
                <section>
                    <div className="compass-logo">
                        <img src={compass} className="App-logo" alt="Virus" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>

                    <h1><FiCheckSquare color="#E02041" />Cadastrar Receptor</h1>
                    <p className="check-in-descricao">Preencha os campos para cadastrar um Receptor.</p>
                    <form onSubmit={registerReceiver}>
                        <input
                            placeholder="Doação"
                            value={donation}
                            onChange={e => setDonation(e.target.value)}
                        />
                        <input
                            placeholder="Família"
                            value={family}
                            onChange={e => setFamily(e.target.value)}
                        />
                        <input
                            placeholder="Nome"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                        <input type="file" name="file" onChange={e => setFile({ selectedFile: e.target.files[0], loaded: 0, })} />
                        <button className="button" type="submit">Cadastrar</button>
                    </form>


                    <h1><FiCheckSquare color="#E02041" />Atualizar Receptor</h1>
                    <p className="check-in-descricao">Preencha os campos para fazer a atualização de um Receptor.</p>
                    <form onSubmit={updateReceiver}>
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
                            placeholder="Família"
                            value={family}
                            onChange={e => setFamily(e.target.value)}
                        />
                        <input
                            placeholder="Nome"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                        <input type="file" name="file" onChange={e => setFile({ selectedFile: e.target.files[0], loaded: 0, })} />
                        <button className="button" type="submit">Atualizar</button>
                    </form>


                    <h1><FiCheckSquare color="#E02041" />Excluir Receptor</h1>
                    <p className="check-in-descricao">Informe o Id do Receptor que deseja excluir.</p>
                    <form onSubmit={deleteReceiver}>
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
    )
}
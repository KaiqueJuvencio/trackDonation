import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft, FiCheckSquare } from 'react-icons/fi';
import "./styles.css";
import compass from '../../assets/compass.png'
import trackDonationApi from '../../services/trackDonationApi';

export default function RegisterReceiver() {
    const [id, setId] = useState('');
    const [donation, setDonation] = useState('');
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [rg, setRg] = useState('');
    const [dateOfBirth, setDateOfBirth] = useState('');
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');
    const [family, setFamily] = useState('');
    const [residentsQuantity, setResidentsQuantity] = useState('');
    const [monthGotDonation, setMonthGotDonation] = useState('');
    const [file, setFile] = useState('');

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
                        <th>RG</th>
                        <th>Nascimento</th>
                        <th>Telefone</th>
                        <th>Endereço</th>
                        <th>Família</th>
                        <th>Qtd. Moradores</th>
                        <th>Meses Cestas Pegas</th>
                        <th>Data Cadastro</th>
                        <th>Foto</th>


                    </tr>
                    {receivers.map(receiver => (
                        <tr>
                            <td>{receiver[0]}</td>
                            <td>{receiver[1]}</td>
                            <td>{receiver[2]}</td>
                            <td>{receiver[3]}</td>
                            <td>{receiver[4]}</td>
                            <td>{receiver[5]}</td>
                            <td>{receiver[6]}</td>
                            <td>{receiver[7]}</td>
                            <td>{receiver[8]}</td>
                            <td>{receiver[9]}</td>
                            <td>{receiver[10]}</td>
                            <td>{receiver[11]}</td>
                            <td>{receiver[12]}</td>
                        </tr>
                    ))}
                </table>
            )

        }
        return(
            <button className="button" onClick={handleReceiver} type="button">Listar Receptores</button>
        )
    }

    const ReceiverRegisterComponent = (props) => {
        return (<div>
            <h1><FiCheckSquare color="#E02041" />Cadastrar Receptor</h1>
            <p className="check-in-descricao">Preencha os campos para cadastrar um Receptor.</p>
            <form onSubmit={registerReceiver}>
                <input
                    placeholder="Doação"
                    value={donation}
                    onChange={e => setDonation(e.target.value)}
                />
                <input
                    placeholder="Nome"
                    value={name}
                    onChange={e => setName(e.target.value)}
                />
                <input
                    placeholder="E-mail"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                />
                <input
                    placeholder="RG"
                    value={rg}
                    onChange={e => setRg(e.target.value)}
                />
                <input
                    placeholder="Nascimento"
                    value={dateOfBirth}
                    onChange={e => setDateOfBirth(e.target.value)}
                />
                <input
                    placeholder="Telefone"
                    value={phone}
                    onChange={e => setPhone(e.target.value)}
                />
                <input
                    placeholder="Endereço"
                    value={address}
                    onChange={e => setAddress(e.target.value)}
                />
                <input
                    placeholder="Família"
                    value={family}
                    onChange={e => setFamily(e.target.value)}
                />
                <input
                    placeholder="Qtd. Moradores"
                    value={residentsQuantity}
                    onChange={e => setResidentsQuantity(e.target.value)}
                />
                <input
                    placeholder="Meses Cestas Pegas"
                    value={monthGotDonation}
                    onChange={e => setMonthGotDonation(e.target.value)}
                />

                <input type="file" name="file" onChange={e => setFile({ selectedFile: e.target.files[0], loaded: 0, })} />
                <button className="button" type="submit">Cadastrar</button>
            </form>
        </div>

        )
    }

    function teste() {
        return (<ReceiverRegisterComponent />)
    }

    async function registerReceiver() {
        console.log(address, dateOfBirth, donation, email, family, monthGotDonation, name, phone, residentsQuantity, rg);
        const data = new FormData()
        data.append('receiverPhoto', file.selectedFile)
        if (donation === '' || family === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.post('/receiver/register?address=' + address + '&dateOfBirth=' + dateOfBirth + '&donationReceived=' + donation + '&email=' + email + '&family=' + family + '&monthGotDonation=' + monthGotDonation + '&name=' + name + '&phone=' + phone + '&residentsQuantity=' + residentsQuantity + '&rg=' + rg, data, {}).then(res => {
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
        data.append('receiverPhoto', file.selectedFile)
        if (donation === '' || family === '' || name === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.put('/receiver?address=' + address + '&dateOfBirth=' + dateOfBirth + '&donationReceived=' + donation + '&email=' + email + '&family=' + family + '&id=' + id + '&monthGotDonation=' + monthGotDonation + '&name=' + name + '&phone=' + phone + '&residentsQuantity=' + residentsQuantity + '&rg=' + rg, data, {}).then(res => {
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
        data.append('receiverPhoto', file.selectedFile)
        if (id === '') {
            alert("Insira as informações necessárias para cadastro!");
        } else {
            try {
                await trackDonationApi.delete('/receiver?id=' + id).then(res => {
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
                        <img src={compass} className="App-logo" alt="compass" />
                        <h2 className="compass-text">Track Donation IRES</h2>
                    </div>




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
                            placeholder="Nome"
                            value={name}
                            onChange={e => setName(e.target.value)}
                        />
                        <input
                            placeholder="E-mail"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                        <input
                            placeholder="RG"
                            value={rg}
                            onChange={e => setRg(e.target.value)}
                        />
                        <input
                            placeholder="Nascimento"
                            value={dateOfBirth}
                            onChange={e => setDateOfBirth(e.target.value)}
                        />
                        <input
                            placeholder="Telefone"
                            value={phone}
                            onChange={e => setPhone(e.target.value)}
                        />
                        <input
                            placeholder="Endereço"
                            value={address}
                            onChange={e => setAddress(e.target.value)}
                        />
                        <input
                            placeholder="Família"
                            value={family}
                            onChange={e => setFamily(e.target.value)}
                        />
                        <input
                            placeholder="Qtd. Moradores"
                            value={residentsQuantity}
                            onChange={e => setResidentsQuantity(e.target.value)}
                        />
                        <input
                            placeholder="Meses Cestas Pegas"
                            value={monthGotDonation}
                            onChange={e => setMonthGotDonation(e.target.value)}
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

                    
                    <ReceiversComponent />

                    <button className="button" onClick={teste} type="button">Cadastrar Receptor</button>


                </section>

            </div>
        </div>
    )
}
import React from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft, FiShare2 } from 'react-icons/fi';
import "./styles.css";
import compass from '../../assets/compass.png'



export default function Transmission() {
    return (
        <div className="transmission-container">
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
                </section>
            </div>
        </div>
    )
}
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
                        <img src={compass} className="App-logo" alt="Virus" />
                        <h2 className="compass-text">COVID-CHECK</h2>
                    </div>
                    <h1><FiShare2 color="#E02041" /> Transmissão</h1>
                    <p className="check-in-descricao-procure">A principal forma de contágio do novo coronavírus é o contato com uma pessoa infectada, que transmite o vírus por meio de tosse e espirros.</p>
                    <p className="check-in-descricao-procure">Ele também se propaga quando a pessoa toca em uma superfície ou objeto contaminado e depois nos olhos, nariz ou boca.</p>
                    
                    <h3 className="transmission-topic">Contato próximo (1,8 m) e gotas respiratórias:</h3>
                    <p className="check-in-descricao-procure">Entre pessoas que estão em estreito contato umas com as outras (até um metro e meio).</p>
                    <p className="check-in-descricao-procure">Através de gotículas respiratórias produzidas quando uma pessoa infectada tosse, espirra ou fala.</p>

                    <h3 className="transmission-topic">Gotículas transmissoras e correntes de ar:</h3>
                    <p className="check-in-descricao-procure">Gotas respiratórias maiores (maiores que 5 <a href="https://pt.wikipedia.org/wiki/Micr%C3%B3metro_(unidade_de_medida)">μm</a>) permanecem no ar apenas por um curto período de tempo e viajam apenas distâncias curtas, geralmente menos de 1 metro.</p>
                    <p className="check-in-descricao-procure">Pequenas gotículas aerossolizadas carregadas de vírus (menores que 5 μm) podem permanecer no ar e percorrer longas distâncias, mais de 1 metro.</p>
                    <p className="check-in-descricao-procure">Um estudo de transmissão ocorrendo em um restaurante entre pessoas a uma distância acima de 1 metro, observou que "um forte fluxo de ar do ar condicionado poderia ter propagado gotículas." <a href="https://wwwnc.cdc.gov/eid/article/26/7/20-0764_article">[ fonte ]</a></p>

                    <h3 className="transmission-topic">Duração da contaminação em objetos e superfícies:</h3>
                    <p className="check-in-descricao-procure">- Plástico : até 2-3 dias</p>
                    <p className="check-in-descricao-procure">- Aço inoxidável l: até 2-3 dias</p>
                    <p className="check-in-descricao-procure">- Papelão : até 1 dia</p>
                    <p className="check-in-descricao-procure">- Cobre : até 4 horas</p> 
                    

                    <Link className="back-link" to="/">
                        <FiArrowLeft size={16} color="#E02041" />
                        Voltar
                    </Link>
                </section>
            </div>
        </div>
    )
}
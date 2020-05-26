import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom'

import Home from './pages/Home';
import RegisterReceiver from './pages/RegisterReceiver';
import RegisterDonator from './pages/RegisterDonator';
import Transmission from './pages/Transmission';


export default function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Home}/>
                <Route path="/register-receiver" component={RegisterReceiver}/>
                <Route path="/transmission" component={Transmission}/>
                <Route path="/register-donator" component={RegisterDonator}/>
            </Switch>
        </BrowserRouter>
    )
}
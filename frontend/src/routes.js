import React, { Component } from 'react';
import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom'

import { isAuthenticated } from './auth';

import Home from './pages/Home';
import RegisterReceiver from './pages/RegisterReceiver';
import RegisterDonator from './pages/RegisterDonator';
import Transmission from './pages/Transmission';


export default function Routes(){
    const PrivateRoute = ({ component: Component, ...rest }) => (
        <Route {...rest} render={props => (
            isAuthenticated() == 'true'? (
                <Component {...props}/>
            ):(
                <Redirect to={{ pathname: '/', state: { from: props.location }}}/>
            )
        )}/>
    )

    const LoginRoute = ({ component: Component, ...rest }) => (
        <Route {...rest} render={props => (
            isAuthenticated() == 'false'? (
                <Component {...props}/>
            ):(
                <Redirect to={{ pathname: '/home', state: { from: props.location }}}/>
            )
        )}/>
    )
    return(
        <BrowserRouter>
            <Switch>
                <LoginRoute path="/" exact component={Transmission}/>
                <PrivateRoute path="/register-receiver" component={RegisterReceiver}/>
                <PrivateRoute path="/home" component={Home}/>
                <PrivateRoute path="/register-donator" component={RegisterDonator}/>
                <Route path="/login-fail" component={() => <h1>Não está logado</h1>}/>
            </Switch>
        </BrowserRouter>
    )
}
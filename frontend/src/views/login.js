import React from 'react';
import LoginForm from '../components/loginForm/loginForm';
import AppHeader from '../components/header/AppHeader';
import { Link } from 'react-router-dom';

const Login = () => {
    return (
        <div>
            <AppHeader/>
            <LoginForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default Login;

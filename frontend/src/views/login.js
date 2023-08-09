import React from 'react';
import LoginForm from '../components/loginForm/loginForm';
import AppHeader from '../components/header/AppHeader';
import { Link } from 'react-router-dom';

const Login = () => {
    return (
        <div>
            {/* <AppHeader/> */}
            <h1>This is login page</h1>
            <LoginForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default Login;

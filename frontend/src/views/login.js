import React from 'react';
import LoginForm from '../components/form/loginForm';
import '../css/login-form.css';
import { Link } from 'react-router-dom';

const Login = () => {
    return (
        <div className="login-container">
            <div className="login-heading">
                <h1>This is the Login Page</h1>
            </div>
            <div className="login-form">
                <LoginForm />
            </div>
            <div className="login-link">
                <Link to="/">Link to Home Page</Link>
            </div>
        </div>
    );
};

export default Login;

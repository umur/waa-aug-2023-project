import React from 'react';
import '../css/register.css'; // Import the CSS file
import { Link } from 'react-router-dom';
import RegisterForm from '../components/form/registerForm';

const Register = () => {
    return (
        <div className="register-container">
            <div className="register-heading">
                <h1>This is the Register Page</h1>
            </div>
            <div className="register-form">
                <RegisterForm />
            </div>
            <div className="register-link">
                <Link to="/">Link to Home Page</Link>
            </div>
        </div>
    );
};

export default Register;

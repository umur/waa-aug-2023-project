import React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../components/button/Button'
import Input from '../components/input/input';

import { fetchApiData } from '../services/loginService';

const Login = () => {
    const navigate = useNavigate();
    const handleClick = async () => {
        try {
            console.log('Button clicked');
            const apiResponse = await fetchApiData('auth',{username: 'admin',password: 'password123'});
            console.log(apiResponse);
            console.log('Button clicked end');
            navigate("/")
        } catch (error) {
            console.error('API request error:', error);
            navigate("/500")
        }
    };

    return (
        <div>
            <Input type="email" />
            <Input type="password" />
            <Button color="primary" onClick={handleClick}>
                Login
            </Button>
            <a href="/#/">Link to home page</a>
        </div>
    );
};
export default Login;

import React from 'react';
import Button from '../components/button/Button'
import Input from '../components/input/input';

import { fetchApiData } from '../services/loginService';

const Login = () => {
    const handleClick = async () => {
        try {
            const apiResponse = await fetchApiData('auth'); // Call the fetchApiData function
            console.log(apiResponse); // Log the API response data
            console.log('Button clicked');
        } catch (error) {
            console.error('API request error:', error);
        }
    };


    return (
        <div>
            <Input type="email" />
            <Input type="password" />
            <Button color="primary" onClick={handleClick}>
                Login
            </Button>
        </div>
    );
};

export default Login;

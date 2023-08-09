import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Input from '../input/input';
import Loading from '../loading/loading';

import { handleLoginApi } from '../../services/loginService';

const LoginForm = () => {
    const navigate = useNavigate();
    const [handleLoginInput, setHandleLoginInput] = useState({
        username: '',
        password: '',
    });
    const [isLoading, setIsLoading] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setHandleLoginInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleLogin = async () => {
        try {
            setIsLoading(true);
            const apiResponse = await handleLoginApi('auth', handleLoginInput);
            setIsLoading(false);
            if (apiResponse.token) {
                navigate('/');
            } else {
                alert('Bad credentials, try again');
            }
        } catch (error) {
            setIsLoading(false);
            console.error('API request error:', error);
            navigate('/500');
        }
    };

    return (
        <div>
            <input
                name="username"
                type="email"
                value={handleLoginInput.username}
                onChange={handleInputChange}
            />

            <input
                name="password"
                type="password"
                value={handleLoginInput.password}
                onChange={handleInputChange}
            />
            <Button color="primary" onClick={handleLogin}>
                Login
            </Button>
            {isLoading && <Loading />}
        </div>
    );
};

export default LoginForm;
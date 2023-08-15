import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';

import AuthService from '../../services/AuthService';

const LoginForm = () => {
    const navigate = useNavigate();
    const [handleLoginInput, setHandleLoginInput] = useState({
        email: '',
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
            const apiResponse = await AuthService.handlePostApi('login', handleLoginInput);
            setIsLoading(false);
            if (apiResponse.accessToken) {
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
            <div>
                <label>email: </label>
                <input
                    name="email"
                    type="email"
                    value={handleLoginInput.email}
                    onChange={handleInputChange}
                />
            </div>

            <div>
                <label>password: </label>
                <input
                    name="password"
                    type="password"
                    value={handleLoginInput.password}
                    onChange={handleInputChange}
                />
            </div>
            <div>
                <Button color="primary" onClick={handleLogin}>
                    Login
                </Button>
            </div>
            {isLoading && <Loading />}
        </div>
    );
};

export default LoginForm;
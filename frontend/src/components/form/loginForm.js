import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';

import AuthService from '../../services/AuthService';
import { useAuth } from '../../contexts/AuthContext';

const MAX_LOGIN_ATTEMPTS = 5;
const LOCKOUT_DURATION = 900000;

const LoginForm = () => {
    const { token, login, logout } = useAuth();
    const navigate = useNavigate();
    const [handleLoginInput, setHandleLoginInput] = useState({
        email: '',
        password: '',
    });
    const [isLoading, setIsLoading] = useState(false);
    const [loginAttempts, setLoginAttempts] = useState(0);
    const [isLocked, setIsLocked] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setHandleLoginInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleLogin = async () => {
        if (isLocked) {
            alert('Account locked. Please try again later.');
            return;
        }

        try {
            setIsLoading(true);
            const apiResponse = await AuthService.handlePostApi('login', handleLoginInput);
            setIsLoading(false);

            if (apiResponse.accessToken) {
                localStorage.setItem('accessToken', apiResponse.accessToken);
                localStorage.setItem('role', apiResponse.role);
                localStorage.setItem('user_id', apiResponse.id);
                setLoginAttempts(0);
                navigate('/');
            }
        } catch (error) {
            setIsLoading(false);
            console.log(loginAttempts)
            if (loginAttempts + 1 >= MAX_LOGIN_ATTEMPTS) {
                setIsLocked(true);
                setTimeout(() => {
                    setIsLocked(false);
                    setLoginAttempts(loginAttempts);
                }, LOCKOUT_DURATION);
                alert('Too many failed login attempts. Account locked.');
            } else {
                setLoginAttempts(loginAttempts + 1);
                alert('Bad credentials, try again');
            }
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
                {isLoading && <Loading />}
                {token ? (
                    <>
                        <p>Logged in</p>
                        <button onClick={logout}>Logout</button>
                    </>
                ) : (
                    <>
                        <p>Not logged in</p>
                        <Button color="primary" onClick={handleLogin}>
                            Login
                        </Button>
                    </>
                )}
            </div>
        </div>
    );
};

export default LoginForm;

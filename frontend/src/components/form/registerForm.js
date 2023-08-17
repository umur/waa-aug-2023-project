import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';

import AuthService from '../../services/AuthService';

const RegisterForm = () => {
    const navigate = useNavigate();
    const [registerInput, setRegisterInput] = useState({
        email: '',
        password: '',
        role: '', // New role field
    });
    const [isLoading, setIsLoading] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setRegisterInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleRegister = async () => {
        try {
            setIsLoading(true);
            const apiResponse = await AuthService.handlePostApi('register', registerInput);
            setIsLoading(false);
            if (apiResponse) {
                navigate('/login');
            }
        } catch (error) {
            setIsLoading(false);
            alert('Registration failed, please try again');
        }
    };

    return (
        <div>
            <div>
                <label>Email: </label>
                <input
                    name="email"
                    type="email"
                    value={registerInput.email}
                    onChange={handleInputChange}
                />
            </div>
            <div>
                <label>Password: </label>
                <input
                    name="password"
                    type="password"
                    value={registerInput.password}
                    onChange={handleInputChange}
                />
            </div>
            <div>
                <label>Role: </label>
                <select
                    name="role"
                    value={registerInput.role}
                    onChange={handleInputChange}
                >
                    <option value="">Select Role</option>
                    <option value="ALUMNI">ALUMNI</option>
                    <option value="FACULTY">FACULTY</option>
                    <option value="ADMIN">ADMIN</option>
                </select>
            </div>
            <div>
                <Button color="primary" onClick={handleRegister}>
                    Register
                </Button>
            </div>
            {isLoading && <Loading />}
        </div>
    );
};

export default RegisterForm;
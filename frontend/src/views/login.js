import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../components/button/Button'
import Input from '../components/input/input';
import Loading from '../components/loading/loading';

import { handleLoginApi } from '../services/loginService';

const Login = () => {
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false)

    const handleClick = async () => {
        try {
            setIsLoading(true);
            console.log('Button clicked');
            const apiResponse = await handleLoginApi('auth',{username: 'admin',password: 'password123'});
            console.log(apiResponse);
            console.log('Button clicked end');
            setIsLoading(false);
            navigate("/")
        } catch (error) {
            if(error) {
                setIsLoading(false);
                console.error('API request error:', error);
                navigate("/500")
            }
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
            {isLoading && <Loading/>}
        </div>
    );
};
export default Login;

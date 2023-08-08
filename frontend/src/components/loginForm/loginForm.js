import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button'
import Input from '../input/input';
import Loading from '../loading/loading';

import { handleLoginApi } from '../services/loginService';

const LoginForm = () => {
    const navigate = useNavigate();
    const [username, setUserName] = useState(null);
    const [password, setPassword] = useState(null);
    const [isLoading, setIsLoading] = useState(false)

    const handleClick = async () => {
        try {
            setIsLoading(true);
            console.log('Button clicked');
            const apiResponse = await handleLoginApi('auth',{username: username,password: password});
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
            <Input type="email" value={setUserName}/>
            <Input type="password" value={setPassword}/>
            <Button color="primary" onClick={handleClick}>
                Login
            </Button>
            <a href="/#/">Link to home page</a>
            {isLoading && <Loading/>}
        </div>
    );
};
export default LoginForm;

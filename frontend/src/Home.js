import React from 'react';
import axios from 'axios';
import { useState } from 'react';
import { useToken } from './Context/TokenContext'; // Import the useToken hook

export default function Home() {
    const { token, setToken } = useToken(); // Use the useToken hook

    const [usernameState, setUsername] = useState('');
    const [passwordState, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        console.log("username: " + usernameState);
        console.log("password: " + passwordState);

        try {
            const response = await axios.post('http://localhost:8080/api/auth', { username: usernameState, password: passwordState });
            const newToken = response.data.token;
            setToken(newToken); // Use the setToken function from the context
            localStorage.setItem('token', newToken);
        } catch (error) {
            console.error('Login failed:', error);
        }
    };

    const handleLogout = () => {
        setToken('');
        localStorage.removeItem('token');
    };

    const fetchData = async () => {
        console.log("token: " + token);
        try {
            const response = await axios.get('http://localhost:8080/admin/news', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            console.log('Data:', response.data);
        } catch (error) {
            console.error('Request failed:', error);
            if (error.response && error.response.status === 401) {

            }
        }
    };


    return (
        <div>
            <h1>Home Page!</h1>
            <img src="/muhumed.jpg" alt="Muhumed" />
            <h3>The default admin username is: "default"</h3>
            <h3>The default admin password is: "password"</h3>
            <h4>Go to the admin dashboard to add new entities</h4>
            <div>
                {token ? (
                    <div>
                        <p>Welcome! You're logged in.</p>
                        <button onClick={handleLogout}>Logout</button>
                        <button onClick={fetchData}>Fetch Protected Data</button>
                    </div>
                ) : (
                    <div>
                        <form onSubmit={handleLogin}>
                            <label>
                                Username:
                                <input type="text" value={usernameState} onChange={(e) => setUsername(e.target.value)} />
                            </label>
                            <br />
                            <label>
                                Password:
                                <input type="password" value={passwordState} onChange={(e) => setPassword(e.target.value)} />
                            </label>
                            <br />
                            <button type="submit">Login</button>
                        </form>
                    </div>
                )}
            </div>
        </div>
    );
}

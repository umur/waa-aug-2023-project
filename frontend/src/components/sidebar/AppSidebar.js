import React from 'react';
import '../../css/sidebar.css';
import { Link } from 'react-router-dom';
import { useAuth } from '../../contexts/AuthContext';

const AppSidebar = () => {
    const { token, setToken } = useAuth();

    return (
        <div className="app-sidebar">
            <ul>
                <li><Link to="/" children="Home Page" /></li>
                <li><Link to="/login" children="Login Page" /></li>
                {token !== "ADMIN" && (
                    <li>
                        <Link to="/edit-profile" children="Edit Profile Page"/>
                        <Link to="/create-profile" children="Create Profile Page" />
                    </li>
                )}
                <li><Link to="/user" children="User Page" /></li>
                <li><Link to="/register" children="Register Page" /></li>
                <li><Link to="/404" children="404 Page" /></li>
                <li><Link to="/500" children="500 Page" /></li>
            </ul>
        </div>
    )
}

export default AppSidebar;

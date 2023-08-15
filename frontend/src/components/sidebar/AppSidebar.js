import React from 'react';
import '../../css/sidebar.css';
import { Link } from 'react-router-dom';

const AppSidebar = () => {
    return (
        <div className="app-sidebar">
            <ul>
                <li><Link to="/" children="Home Page"/></li>
                <li><Link to="/login" children="Login Page"/></li>
                <li><Link to="/profile" children="Profile Page"/></li>
                <li><Link to="/register" children="Register Page"/></li>
                <li><Link to="/404" children="404 Page"/></li>
                <li><Link to="/500" children="500 Page"/></li>
            </ul>
        </div>
    )
}

export default AppSidebar;

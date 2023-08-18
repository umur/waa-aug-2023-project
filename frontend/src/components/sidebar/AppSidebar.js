import React from 'react';
import '../../css/sidebar.css';
import { Link } from 'react-router-dom';
import { useAuth } from '../../contexts/AuthContext';

const AppSidebar = () => {
    const { token, role } = useAuth();

    return (
        <div className="app-sidebar">
            <ul>
                <li><Link to="/" children="Home Page" /></li>
                <li><Link to="/login" children="Login Page" /></li>
                {role !== "ADMIN" && (
                    <li>
                        <Link to="/profile/create" children="Edit Profile Page"/>
                        <Link to="/profile/edit" children="Create Profile Page" />
                    </li>
                )}
                {role === "ALUMNI" && (
                    <li>
                        <Link to="/jobs/create" children="Create Jobs Advertisment Page"/>
                        <Link to="/jobs/edit" children="Edit Job Advertisment Page"/>
                        <Link to="/jobEx/create" children="Create Jobs Experience Page"/>
                        <Link to="/jobEx/edit" children="Edit Jobs Experience Page"/>
                    </li>
                )}
                {role === "ADMIN" && (
                    <ul>
                        <li><Link to="/admin/user" children="User Page" /></li>
                        <li><Link to="/admin/log" children="Log System Page" /></li>
                    </ul>
                )}
                <li><Link to="/register" children="Register Page" /></li>
                <li><Link to="/" children="Experience Page" /></li>
                <li><Link to="/404" children="404 Page" /></li>
                <li><Link to="/500" children="500 Page" /></li>
            </ul>
        </div>
    )
}

export default AppSidebar;

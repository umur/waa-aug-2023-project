import React from 'react';
import "../../css/sidebar.css"
import { Link } from 'react-router-dom';

const AppSidebar = () => {
    return (
        <div className="sidebar">
            <ul>
                <Link to="/">Home Page</Link>
                <Link to="/login">Login Page</Link>
                <Link to="/404">Not Found Page</Link>
                <Link to="/500">Internal Error</Link>
            </ul>
        </div>
    )
}

export default AppSidebar
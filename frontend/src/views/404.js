import React from 'react';
import AppHeader from '../components/header/AppHeader';
import { Link } from 'react-router-dom';

const NotFound = () => {
    return (
        <div>
            <AppHeader/>
            <h1>Oops! we cannot find your page</h1>
            <Link to="/">Link to home page</Link>
        </div>
    )
}

export default NotFound;
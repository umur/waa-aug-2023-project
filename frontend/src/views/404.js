import React from 'react';
import AppHeader from '../components/header/AppHeader';

const NotFound = () => {
    return (
        <div>
            <AppHeader/>
            <h1>Oops! we cannot find your page</h1>
            <a href="/#/">Link to home page</a>
        </div>
    )
}

export default NotFound;
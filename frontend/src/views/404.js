import React from 'react';
import { Link } from 'react-router-dom';

const NotFound = () => {
    return (
        <div>
            <h1>Oops! we cannot find your page</h1>
            <Link to="/">Link to home page</Link>
        </div>
    )
}

export default NotFound;
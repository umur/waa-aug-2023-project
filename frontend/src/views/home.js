import React from 'react';
import AppHeader from '../components/header/AppHeader';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div class="homeContainer">
            {/* <AppHeader/> */}
            <h1>This is home page</h1>
            <Link to="/login">Link to login page</Link>
        </div>
    )
}

export default Home;
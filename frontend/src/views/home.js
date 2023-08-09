import React from 'react';
import AppHeader from '../components/header/AppHeader';

const Home = () => {
    return (
        <div class="homeContainer">
            <AppHeader/>
            <h1>This is home page</h1>
            <a href="/#/login">Link to login page</a>
        </div>
    )
}

export default Home;
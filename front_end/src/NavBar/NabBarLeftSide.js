import React, { useEffect, useState } from "react";

import './NabBarLeftSide.css';
import { useNavigate } from "react-router";
import { useDispatch, useSelector } from "react-redux";
import { selectIsLoggedIn, setIsLoggedIn } from "./isLoggedInSlice";

function NabBarLeftSide() {
    const navigate = useNavigate();
    const isLogged = useSelector(selectIsLoggedIn);
    const dispatch = useDispatch();
    
    function logout() {
        localStorage.clear();
        dispatch(setIsLoggedIn(false));
        navigate('/login')
    }

    function getUserName(){
        const userName = localStorage.getItem('userName');
        if(userName) return userName;
    }

    return (
        isLogged ?
            (<div className="loggedIn rowFlex">
                <p>Welcome {getUserName()} </p>
                <button onClick={logout} class="btn btn-outline-light my-2 my-sm-0" >Logout</button>
            </div>)
            :
            (<div className="loggedOut">
                <button onClick={() => navigate('login')} class="btn btn-outline-light my-2 my-sm-0" >Login</button>
                <button onClick={() => navigate('register')} class="btn btn-outline-light my-2 my-sm-0" >Register</button>
            </div>)
    );
}

export default NabBarLeftSide;

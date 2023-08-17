import React, { useState } from "react";

import './Login.css'
import { Link } from "react-router-dom";
import axios from "axios";

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    function login(){
        console.log({email, password});
        axios.post('http://localhost:8080/auth/login',(
           { email, password}
        ))
        .then((res) => {
            console.log('token', res.data.token);
            localStorage.setItem('token', res.data.token);
        })
        .catch((err)=> console.log(err))
    }
    return (
        <div className="login">
            <form>
                <div class="form-outline mb-4">
                    <input onChange={(e)=> setEmail(e.target.value)} type="email" id="form2Example1" class="form-control" placeholder="Email" />
                </div>

                <div class="form-outline mb-4">
                    <input onChange={(e)=> setPassword(e.target.value)} type="password" id="form2Example2" class="form-control" placeholder="Password"/>
                </div>

                <div class="row mb-4">
                    <div class="col d-flex justify-content-center">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                            <label class="form-check-label" for="form2Example31"> Remember me </label>
                        </div>
                    </div>

                    <div class="col">
                        <a href="#!">Forgot password?</a>
                    </div>
                </div>

                <button onClick={login} type="button" class="btn btn-dark btn-block mb-4">Sign in</button>

                <div class="text-center">
                    <p>Not a member? <Link to='/register'>Register</Link></p>
                </div>
            </form>
        </div>
    );
}

export default Login;

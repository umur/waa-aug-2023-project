import React, { useState } from "react";

import './Register.css'
import { Link } from "react-router-dom";
import axios from "axios";


function Register() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [accountType, setAccountType] = useState('');

    function register(){
        console.log({firstName, lastName, email, password, accountType});
        axios.post('http://localhost:8080/auth/register', 
            {firstName, lastName, email, password, accountType}
        )
        .then((res) => console.log(res))
        .catch((err)=> console.log(err))
    }

    return (
        <div className="register">
            <div class=" " id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                <form>

                    <div class="form-outline mb-4">
                        <input onChange={(e) => setFirstName(e.target.value)} type="text" id="fname" class="form-control" placeholder="First name" />
                    </div>

                    <div class="form-outline mb-4">
                        <input onChange={(e) => setLastName(e.target.value)} type="text" id="lname" class="form-control" placeholder="Last name" />
                    </div>

                    <div class="form-outline mb-4">
                        <input onChange={(e) => setEmail(e.target.value)} type="email" id="registerEmail" class="form-control" placeholder="Email" />
                    </div>

                    <div class="form-outline mb-4">
                        <input onChange={(e) => setPassword(e.target.value)} type="password" id="registerPassword" class="form-control" placeholder="Password" />
                    </div>

                    <div class="form-outline mb-4">
                        <input type="password" id="registerRepeatPassword" class="form-control" placeholder="Repeat password" />
                    </div>

                    <div class="form-outline mb-4">
                        <select onChange={(e) => setAccountType(e.target.value)} class="form-control" id="exampleFormControlSelect1">
                            <option selected disabled>Account Type</option>
                            <option value={'ALUMNI'} >Almuni</option>
                            <option value={'FACULTY'} >Almuni</option>
                        </select>
                    </div> 
                </form>
                <button onClick={register} class="btn btn-dark btn-block mb-3">Register</button>
                <div class="text-center">
                        <p>Already have an account? <Link to='/login'>Login</Link></p>
                    </div>
            </div>
        </div>
    );
}

export default Register;

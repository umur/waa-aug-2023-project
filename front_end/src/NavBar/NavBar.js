import React, { useState } from "react";

import './NavBar.css';
import { Link, useNavigate } from "react-router-dom";
import NabBarLeftSide from "./NabBarLeftSide";

function NavBar() {
  
    return (
        <div className="wholeNavbar">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <Link class="navbar-brand" to='/'>Almuni Platform</Link>
                {/* <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button> */}
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <Link class="nav-link" to='/'>Home <span class="sr-only">(current)</span></Link>
                        </li>
                        <li class="nav-item">
                            <Link to='directory' class="nav-link" >Directory</Link>
                        </li>
                        <li class="nav-item">
                            <Link to='exploreJobs' class="nav-link" >Jobs</Link>
                        </li>
                        <li class="nav-item">
                            <Link to='alumniProfile' class="nav-link" >Profile</Link>
                        </li>
                        <li class="nav-item">
                            <Link to='dashboard' class="nav-link" >Dashboard</Link>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Others
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                    </ul>
                </div>
                <NabBarLeftSide/>
            </nav>
        </div>
    );
}

export default NavBar;

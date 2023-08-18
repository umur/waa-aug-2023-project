import React, { useEffect, useState } from "react";
import './AlumniProfile.css'
import { Avatar, Button } from "@mui/material";
import Education from "../ReusableCommponents/Education";
import PersonalDetail from "../ReusableCommponents/PersonalDetail";
import Location from "../ReusableCommponents/Location";
import Company from "../ReusableCommponents/Company";
import EducationHistory from "./EducationHistory";
import ProfessionalHistory from "../ReusableCommponents/ProfessionalHistory";
import ProfessionalExperienceList from "./ProfessionalExperienceList";
import axios from "axios";

function AlumniProfile() {
    const[alumniProfile, setAlumniProfile] = useState({
        firstName: '',
        industry: {name: ''},
        location: {street: '', city: '', state: '', zipcode: 0}
    });

    useEffect(()=>{
        const userId = localStorage.getItem('userId');
        axios.get('http://localhost:8080/alumnus/' + userId)
        .then(res => {
            const data = res.data;
            console.log('Profile ', data);
            setAlumniProfile({...alumniProfile, ...data});
            console.log('profile state ' + alumniProfile);
        })
        .catch(err => console.log(err))
    }, [])

    return (
        <div className="alumniProfile">
            <div className="left_Bar columnFlex centerItems">
                <Avatar />
                <h1>{alumniProfile.firstName} {alumniProfile.lastName}</h1>
                <PersonalDetail alumniProfileState = {{alumniProfile, setAlumniProfile}} />
            </div>
            <div className="middle_bar centerItems">
                <Education />
            </div>
            <div className="right_bar columnFlex">
                <EducationHistory />
                <ProfessionalExperienceList />
                <button class="btn btn-dark">Save Changes</button>
            </div>
        </div>
    );
}

export default AlumniProfile;

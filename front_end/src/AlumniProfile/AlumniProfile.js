import React, { useState } from "react";
import './AlumniProfile.css'
import { Avatar, Button } from "@mui/material";
import Education from "../ReusableCommponents/Education";
import PersonalDetail from "../ReusableCommponents/PersonalDetail";
import Location from "../ReusableCommponents/Location";
import Company from "../ReusableCommponents/Company";
import EducationHistory from "./EducationHistory";
import ProfessionalHistory from "../ReusableCommponents/ProfessionalHistory";
import ProfessionalExperienceList from "./ProfessionalExperienceList";

function AlumniProfile() {


    return (
        <div className="alumniProfile">
            <div className="left_Bar columnFlex centerItems">
                <Avatar />
                <h1>Haileab Goitum</h1>
                <PersonalDetail />
            </div>
            <div className="middle_bar centerItems">
                <Education />
            </div>
            <div className="right_bar columnFlex">
                <EducationHistory />
                <ProfessionalExperienceList />
                <button class="btn btn-primary">Save Changes</button>
            </div>
        </div>
    );
}

export default AlumniProfile;

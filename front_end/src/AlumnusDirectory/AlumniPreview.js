import React from "react";
import { Avatar } from "@mui/material";

import './AlumniPreview.css';

function AlumniPreview({ picture, lname, fname, phone }) {
    return (
        <div className="almuniPreview rowFlex">
            <Avatar />
            <div className="nameNphone columnFlex">
                <h1>{fname + " " + lname}</h1>
                <h5>{phone}</h5>
                <button class="form-control btn btn-primary">View Details</button>
            </div>
        </div>


    );
}

export default AlumniPreview;

import React, { useState } from "react";
import ApartmentIcon from '@mui/icons-material/Apartment';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import ConstructionIcon from '@mui/icons-material/Construction';

import './JobDetail.css';

function JobDetail({ jobId }) {
    const [job, setJob] = useState({});
    return (
        <div className="jobDetail">
            <div className="top">
                <h3>Software Engineer</h3>
                <div className="rowFlex dateNapplicants">
                    <p>20/02/2033</p>
                    <p>125 Applicants</p>
                </div>
                <div className="rowFlex">
                    <ApartmentIcon />
                    <p>Google</p>
                </div>
                <div className="rowFlex">
                    <LocationOnIcon />
                    <p>San Francisco, CA</p>
                </div>
                <div className="rowFlex">
                    <ConstructionIcon />
                    <p>Information Technology</p>
                </div>
                <button class="form-control btn btn-dark">Apply</button>
            </div>
            <div className="bottom">
                <h4>Required Skills</h4>
                <label htmlFor="">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</label>
                
                <h4>Good To Have</h4>
                <label htmlFor="">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</label>
            </div>

        </div>
    );
}

export default JobDetail;

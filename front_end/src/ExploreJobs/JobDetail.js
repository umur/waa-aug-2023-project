import React, { useEffect, useState } from "react";
import ApartmentIcon from '@mui/icons-material/Apartment';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import ConstructionIcon from '@mui/icons-material/Construction';
import { useSelector } from "react-redux";
import { selectJobPostPreviewId } from "./clickedJobPreviewIdSlice";

import './JobDetail.css';
import axios from "axios";

function JobDetail() {
    const [job, setJob] = useState({});
    const clickedJobPreviewId = useSelector(selectJobPostPreviewId);

    useEffect(() => {
        console.log("calledddd ", clickedJobPreviewId);

        const userId = localStorage.getItem('userId')
        if (userId) console.log("userIs in job details", userId);
        axios.get('http://localhost:8080/alumnus/' + userId + '/jobPosts/' + clickedJobPreviewId)
            .then((res) => {
                console.log('Job details from servicer', res.data);
                setJob(res.data)
            })
            .catch(err => console.log(err))
    }, [clickedJobPreviewId]);



    function apply() {
        axios.patch(
            'http://localhost:8080/alumnus/' + localStorage.getItem('userId') + '/jobPosts/' + clickedJobPreviewId
        )
        .then((res) => {
            const data = res.data;
            console.log('Applied ', data);
            setJob({...job, ...data});
        })

    }

    return (
        <div className="jobDetail">
            <div className="top">
                <h3>{job.position}</h3>
                <div className="rowFlex dateNapplicants">
                    <p>{job.postedAt}</p>
                    <p>{job.applicants && job.applicants.length} Applicants</p>
                </div>
                <div className="rowFlex">
                    <ApartmentIcon />
                    <p>{job.company && job.company.name}</p>
                </div>
                <div className="rowFlex">
                    <LocationOnIcon />
                    <p>
                        {job.company && job.company.location.city}, {job.company && job.company.location.state}
                    </p>
                </div>
                <div className="rowFlex">
                    <ConstructionIcon />
                    <p>{job.industry && job.industry.name}</p>
                </div>
                <button onClick={apply} class="form-control btn btn-dark">Apply</button>
            </div>
            <div className="bottom">
                <h4>Required Skills</h4>
                <label htmlFor="">{job.skills && job.skills}</label>

                <h4>Good To Have</h4>
                <label htmlFor="">{job.otherReq && job.otherReq}</label>
            </div>

        </div>
    );
}

export default JobDetail;

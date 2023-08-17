import React, { useEffect, useState } from "react";

import './JobsList.css';
import JobPreview from "./JobPreview";
import axios from "axios";

function JobsList() {
    const [jobsList, setJobsList] = useState([]);
    useEffect(()=>{
        axios.get('http://localhost:8080/alumnus/2000/jobPosts')
            .then((res)=> {
                console.log("Res", res)
                setJobsList(...jobsList, res.data)
                console.log("Joblist state", jobsList);
            })
            .catch((err)=>console.log(err))
    },[])
    return (
        <div className="jobsList">
            {jobsList.map(job => <JobPreview key={job.id} job={job} />)}
        </div>
    );
}

export default JobsList;

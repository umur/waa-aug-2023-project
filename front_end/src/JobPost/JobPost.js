import React, { useState } from "react";

import './JobPost.css';
import Location from "../ReusableCommponents/Location";
import Company from "../ReusableCommponents/Company";
import axios from "axios";
import { useNavigate } from "react-router";

function JobPost() {
    const navigate = useNavigate();
    const [position, setPosition] = useState('');
    const [skills, setSkills] = useState('');
    const [otherReq, setOtherReq] = useState('');
    const [industry, setIndustry] = useState({});
    const [company, setCompany] = useState({
        name: '',
        location: {
            city: '',
            state: '',
            street: '',
            zipCode: 0
        }
    });

    function jobPost() {
        // console.log({position, skills, otherReq, industry, company});
        axios.post(
            'http://localhost:8080/alumnus/2/jobPosts', 
            {position, skills, otherReq, industry, company}
        )
        .then(res => navigate('/exploreJobs'))
        .catch(err => console.log(err));
    }

    return (
        <div className="jobPost">
            <h4>New Job Post</h4>
            <input onChange={(e) => setPosition(e.target.value)} class="form-control form-control-sm" type="text" placeholder="Position" />
            <input onChange={(e) => setIndustry({ ...industry, name: e.target.value })} class="form-control form-control-sm" type="text" placeholder="Industry Name" />
            <textarea onChange={(e) => setSkills(e.target.value)} className="form-control" name="skills" id="skills" cols="52" rows="5" placeholder="Required Skills"></textarea>
            <textarea onChange={(e) => setOtherReq(e.target.value)} className="form-control" name="otherSkills" id="otherSkills" cols="52" rows="5" placeholder="Other Skills"></textarea>
            <Company companyState={{ company, setCompany }} getLocation={setIndustry} />
            <button onClick={jobPost} class="btn btn-dark btn-block ">Post</button>
        </div>
    );
}

export default JobPost;

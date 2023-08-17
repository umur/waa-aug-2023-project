import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';

import jobService from '../../services/jobService'; 

import '../../css/jobEx.css';

const JobExForm = () => {
    const navigate = useNavigate();
    const [handleJobExInput, setHandleJobExInput] = useState({
       company: '',
       position: ''
    });
    const [isLoading, setIsLoading] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setHandleJobExInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleJobEx = async () => {
        try {
            setIsLoading(true);
            const apiResponse = await jobService.createJobEx(handleJobExInput); 
            setIsLoading(false);
            if (apiResponse) {
                localStorage.setItem('JobEx_id', apiResponse.id);
                alert('Create Job Experience successfully');
                navigate('/');
            } else {
                alert('Bad credentials, try again');
            }
        } catch (error) {
            setIsLoading(false);
            console.error('API request error:', error);
            navigate('/500');
        }
    };

    return (
        <div className="JobEx-form-container">
            <label>Company:
                <input
                    name="company"
                    type="text"
                    value={handleJobExInput.company}
                    onChange={handleInputChange}
                />
            </label>
            <label>Position:
                <input
                    name="position"
                    type="text"
                    value={handleJobExInput.position}
                    onChange={handleInputChange}
                />
            </label>
           
            <Button color="primary" onClick={handleJobEx}>
                Create Job Experience
            </Button>
            {isLoading && <Loading />}
        </div>
    );
};

export default JobExForm;

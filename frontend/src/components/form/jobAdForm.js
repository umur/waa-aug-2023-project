import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';
import JobService from '../../services/jobService'; // Import your service for handling job advertisements
import '../../css/JobAdvertisementForm.css';

const CreateJobAdForm = () => {
    const navigate = useNavigate();
    const [jobAdvertisementInput, setJobAdvertisementInput] = useState({
        title: '',
        description: '',
        state: '',
        city: '',
        companyName: ''
    });
    const [isLoading, setIsLoading] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setJobAdvertisementInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleCreateJobAdvertisement = async () => {
        try {
            setIsLoading(true);
            const apiResponse = await JobService.createJobAdvertisement(jobAdvertisementInput);
            setIsLoading(false);
            if (apiResponse) {
                alert('Job Advertisement created successfully');
                navigate("/");
            } else {
                alert('Failed to create Job Advertisement');
            }
        } catch (error) {
            setIsLoading(false);
            console.error('API request error:', error);
            navigate('/500');
        }
    };

    return (
        <div className="job-form-container">
            <label>Title:
                <input
                    name="title"
                    type="text"
                    value={jobAdvertisementInput.title}
                    onChange={handleInputChange}
                />
            </label>
            <label>Description:
                <textarea
                    name="description"
                    value={jobAdvertisementInput.description}
                    onChange={handleInputChange}
                />
            </label>
            <label>State:
                <input
                    name="state"
                    type="text"
                    value={jobAdvertisementInput.state}
                    onChange={handleInputChange}
                />
            </label>
            <label>City:
                <input
                    name="city"
                    type="text"
                    value={jobAdvertisementInput.city}
                    onChange={handleInputChange}
                />
            </label>
            <label>Company Name:
                <input
                    name="companyName"
                    type="text"
                    value={jobAdvertisementInput.companyName}
                    onChange={handleInputChange}
                />
            </label>
            <Button color="primary" onClick={handleCreateJobAdvertisement}>
                Create Job Advertisement
            </Button>
            {isLoading && <Loading />}
        </div>
    );
};

export default CreateJobAdForm;

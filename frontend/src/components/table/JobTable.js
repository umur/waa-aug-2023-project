import React, { useState, useEffect } from 'react';
import JobService from '../../services/jobService';
import { useAuth } from '../../contexts/AuthContext';
import Job from './job';
import '../../css/JobTable.css';
import Button from '../button/Button';

const JobTable = () => {
    const { userId } = useAuth();
    const [userData, setUserData] = useState([]);
    const [filters, setFilters] = useState({
        state: '',
        city: '',
        companyName: ''
    });

    useEffect(() => {
        fetchData();
    }, [filters]);

    const fetchData = async () => {
        try {
            const data = await JobService.getJobsByStudentId(userId);
            setUserData(data);
        } catch (error) {
            console.error(error.message);
        }
    };

    const searchByFilters = async () => {
        try {
            const data = await JobService.getFilterJobAdvertisement(filters);
            setUserData(data);
        } catch (error) {
            console.error(error.message);
        }
    }

    const handleFilterChange = (e) => {
        const { name, value } = e.target;
        setFilters((prevFilters) => ({
            ...prevFilters,
            [name]: value
        }));
    };

    return (
        <div className="job-table-container">
            <h1>Job Table</h1>
            <div className="filter-container">
                <label htmlFor="state">State:</label>
                <input
                    type="text"
                    id="state"
                    name="state"
                    value={filters.state}
                    onChange={handleFilterChange}
                    placeholder="Filter by state"
                />
                <label htmlFor="city">City:</label>
                <input
                    type="text"
                    id="city"
                    name="city"
                    value={filters.city}
                    onChange={handleFilterChange}
                    placeholder="Filter by city"
                />
                <label htmlFor="companyName">Company Name:</label>
                <input
                    type="text"
                    id="companyName"
                    name="companyName"
                    value={filters.companyName}
                    onChange={handleFilterChange}
                    placeholder="Filter by company name"
                />
                <div>
                    <Button onClick={searchByFilters}>Search</Button>
                </div>
            </div>
            {userData && userData.length > 0 ? (
                <ul className="job-list">
                    {userData.map(job => (
                        <Job
                            key={job.id}
                            id={job.id}
                            title={job.title}
                            description={job.description}
                            state={job.state}
                            companyName={job.companyName}
                            city={job.city}
                        />
                    ))}
                </ul>
            ) : (
                <p>No job data available.</p>
            )}
        </div>
    );
}

export default JobTable;

import React, { useState, useEffect } from 'react';
import JobService from '../../services/jobService';
import { useAuth } from '../../contexts/AuthContext';
import Job from './job';

const JobTable = () => {
    const { userId } = useAuth();
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const data = await JobService.getJobsByStudentId(userId);
                setUserData(data);
            } catch (error) {
                console.error(error.message);
            }
        }
        fetchData();
    }, []);

    return (
        <div className="user-list-container">
            <h1>Job Table</h1>
            {userData && userData.length > 0 ? (
                <ul>
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
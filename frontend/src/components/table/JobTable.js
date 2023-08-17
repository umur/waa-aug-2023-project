import React, { useState, useEffect, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import bookingService, { handleFetchList } from '../../services/bookingService'; // Update with your actual import path
import UserService from '../../services/userService';
import User from './user';
import '../../css/UserList.css';
import JobService from '../../services/jobService';
import { useAuth } from '../../contexts/AuthContext';
import Job from './job';

const JobTable = () => {
    const { profileId } = useAuth();
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const data = await JobService.getJobsByStudentId(profileId);
                setUserData(data.data);
                console.log(data.data);
            } catch (error) {
                console.error(error.message);
            }
        }
        fetchData();
    }, [profileId]);

    return (
        <div className="user-list-container">
            <h1>Job Table</h1>
            {userData.length > 0 ? (
                <ul>
                    {userData.map(job => (
                        <Job
                            id={job.id}
                            email={job.title}
                            userRole={job.city}
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
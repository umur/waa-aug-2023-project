import React, { useState, useEffect } from 'react';
import jobService from '../../services/jobService';
import { useAuth } from '../../contexts/AuthContext';
import Experience from './experience';
import '../../css/experiencetable.css';
import Button from '../button/Button';

const ExperienceTable = () => {
    const { userId } = useAuth();
    const [userData, setUserData] = useState([]);
    const [filters, setFilters] = useState({
        companyName: '',
        position:''
    });

    useEffect(() => {
        fetchData();
    }, [filters]);

    const fetchData = async () => {
        try {
            const data = await jobService.getExperiencesByStudentId(userId);
            console.log(data.jobExperienceList);
            setUserData(data.jobExperienceList);
        } catch (error) {
            console.error(error.message);
        }
    };

    // const searchByFilters = async () => {
    //     try {
    //         const data = await JobService.getFilterJobAdvertisement(filters);
    //         setUserData(data);
    //     } catch (error) {
    //         console.error(error.message);
    //     }
    // }

    // const handleFilterChange = (e) => {
    //     const { name, value } = e.target;
    //     setFilters((prevFilters) => ({
    //         ...prevFilters,
    //         [name]: value
    //     }));
    // };

    return (
        <div className="experince-table-container">
            <h1>Experience Table</h1>
            {/* <div className="filter-container">
                <label htmlFor="company">Company Name:</label>
                <input
                    type="text"
                    id="company"
                    name="company"
                    value={filters.company}
                    onChange={handleFilterChange}
                    placeholder="Filter by company"
                />
                <label htmlFor="position">Position:</label>
                <input
                    type="text"
                    id="position"
                    name="position"
                    value={filters.position}
                    onChange={handleFilterChange}
                    placeholder="Filter by position"
                />
                <div>
                    <Button onClick={searchByFilters}>Search</Button>
                </div>
            </div> */}
            <div>
            {userData && userData.length > 0 ? (
                <ul className="experience-list">
                    {userData.map(experience => (
                        <Experience
                            key={experience.id}
                            id={experience.id}
                            companyName={experience.companyName}
                            position={experience.position}
                        />
                    ))}
                </ul>
            ) : (
                <p>No job data available.</p>
            )}
            </div>
        </div>
    );
}

export default ExperienceTable;

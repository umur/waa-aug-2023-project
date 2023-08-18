import { useEffect, useState } from 'react';
import CreateJob from './CreateJob';
import Job from './Job';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'
import { useToken } from '../Context/TokenContext'
export default function JobPage() {
    const navigate = useNavigate();
    const { token } = useToken();
    let [jobState, setJobState] = useState({
        jobs: []
    })


    const getJobs = async () => {
        try {
            const response = await axios.get('http://localhost:8080/job', {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            console.log(response.data);

            // Clear existing reviews and add new ones
            setJobState({
                jobs: response.data
            });
        } catch (error) {
            console.error('Axios Error:', error);
        }
    };

    useEffect(() => {
        getJobs();
    }, []);

    // Check if there is a token, if not, navigate to "/"
    if (!token) {
        navigate('/');
        return null; // You can also render a message or component if you prefer
    }

    function addJob(newJob) {
        setJobState((prevState) => ({
            ...prevState,
            jobs: [...prevState.jobs, newJob],
        }));
    }



    function listJobs(jobs) {
        return jobs.map((job) => {
            return (
                <div key={job.id} className="review-container">
                    <Job job={job} />
                </div>
            )
        });
    }



    return (
        <div>
            <h1>Job Portal</h1>
            <CreateJob addJob={addJob} />
            {listJobs(jobState.jobs)}
        </div>
    );
}
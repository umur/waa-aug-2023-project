import React from 'react';
import CreateJobAdForm from '../components/form/jobAdForm';
import { Link } from 'react-router-dom';

const CreateJob = () => {
    return (
        <div>
            <h1>This is create job advertiment page</h1>
            <CreateJobAdForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default CreateJob;

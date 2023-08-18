import React from 'react';
import CreateJobExForm from '../components/form/jobExForm';
import { Link } from 'react-router-dom';

const CreateJobEx = () => {
    return (
        <div>
            <h1>This is create job experience page</h1>
            <CreateJobExForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default CreateJobEx;
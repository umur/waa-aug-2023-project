import React from 'react';
import CreateJobAdForm from '../components/form/jobAdForm';
import { Link } from 'react-router-dom';

const CreateJobAd = () => {
    return (
        <div>
            <h1>This is profile page</h1>
            <CreateJobAdForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default CreateJobAd;

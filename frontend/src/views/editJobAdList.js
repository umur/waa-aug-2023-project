import React from 'react';
import { Link } from 'react-router-dom';
import JobTable from '../components/table/JobTable';

const EditJob = () => {
    return (
        <div>
            <h1>This is edit job advertisement page</h1>
            <JobTable/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default EditJob;
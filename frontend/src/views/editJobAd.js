import React from 'react';
import { Link } from 'react-router-dom';
import EditJobAdForm from '../components/form/editJobAdForm';

const EditJob = () => {
    return (
        <div>
            <h1>This is edit job advertisement page</h1>
            <EditJobAdForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default EditJob;
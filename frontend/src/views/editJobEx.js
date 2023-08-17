import React from 'react';
import { Link } from 'react-router-dom';
import EditJobExForm from '../components/form/editJobExForm';

const EditJobEx = () => {
    return (
        <div>
            <h1>This is edit job experience page</h1>
            <EditJobExForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default EditJobEx;
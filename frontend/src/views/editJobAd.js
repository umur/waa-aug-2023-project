import React from 'react';
import EditJobAdForm from '../components/form/editJobAdForm';
import { Link } from 'react-router-dom';

const EditJobAd = () => {
    return (
        <div>
            {/* <AppHeader/> */}
            <h1>This is edit job advertisement page</h1>
            <EditJobAdForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default EditJobAd;
import React from 'react';
import EditProfileForm from '../components/form/editProfileForm';
import { Link } from 'react-router-dom';

const EditProfile = () => {
    return (
        <div>
            {/* <AppHeader/> */}
            <h1>This is edit profile page</h1>
            <EditProfileForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default EditProfile;

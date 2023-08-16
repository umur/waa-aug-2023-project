import React from 'react';
import ProfileForm from '../components/form/profileForm';
import { Link } from 'react-router-dom';

const CreateProfile = () => {
    return (
        <div>
            {/* <AppHeader/> */}
            <h1>This is profile page</h1>
            <ProfileForm/>
            <Link to="/">Link to home page</Link>
        </div>
    );
};
export default CreateProfile;

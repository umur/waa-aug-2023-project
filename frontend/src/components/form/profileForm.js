import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Loading from '../loading/loading';

import ProfileService from '../../services/ProfileService';
import '../../css/ProfileForm.css';

const ProfileForm = () => {
    const navigate = useNavigate();
    const [handleProfileInput, setHandleProfileInput] = useState({
        firstName: '',
        lastName: '',
        dateOfBirth: '',
        gender: '',
        address: '',
        phoneNumber: '',
        graduationYear: '',
        numberOfExperience: '',
        profilePicture: ''
    });
    const [isLoading, setIsLoading] = useState(false);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setHandleProfileInput((prevInput) => ({
            ...prevInput,
            [name]: value,
        }));
    };

    const handleProfile = async () => {
        try {
            setIsLoading(true);
            const apiResponse = await ProfileService.handlePostApi('profile', handleProfileInput);
            setIsLoading(false);
            if (apiResponse) {
                alert('Create Profile successfully');
                navigate('/');
            } else {
                alert('Bad credentials, try again');
            }
        } catch (error) {
            setIsLoading(false);
            console.error('API request error:', error);
            navigate('/500');
        }
    };

    return (
        <div className="profile-form-container">
            <label>First Name:
                <input
                    name="firstName"
                    type="text"
                    value={handleProfileInput.firstName}
                    onChange={handleInputChange}
                />
            </label>
            <label>Last Name:
                <input
                    name="lastName"
                    type="text"
                    value={handleProfileInput.lastName}
                    onChange={handleInputChange}
                />
            </label>
            <label>Date of Birth:
                <input
                    name="dateOfBirth"
                    type="date"
                    value={handleProfileInput.dateOfBirth}
                    onChange={handleInputChange}
                />
            </label>
            <label>Gender:
                <input
                    name="gender"
                    type="text"
                    value={handleProfileInput.gender}
                    onChange={handleInputChange}
                />
            </label>
            <label>Address:
                <input
                    name="address"
                    type="text"
                    value={handleProfileInput.address}
                    onChange={handleInputChange}
                />
            </label>
            <label>Phone Number:
                <input
                    name="phoneNumber"
                    type="text"
                    value={handleProfileInput.phoneNumber}
                    onChange={handleInputChange}
                />
            </label>
            <label>Graduation Year:
                <input
                    name="graduationYear"
                    type="text"
                    value={handleProfileInput.graduationYear}
                    onChange={handleInputChange}
                />
            </label>
            <label>Number of Experience:
                <input
                    name="numberOfExperience"
                    type="text"
                    value={handleProfileInput.numberOfExperience}
                    onChange={handleInputChange}
                />
            </label>
            <label>Profile Picture URL:
                <input
                    name="profilePicture"
                    type="text"
                    value={handleProfileInput.profilePicture}
                    onChange={handleInputChange}
                />
            </label>
            <Button color="primary" onClick={handleProfile}>
                Create Profile
            </Button>
            {isLoading && <Loading />}
        </div>
    );
};

export default ProfileForm;

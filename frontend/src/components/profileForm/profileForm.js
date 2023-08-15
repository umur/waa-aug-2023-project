import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '../button/Button';
import Input from '../input/input';
import Loading from '../loading/loading';

import ProfileService from '../../services/ProfileService';

const ProfileForm = () => {
    const navigate = useNavigate();
    const [handleProfileInput, setHandleProfileInput] = useState({
    
    firstName:'',
    lastName:'',
    dateOfBirth:'',
    gender:'',
    address:'',
    phoneNumber:'',
    graduationYear:'',
    numberOfExperience:'',
    profilePicture:''
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
            const apiResponse = await ProfileService.handlePostApi('profile', handleLoginInput);
            setIsLoading(false);
            if (apiResponse.token) {
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
        <div>
            <label>firstName:
            <input
                name="firstName"
                type="text"
                value={handleProfileInput.firstName}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>lastName:
            <input
                name="lastName"
                type="text"
                value={handleProfileInput.lastName}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>dateOfBirth:
            <input
                name="dateOfBirth"
                type="date"
                value={handleProfileInput.dateOfBirth}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>gender:
             <input
                name="gender"
                type="text"
                value={handleProfileInput.gender}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>address:
            <input
                name="address"
                type="text"
                value={handleProfileInput.address}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>phoneNumber:
            <input
                name="phoneNumber"
                type="text"
                value={handleProfileInput.phoneNumber}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>graduationYear:
            <input
                name="graduationYear"
                type="text"
                value={handleProfileInput.graduationYear}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>numberOfExperience:
             <input
                name="numberOfExperience"
                type="text"
                value={handleProfileInput.numberOfExperience}
                onChange={handleInputChange}
            />
            </label>
            <br/>
            <label>profilePicture:
            <input
                name="profilePicture"
                type="text"
                value={handleProfileInput.profilePicture}
                onChange={handleInputChange}
            />
            </label>
            <br/>

        
            <Button color="primary" onClick={handleProfile}>
            Profile
            </Button>
            {isLoading && <Loading />}
        </div>
    );
};

export default ProfileForm;
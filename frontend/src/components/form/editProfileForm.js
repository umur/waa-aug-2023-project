// import React, { useState } from 'react';
import '../../css/ProfileForm.css';

import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import UserService from '../../services/userService';
import { useNavigate } from 'react-router-dom';

const EditProfileForm = () => {
  const navigate = useNavigate();
  const { token, profileId } = useAuth();

  const [user, setUser] = useState(null);
  const [editable, setEditable] = useState(false);
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

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response  = await UserService.handleGetSingleApi("profile",profileId);
        console.log("reponse", response)
          // eslint-disable-next-line eqeqeq
          if (response.id == profileId && response.role == token.role) {
            setEditable(true);
            setUser(response);
          }
      } catch (error) {
        console.error('An error occurred:', error);
      }
    }

    fetchUserData();
  }, [token,profileId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUser((prevInput) => ({
      ...prevInput,
      [name]: value,
    }));
  };

  const handlesumbitUpdate = async (e) => {
    try {
      const response  = await UserService.handlePutApi("profile",profileId,user);
        console.log("reponse", response)
          // eslint-disable-next-line eqeqeq
          if (response) {
            alert("update sucessful");
            navigate("/")
          }
    } catch(error) {
      console.log(error)
    }
  }

  return (
    <div className="profile-form-container">
      {editable ? (
        <form>
          <label htmlFor="firstName">First Name:</label>
          <input type="text" id="firstName" value={user.firstName} onChange={(e) => setUser({ ...user, firstName: e.target.value })} />

          <label htmlFor="lastName">Last Name:</label>
          <input type="text" id="lastName" value={user.lastName} onChange={(e) => setUser({ ...user, lastName: e.target.value })} />

          <label>Date of Birth:
            <input
              name="dateOfBirth"
              type="date"
              value={user.dateOfBirth}
              onChange={handleInputChange}
            />
          </label>
          <label>Gender:
            <input
              name="gender"
              type="text"
              value={user.gender}
              onChange={handleInputChange}
            />
          </label>
          <label>Address:
            <input
              name="address"
              type="text"
              value={user.address}
              onChange={handleInputChange}
            />
          </label>
          <label>Phone Number:
            <input
              name="phoneNumber"
              type="text"
              value={user.phoneNumber}
              onChange={handleInputChange}
            />
          </label>
          <label>Graduation Year:
            <input
              name="graduationYear"
              type="text"
              value={user.graduationYear}
              onChange={handleInputChange}
            />
          </label>
          <label>Number of Experience:
            <input
              name="numberOfExperience"
              type="text"
              value={user.numberOfExperience}
              onChange={handleInputChange}
            />
          </label>
          <label>Profile Picture URL:
            <input
              name="profilePicture"
              type="text"
              value={user.profilePicture}
              onChange={handleInputChange}
            />
          </label>
          <button onClick={handlesumbitUpdate}>Save Changes</button>
        </form>
      ) : (
        <p>You are not authorized to edit this profile.</p>
      )}
    </div>
  );
}


export default EditProfileForm;
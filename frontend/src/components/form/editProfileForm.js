// import React, { useState } from 'react';
import '../../css/ProfileForm.css';

import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';

const EditProfileForm = () => {
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
    async function fetchUserData() {
      try {
        // Fetch user data from your backend using the token
        const response = await fetch(`http://localhost:8080/profile/${profileId}`, {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });
        if (response.ok) {
          const userData = await response.json();
          setUser(userData);
          // eslint-disable-next-line eqeqeq
          if (userData.id == profileId && userData.role == token.role) {
            setEditable(true);
          }
        } else {
          // Handle error cases
          console.error('Error fetching user data');
        }
      } catch (error) {
        // Handle fetch or other errors
        console.error('An error occurred:', error);
      }
    }

    fetchUserData();
  }, [token,profileId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setHandleProfileInput((prevInput) => ({
      ...prevInput,
      [name]: value,
    }));
  };

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
          <button type="submit">Save Changes</button>
        </form>
      ) : (
        <p>You are not authorized to edit this profile.</p>
      )}
    </div>
  );
}


export default EditProfileForm;


// const EditProfile = () => {
//     const navigate = useNavigate();
//     const [handleProfileInput, setHandleProfileInput] = useState({
//         firstName: '',
//         lastName: '',
//         dateOfBirth: '',
//         gender: '',
//         address: '',
//         phoneNumber: '',
//         graduationYear: '',
//         numberOfExperience: '',
//         profilePicture: ''
//     });
//     const [isLoading, setIsLoading] = useState(false);

//     const handleInputChange = (e) => {
//         const { name, value } = e.target;
//         setHandleProfileInput((prevInput) => ({
//             ...prevInput,
//             [name]: value,
//         }));
//     };

//     const handleProfile = async () => {
//         try {
//             setIsLoading(true);
//             const apiResponse = await ProfileService.handlePostApi('profile', handleProfileInput);
//             setIsLoading(false);
//             if (apiResponse) {
//                 alert('Create Profile successfully');
//                 navigate('/');
//             } else {
//                 alert('Bad credentials, try again');
//             }
//         } catch (error) {
//             setIsLoading(false);
//             console.error('API request error:', error);
//             navigate('/500');
//         }
//     };

//     return (
//         <div className="profile-form-container">
//             <label>First Name:
//                 <input
//                     name="firstName"
//                     type="text"
//                     value={handleProfileInput.firstName}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Last Name:
//                 <input
//                     name="lastName"
//                     type="text"
//                     value={handleProfileInput.lastName}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Date of Birth:
//                 <input
//                     name="dateOfBirth"
//                     type="date"
//                     value={handleProfileInput.dateOfBirth}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Gender:
//                 <input
//                     name="gender"
//                     type="text"
//                     value={handleProfileInput.gender}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Address:
//                 <input
//                     name="address"
//                     type="text"
//                     value={handleProfileInput.address}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Phone Number:
//                 <input
//                     name="phoneNumber"
//                     type="text"
//                     value={handleProfileInput.phoneNumber}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Graduation Year:
//                 <input
//                     name="graduationYear"
//                     type="text"
//                     value={handleProfileInput.graduationYear}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Number of Experience:
//                 <input
//                     name="numberOfExperience"
//                     type="text"
//                     value={handleProfileInput.numberOfExperience}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <label>Profile Picture URL:
//                 <input
//                     name="profilePicture"
//                     type="text"
//                     value={handleProfileInput.profilePicture}
//                     onChange={handleInputChange}
//                 />
//             </label>
//             <Button color="primary" onClick={handleProfile}>
//                 Edit Profile
//             </Button>
//             {isLoading && <Loading />}
//         </div>
//     );
// };

// export default EditProfile;

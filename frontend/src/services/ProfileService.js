import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const ACCESS_TOKEN = localStorage.getItem('accessToken');

const ROLE = localStorage.getItem('role');

const handlePostApi = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/${endpoint}`,requestData, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + ACCESS_TOKEN,
                ...options.headers
            },
            ...options
        });
        console.log(ACCESS_TOKEN);
        if (response.status !== 200) {
            throw new Error(`API request failed with status: ${response.status}`);
        }
        return response.data;
    } catch (error) {
        throw new Error(`API request error: ${error.message}`);
    }
};

const handleGetApi = async (endpoint, options) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${endpoint}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + ACCESS_TOKEN,
                ...options.headers
            },
            ...options
        });
        if (response.status !== 200) {
            throw new Error(`API request failed with status: ${response.status}`);
        }
        return response.data;
    } catch (error) {
        throw new Error(`API request error: ${error.message}`);
    }
}
const handleUpdateApi = async (updatedProfileData, userRole, options = {}) => {
    try {
      let token = null;
  
      if (userRole === 'faculty') {
        token = ACCESS_TOKEN;
      } else if (userRole === 'alumni') {
        token = ACCESS_TOKEN;
      } else {
        throw new Error('Invalid user role.');
      }
  
      const response = await axios.post(
        `${API_BASE_URL}/update-profile`, // Replace with your update profile endpoint
        updatedProfileData,
        {
          headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token,
            ...options.headers,
          },
          ...options,
        }
      );
  
      if (response.status !== 200) {
        throw new Error(`API request failed with status: ${response.status}`);
      }
  
      return response.data;
    } catch (error) {
      throw new Error(`API request error: ${error.message}`);
    }
  };
  
  // Usage example
  const updatedProfileData = {
    firstName: 'John',
    lastName: 'Doe',
    
  };
  const userRole = 'faculty'; // Replace with the user's actual role (faculty or alumni)
  
  handleUpdateApi(updatedProfileData, userRole)
    .then(data => {
      console.log('Profile updated successfully:', data);
      // Perform any additional actions or state updates
    })
    .catch(error => {
      console.error('Error updating profile:', error);
      // Handle error scenarios
    });
  

const ProfileService = {
    handlePostApi,
    handleGetApi,
    handleUpdateApi
}

export default ProfileService;

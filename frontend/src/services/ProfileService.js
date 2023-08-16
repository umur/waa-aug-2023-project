import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const FACULTY_ACCESS_TOKEN = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyM0BleGFtcGxlLmNvbSIsImlzcyI6ImFwcCIsImlhdCI6MTY5MjE0Mzc4MiwiZXhwIjoxNjk0ODIyMTgyfQ.byLUTYYf9DPPFbc7VmuiME43favt33nYsBNZyQOltzHxvc4a1xthMzvGHaG2Ez3pKo7OsOkHCPgin7qn6V6FTA";

const ADMIN_ACCESS_TOKEN = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1c2VyNEBleGFtcGxlLmNvbSIsImlzcyI6ImFwcCIsImlhdCI6MTY5MjE0MzgzNywiZXhwIjoxNjk0ODIyMjM3fQ.z1Y1kXD7I5EPdJKYypfCLuflzxPMUFpDPG66phUocSyofDOV9Fb_LjAJiIyrV1tQw5zCur_GW2vRhFFNg-StPQ";

const ALUMNI_ACCESS_TOKEN = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhbHVtbmkxQGV4YW1wbGUuY29tIiwiaXNzIjoiYXBwIiwiaWF0IjoxNjkyMjA0OTIzLCJleHAiOjE2OTQ4ODMzMjN9.4vzdrh8U646GulstTG6mBSckHSkOjWUEuUm1vkM9lBuPuR1GtW7Q96eRxp3gK9byHUMSmjGCzTNal4OFjIZMlw";


const handlePostApi = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/${endpoint}`,requestData, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + ADMIN_ACCESS_TOKEN,
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
};

const handleGetApi = async (endpoint, options) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${endpoint}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + ADMIN_ACCESS_TOKEN,
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
        token = FACULTY_ACCESS_TOKEN;
      } else if (userRole === 'alumni') {
        token = ALUMNI_ACCESS_TOKEN;
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

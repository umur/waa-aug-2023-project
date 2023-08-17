// services/JobService.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080';

const ACCESS_TOKEN = localStorage.getItem('accessToken');

const JobService = {
  getJobAdvertisement: async (id, options = {}) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/jobAdvertisements/${id}`, {
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
  },

  updateJobAdvertisement: async (id, requestData = {}, options = {}) => {
    try {
      const response = await axios.put(`${API_BASE_URL}/jobAdvertisements/${id}`, requestData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + ACCESS_TOKEN,
          ...options.headers
        },
        ...options
      });
      if (response.status !== 201) {
        throw new Error(`API request failed with status: ${response.status}`);
      }
      return response.data;
    } catch (error) {
      throw new Error(`API request error: ${error.message}`);
    }
  },

  createJobAdvertisement: async (requestData = {}, options = {}) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/jobAdvertisements`, requestData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + ACCESS_TOKEN,
          ...options.headers
        },
        ...options
      });
      if (response.status !== 201) {
        throw new Error(`API request failed with status: ${response.status}`);
      }
      return response.data;
    } catch (error) {
      throw new Error(`API request error: ${error.message}`);
    }
  },
  

  getJobsByStudentId: async (jobId, options = {}) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/jobAdvertisements/findByStudentId/${jobId}`, {
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
  },

  getFilterJobAdvertisement: async (requestData = {}, options = {}) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/jobAdvertisements`, {
        params: requestData,
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
  },
  //create job Experience
  createJobEx: async (requestData = {}, options = {}) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/experiences`, requestData, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + ACCESS_TOKEN,
          ...options.headers
        },
        ...options
      });
      if (response.status !== 201) {
        throw new Error(`API request failed with status: ${response.status}`);
      }
      return response.data;
    } catch (error) {
      throw new Error(`API request error: ${error.message}`);
    }
  },
  getJobExperience: async (id, options = {}) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/experiences/${id}`, {
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
  },

  updateJobExperience: async (id, requestData = {}, options = {}) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/${id}/experience`, requestData, {
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
  },

  getExperiencesByStudentId: async (jobId, options = {}) => {
    console.log(`${API_BASE_URL}/experiences/profile/${jobId}`)
    try {
      const response = await axios.get(`${API_BASE_URL}/profile/${jobId}`, {
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
  },
}
export default JobService;

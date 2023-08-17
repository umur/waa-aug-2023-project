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

  getFilterJobAdvertisement: async (id, options = {}) => {
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
}
export default JobService;

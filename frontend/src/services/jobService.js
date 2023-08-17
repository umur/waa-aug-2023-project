// services/JobService.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Replace with your actual API URL

const JobService = {
  getJobAdvertisement: async (jobId) => {
    try {
      const response = await axios.get(`${API_BASE_URL}/api/jobAdvertisements/${jobId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  updateJobAdvertisement: async (jobAdvertisement) => {
    try {
      const response = await axios.put(`${API_BASE_URL}/api/jobAdvertisements/${jobAdvertisement.id}`, jobAdvertisement);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
  createJobAdvertisement: async (jobAdvertisementData) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/api/jobAdvertisements`, jobAdvertisementData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
};

export default JobService;

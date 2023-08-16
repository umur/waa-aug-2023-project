import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const ACCESS_TOKEN = localStorage.getItem('accessToken');

const handleGetSingleApi = async (endpoint, id, options = {}) => {
    
    try {
        const response = await axios.get(`${API_BASE_URL}/${endpoint}/${id}`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + ACCESS_TOKEN,
                ...options.headers
            },
            ...options
        });

        if (response.status !== 200) {
            return Promise.reject(new Error(`API request failed with status: ${response.status}`));
        }
        
        return response.data;
    } catch (error) {
        return Promise.reject(new Error(`API request error: ${error.message}`));
    }
};

const handlePutApi = async (endpoint,id ,requestData = {}, options = {}) => {
    try {
        const response = await axios.put(`${API_BASE_URL}/${endpoint}/${id}`, requestData, {
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
};

const UserService = {
    handleGetSingleApi,
    handlePutApi
}

export default UserService;

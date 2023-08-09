import axios from "axios";

const API_BASE_URL = "http://localhost:5000/api";

const handleLoginApi = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/${endpoint}`,requestData, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
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

export { handleLoginApi };

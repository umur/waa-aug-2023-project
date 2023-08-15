import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

const handlePostApi = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await axios.post(`${API_BASE_URL}/${endpoint}`,requestData, {
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

const ProfileService = {
    handlePostApi,
}

export default ProfileService;

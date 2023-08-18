import axios from "axios";

const API_BASE_URL = "http://localhost:5000/api"

const handleFetchList = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await axios.get(`${API_BASE_URL}/${endpoint}`,{
            headers: {
                'Content-Type': 'application/json',
                ...options.headers
            },
            ...options
        });
        if(response.status !== 200) {
            throw new Error(`API request failed with status: ${response.status}`);
        }
        return response.data;
    } catch (error) {
        throw new Error(`API request error: ${error.message}`);
    }
};

const handleCreateUser = () => {

}

const bookingService = {
    handleFetchList,
    handleCreateUser
}


export default bookingService ;
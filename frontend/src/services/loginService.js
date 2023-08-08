const API_BASE_URL = "http://localhost:5000/api";

const fetchApiData = async (endpoint, requestData = {}, options = {}) => {
    try {
        const response = await fetch(`${API_BASE_URL}/${endpoint}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                ...options.headers
            },
            body: JSON.stringify(requestData),
            ...options
        });

        if (!response.ok) {
            throw new Error(`API request failed with status: ${response.status}`);
        }

        const data = await response.json();
        return data;
    } catch (error) {
        throw new Error(`API request error: ${error.message}`);
    }
};

export { fetchApiData };

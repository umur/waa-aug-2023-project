// Import required packages
const express = require('express'); // Import the 'express' framework
const cors = require('cors'); // Import the 'cors' middleware
const axios = require('axios'); // Import the 'axios' HTTP client

// Create an instance of the express application
const app = express();

// Use the 'cors' middleware to handle CORS headers
app.use(cors());
app.use(express.json());

app.post('/api/auth', async (req, res) => {
  try {
    const apiResponse = await axios.post(
      'https://restful-booker.herokuapp.com/auth',
      {
        username: req.body.username,
        password: req.body.password
      },
      {
        headers: {
          'Content-Type': 'application/json'
        }
      }
    );

    res.json(apiResponse.data);
  } catch (error) {
    // Handle errors
    res.status(error.response?.status || 500).json({
      error: error.message
    });
  }
});

const PORT = 5000;

app.listen(PORT, () => {
  console.log(`Proxy server is running on port ${PORT}`);
});

import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext'; // Assuming you have an AuthContext for authentication
import JobService from '../../services/jobService'; // Import your service for handling job advertisements

const EditJobAdForm = () => {
  const { token } = useAuth();
  const [jobAdvertisement, setJobAdvertisement] = useState(null);
  const [editable, setEditable] = useState(false);

  useEffect(() => {
    const fetchJobAdvertisementData = async () => {
      try {
        // Fetch the job advertisement data using your service
        const response = await JobService.getJobAdvertisement(); // Replace with your actual method
        console.log(response && response.studentId === token.userId)
        if (response && response.studentId === token.userId) {
          setEditable(true);
          setJobAdvertisement(response);
        }
      } catch (error) {
        console.error('An error occurred:', error);
      }
    }

    fetchJobAdvertisementData();
  }, [token]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setJobAdvertisement((prevInput) => ({
      ...prevInput,
      [name]: value,
    }));
  };

  const handleSubmitUpdate = async (e) => {
    e.preventDefault();
    try {
      const response = await JobService.updateJobAdvertisement(jobAdvertisement); // Replace with your actual method
      if (response) {
        alert("Update successful");
        // Handle navigation or feedback as needed
      }
    } catch (error) {
      console.error('An error occurred:', error);
    }
  }

  return (
    <div className="job-advertisement-form-container">
      {editable && jobAdvertisement ? (
        <form>
          <label htmlFor="title">Title:</label>
          <input
            type="text"
            id="title"
            name="title"
            value={jobAdvertisement.title}
            onChange={handleInputChange}
          />
          <label htmlFor="city">Title:</label>
          <input
            type="text"
            id="city"
            name="city"
            value={jobAdvertisement.city}
            onChange={handleInputChange}
          />

          {/* Add similar input fields for other attributes like description, state, city, companyName */}
          
          <button onClick={handleSubmitUpdate}>Save Changes</button>
        </form>
      ) : (
        <p>You are not authorized to edit this job advertisement.</p>
      )}
    </div>
  );
}

export default EditJobAdForm;

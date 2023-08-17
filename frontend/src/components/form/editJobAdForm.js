import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import JobService from '../../services/jobService';
import { useParams } from 'react-router-dom';

const EditJobAdForm = () => {
  const { id } = useParams("id");
  const { token } = useAuth();
  const [jobAdvertisement, setJobAdvertisement] = useState(null);
  const [editable, setEditable] = useState(false);

  useEffect(() => {
    const fetchJobAdvertisementData = async () => {
      console.log(id)
      try {
        const response = await JobService.getJobAdvertisement(id);
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
      const response = await JobService.updateJobAdvertisement(id, jobAdvertisement);
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
          <label htmlFor="city">City:</label>
          <input
            type="text"
            id="city"
            name="city"
            value={jobAdvertisement.city}
            onChange={handleInputChange}
          />
          <button onClick={handleSubmitUpdate}>Save Changes</button>
        </form>
      ) : (
        <p>You are not authorized to edit this job advertisement.</p>
      )}
    </div>
  );
}
export default EditJobAdForm;

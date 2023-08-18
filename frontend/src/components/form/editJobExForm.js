import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import jobService from '../../services/jobService';
import profileService from '../../services/ProfileService';
import { useNavigate, useParams } from 'react-router-dom';

import '../../css/editJobEx.css'; 

const EditJobExForm = ({ jobId }) => {
  const navigate = useNavigate();
  const {id} = useParams();
  const { token, userId } = useAuth();

  const [jobExperience, setJobExperience] = useState(null);
  const [editable, setEditable] = useState(false);

  useEffect(() => {
    const fetchJobExperience = async () => {
      try {
        const response = await profileService.handleGetSingleApi(id);
        console.log(response)
        if (response) {
          setEditable(true);
          setJobExperience(response);
        }
      } catch (error) {
        console.error('An error occurred:', error);
      }
    };

    fetchJobExperience();
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setJobExperience((prevExperience) => ({
      ...prevExperience,
      [name]: value,
    }));
  };

  const handleSubmitUpdate = async (e) => {
    try {
      const response = await jobService.updateJobExperience(id, jobExperience);
      if (response) {
        alert('Update successful');
        navigate("/experiences")
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="job-ex-form-container">
      {editable ? (
        <div>
          <label htmlFor="companyName">CompanyName:</label>
          <input
            type="text"
            id="companyName"
            name="companyName"
            value={jobExperience.companyName}
            onChange={handleInputChange}
          />

          <label htmlFor="position">Position:</label>
          <input
            type="text"
            id="position"
            name="position"
            value={jobExperience.position}
            onChange={handleInputChange}
          />
          <div>
            <button onClick={handleSubmitUpdate}>Save Changes</button>
          </div>
        </div>
      ) : (
        <p>You are not authorized to edit this job experience.</p>
      )}
    </div>
  );
};

export default EditJobExForm;

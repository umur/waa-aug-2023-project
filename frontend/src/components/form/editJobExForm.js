import React, { useEffect, useState } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import jobService from '../../services/jobService';
import profileService from '../../services/ProfileService';

import '../../css/editJobEx.css'; 

const EditJobExForm = ({ jobId }) => {
  const { token, userId } = useAuth();

  const [jobExperience, setJobExperience] = useState(null);
  const [editable, setEditable] = useState(false);

  useEffect(() => {
    const fetchJobExperience = async () => {
      try {
        const response = await profileService.handleGetSingleApi("profile",userId);
        console.log(response.jobExperienceList)
        if (response) {
          setEditable(true);
          setJobExperience(response.jobExperienceList);
        }
      } catch (error) {
        console.error('An error occurred:', error);
      }
    };

    fetchJobExperience();
  }, [jobId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setJobExperience((prevExperience) => ({
      ...prevExperience,
      [name]: value,
    }));
  };

  const handleSubmitUpdate = async (e) => {
    try {
      const response = await jobService.updateJobExperience(jobId, jobExperience);
      if (response) {
        alert('Update successful');
        // You might want to redirect or perform other actions after successful update
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="job-ex-form-container">
      {editable ? (
        <form>
          <label htmlFor="company">Company:</label>
          <input
            type="text"
            id="company"
            name="company"
            value={jobExperience.company}
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
          <button onClick={handleSubmitUpdate}>Save Changes</button>
        </form>
      ) : (
        <p>You are not authorized to edit this job experience.</p>
      )}
    </div>
  );
};

export default EditJobExForm;

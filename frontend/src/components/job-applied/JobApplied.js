import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Swal from 'sweetalert2'

const ApplyToJobs = () => {
  const entity = "Job Advert";

  // Dummy data for job adverts
  const dummyJobAdverts = [
    {
      id: 1,
      jobTitle: "Software Engineer",
      jobDescription: "Develop and maintain software applications...",
      companyName: "TechCorp",
      expectedSalary: "$80,000",
    },
    {
      id: 2,
      jobTitle: "Data Analyst",
      jobDescription: "Analyze and interpret data to provide insights...",
      companyName: "Data Insights Inc.",
      expectedSalary: "$65,000",
    },
    // Add more dummy job adverts as needed
  ];

  const [jobAdverts, setJobAdverts] = useState([]);

  const getJobAdverts = async () => {
    try {
      // Simulating fetching job adverts from the server
      setJobAdverts(dummyJobAdverts);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    getJobAdverts();
  }, [])

  const handleJobApply = (id) => {
    Swal.fire({
      title: `Please confirm that you want to apply to this ${entity}?`,
      text: "Your details including your CV will be submitted to the job poster",
      icon: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, I would like to apply!'
    }).then(async (result) => {
      if (result.isConfirmed) {
        try {
          const studentId = 2;
          // Simulating the application process
          console.log(`Student with ID ${studentId} applied to job with ID ${id}`);
          getJobAdverts();
        } catch (error) {
          console.error(error);
        }
      }
    })
  }

  return (
    <>
      {jobAdverts &&
        <div>
          <h2>Apply to Jobs</h2>
          <div className="mt-5">
            <table className="table">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Job Title</th>
                  <th scope="col">Job Description</th>
                  <th scope="col">Company Name</th>
                  <th scope="col">Expected Salary</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {
                  jobAdverts.map((jobAdvert, index) => (
                    <tr key={jobAdvert.id}>
                      <td>{index + 1}</td>
                      <td>{jobAdvert.jobTitle}</td>
                      <td>{jobAdvert.jobDescription}</td>
                      <td>{jobAdvert.companyName}</td>
                      <td>{jobAdvert.expectedSalary}</td>
                      <td><button className="btn btn-sm btn-info" onClick={() => handleJobApply(jobAdvert.id)}>Apply to this Job</button></td>
                    </tr>
                  ))
                }
              </tbody>
            </table>
          </div>
        </div>
      }
    </>
  );
}

export default ApplyToJobs;

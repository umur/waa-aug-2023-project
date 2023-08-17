import React from "react";

import './JobPreview.css';

function JobPreview({ job }) {
  return (
    <div className="jobPreview columnFlex">
        <h2>{job.position}</h2>
        <h6>{job.company.name}</h6>
        <p>{job.company.location.city + ', ' + job.company.location.state}</p>

    </div>
  );
}

export default JobPreview;

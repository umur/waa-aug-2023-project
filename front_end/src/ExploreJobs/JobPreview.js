import React from "react";


import './JobPreview.css';
import { useDispatch } from "react-redux";
import { setJobPostPreviewId } from "./clickedJobPreviewIdSlice";

function JobPreview({ job }) {
  const dispatch = useDispatch();
  return (
    <div
      onClick={() => {
        console.log('Clicked div ' + job.id);
        dispatch(setJobPostPreviewId(job.id));
      }}
      className="jobPreview columnFlex"
    >
      <h2>{job.position}</h2>
      <h6>{job.company.name}</h6>
      <p>{job.company.location.city + ', ' + job.company.location.state}</p>

    </div>
  );
}

export default JobPreview;

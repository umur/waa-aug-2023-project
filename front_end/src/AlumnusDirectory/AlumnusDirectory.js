import React from "react";

import './AlumnusDirectory.css';
import FilterComponet from "../ReusableCommponents/FilterComponet";
import AlumniPreviewList from "./AlumniPreviewList";

function AlumnusDirectory() {
  return (
    <div className="alumnusDirectory columnFlex">
      <FilterComponet options={["Department", "Graduation Year", "Industry"]}/>
      <AlumniPreviewList/>
    </div>
  );
}

export default AlumnusDirectory;

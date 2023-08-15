import React from "react";

import './AlumnusDirectory.css';
import FilterComponet from "./FilterComponet";
import AlumniPreviewList from "./AlumniPreviewList";

function AlumnusDirectory() {
  return (
    <div className="alumnusDirectory columnFlex">
      <FilterComponet/>
      <AlumniPreviewList/>
    </div>
  );
}

export default AlumnusDirectory;

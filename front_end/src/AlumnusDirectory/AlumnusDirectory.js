import React from "react";

import './AlumnusDirectory.css';
import FilterComponet from "../ReusableCommponents/FilterComponet";
import AlumniPreviewList from "./AlumniPreviewList";
import { useDispatch } from "react-redux";
import { setDeptFilter } from "./deptFilterSlice";

function AlumnusDirectory() {
  const dispatch = useDispatch();
  function filter(selectedOption, value) {
    console.log(selectedOption, value);
    switch (selectedOption) {
      case 'Department': dispatch(setDeptFilter(value));
        
        break;
    
    }
  }
  return (
    <div className="alumnusDirectory columnFlex">
      <FilterComponet filter={filter} options={["Department", "Graduation Year", "Industry"]}/>
      <AlumniPreviewList/>
    </div>
  );
}

export default AlumnusDirectory;

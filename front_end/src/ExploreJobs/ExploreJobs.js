import React from "react";

import './ExploreJobs.css';
import FilterComponet from "../ReusableCommponents/FilterComponet";
import JobsList from "./JobsList";
import JobDetail from "./JobDetail";

function ExploreJobs() {
    return (
        <div className="exploreJobs columnFlex">
            <FilterComponet options={['Company Name', 'State', 'City']} />
            <div className="JobListNsingleJobDetail rowFlex">
                <JobsList/>
                <JobDetail/>
            </div>
        </div>
    );
}

export default ExploreJobs;

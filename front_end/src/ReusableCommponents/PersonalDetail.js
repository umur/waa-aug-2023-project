import React, { useEffect, useState } from "react";

import Location from "./Location";

function PersonalDetail({ alumniProfileState }) {
    const [location, setLocation] = useState({});
    useEffect(() =>{
        const locationProp = alumniProfileState.alumniProfile.location;
        if(locationProp) setLocation(locationProp)
    }, [])
    function getLocation(location) {
        return location;
    }
    return (
        <div className="personalDetail">
            <h4>Personal Details</h4>
            <div className="rowFlex">
                <input
                    onChange={(e) => {
                        alumniProfileState.setAlumniProfile(
                            { ...alumniProfileState.alumniProfile, firstName: e.target.value }
                        );
                    }}
                    value={alumniProfileState.alumniProfile.firstName}
                    class="form-control form-control-sm" type="text" placeholder="First Name" />
                <input
                    onChange={(e) => {
                        alumniProfileState.setAlumniProfile(
                            { ...alumniProfileState.alumniProfile, lastName: e.target.value }
                        );
                    }}
                    value={alumniProfileState.alumniProfile.lastName}
                    class="form-control form-control-sm" type="text" placeholder="Last Name" />
            </div>
            <input
                onChange={(e) => {
                    alumniProfileState.setAlumniProfile(
                        { ...alumniProfileState.alumniProfile, phoneNum: e.target.value }
                    );
                }}
                value={alumniProfileState.alumniProfile.phoneNum}
                class="form-control form-control-sm" type="number" placeholder="Phone Number" />
            <Location />
            <input
                onChange={(e) => {
                    alumniProfileState.setAlumniProfile(
                        { ...alumniProfileState.alumniProfile, industry: {...alumniProfileState.alumniProfile.industry, name: e.target.value}}
                    );
                }}
                // value={ alumniProfileState.alumniProfile.industry.name}
                class="form-control form-control-sm" type="text" placeholder="Industry i.e. IT" />
        </div>
    );
}

export default PersonalDetail;

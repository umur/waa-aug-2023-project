import React, { useState } from "react";
import Location from "./Location";

function Company({ companyState, getLocation }) {
    const [company, setCompany] = useState({});

    return (
        <div className="company">
            <input
                onChange={(e) => {
                    companyState.setCompany(
                        {...companyState.company, name: e.target.value }
                    );
                    setCompany({...company, name: e.target.value})
                }}
                class="form-control form-control-sm" type="text" placeholder="Company Name"
            />
            <Location companyState={companyState} />
        </div>
    );
}

export default Company;

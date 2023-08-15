import React from "react";
import Location from "./Location";

function Company() {
    return (
        <div className="company">
            <input class="form-control form-control-sm" type="text" placeholder="Company Name" />
            <Location />
        </div>
    );
}

export default Company;

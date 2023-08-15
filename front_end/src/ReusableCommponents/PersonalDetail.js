import React from "react";

import Location from "./Location";

function PersonalDetail() {
    return (
        <div className="personalDetail">
            <h4>Personal Details</h4>
            <div className="rowFlex">
                <input class="form-control form-control-sm" type="text" placeholder="First Name" />
                <input class="form-control form-control-sm" type="text" placeholder="Last Name" />
            </div>
            <input class="form-control form-control-sm" type="number" placeholder="Phone Number" />
            <Location/>
            <input class="form-control form-control-sm" type="text" placeholder="Industry i.e. IT" />
        </div>
    );
}

export default PersonalDetail;

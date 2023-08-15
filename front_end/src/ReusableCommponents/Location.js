import React from "react";

function Location() {
    return (
        <div className="location">
            <input class="form-control form-control-sm" type="text" placeholder="Street" />
            <input class="form-control form-control-sm" type="text" placeholder="City" />
            <div className="rowFlex">
                <input class="form-control form-control-sm" type="text" placeholder="State" />
                <input class="form-control form-control-sm" type="number" placeholder="Zip Code" />
            </div>
        </div>
    );
}

export default Location;

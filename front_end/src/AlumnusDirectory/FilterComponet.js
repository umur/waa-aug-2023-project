import React from "react";

import './FilterComponent.css';

function FilterComponet() {
    return (
        <div className="filterSection rowFlex">
            <select class="form-control" id="exampleFormControlSelect1">
                <option selected disabled>Filter By</option>
                <option>Department</option>
                <option>Graduation year</option>
                <option>Industry</option>
            </select>
            <input class="form-control form-control-sm" type="number" placeholder="Filter Value" />

            <button class="form-control btn btn-primary">Filter</button>
        </div>
    );
}

export default FilterComponet;

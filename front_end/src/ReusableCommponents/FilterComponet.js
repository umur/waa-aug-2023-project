import React from "react";

import './FilterComponent.css';

function FilterComponet({ options }) {
    return (
        <div className="filterSection rowFlex">
            <select class="form-control" id="exampleFormControlSelect1">
                <option selected disabled>Filter By</option>
                {options.map(option => <option>{option}</option>)}
            </select>
            <input class="form-control form-control-sm" type="number" placeholder="Filter Value" />

            <button class="form-control btn btn-primary">Filter</button>
        </div>
    );
}

export default FilterComponet;

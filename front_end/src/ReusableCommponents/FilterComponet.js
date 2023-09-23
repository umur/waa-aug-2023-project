import React, { useState } from "react";

import './FilterComponent.css';

function FilterComponet({ filter, options }) {
    const [selected, setSelected] = useState('');
    const [value, setValue] = useState('');
    return (
        <div className="filterSection rowFlex">
            <select
                onChange={(e) => setSelected(e.target.value)}
                class="form-control" id="exampleFormControlSelect1"
            >
                <option selected disabled>Filter By</option>
                {options.map(option => <option>{option}</option>)}
            </select>
            <input onChange={(e)=> setValue(e.target.value)} class="form-control form-control-sm" type="text" placeholder="Filter Value" />

            <button onClick={()=> filter(selected, value)} class="form-control btn btn-dark">Filter</button>
        </div>
    );
}

export default FilterComponet;

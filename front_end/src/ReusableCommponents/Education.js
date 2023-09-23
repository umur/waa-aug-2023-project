import React from "react";
import Location from "./Location";

function Education() {
    return (
        <div className="education">
            <h4>Education</h4>
            <input class="form-control form-control-sm" type="text" placeholder="Department" />
            <input class="form-control form-control-sm" type="text" placeholder="Major" />
            <div className="rowFlex">
                <input class="form-control form-control-sm" type="number" placeholder="Addmission Year" />
                <input class="form-control form-control-sm" type="number" placeholder="Graduation Year" />
            </div>
            <select class="form-control" id="exampleFormControlSelect1">
                <option selected disabled>Educational Level</option>
                <option>BSC</option>
                <option>BA</option>
                <option>MSC</option>
                <option>MBA</option>
                <option>MA</option>
                <option>PHD</option>
            </select>
                <input class="form-control form-control-sm" type="text" placeholder="University Name" />
                <Location/>
        </div>

    );
}

export default Education;

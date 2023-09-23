import React from "react";
import Company from "./Company";

function ProfessionalHistory() {
    return (
        <div className="professionalHistory">
            <div className="professionalHistory">
                <h4>Professional Experience</h4>
                <input class="form-control form-control-sm" type="text" placeholder="Postion" />
                <div className="rowFlex">
                    <input class="form-control form-control-sm" type="text" placeholder="From" />
                    <input class="form-control form-control-sm" type="text" placeholder="To" />
                </div>
                <Company />
            </div>
        </div>
    );
}

export default ProfessionalHistory;

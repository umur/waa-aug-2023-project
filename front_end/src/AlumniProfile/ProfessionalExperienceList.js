import React, { useState } from "react";

import ProfessionalHistory from "../ReusableCommponents/ProfessionalHistory";

function ProfessionalExperienceList() {
    const [ProfessionalHistoryComponet, setProfessionalHistory] = useState([]);
    function addProffesionalHostory() {
        setProfessionalHistory([...ProfessionalHistoryComponet, <ProfessionalHistory/>])
    }

    function removeProffesionalHostory(){
        setProfessionalHistory([...ProfessionalHistoryComponet.slice(0, ProfessionalHistoryComponet.length -1)]);
    }
    return (
        <div className="professionalExperience">
            {ProfessionalHistoryComponet}
            <div className="rowFlex">
                <button onClick={addProffesionalHostory} class="btn btn-primary roundButton">+</button>
                <h4>Professional History</h4>
                <button onClick={removeProffesionalHostory} class="btn btn-primary roundButton">-</button>
            </div>
        </div>
    );
}

export default ProfessionalExperienceList;

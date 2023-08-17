import React, { useState } from "react";

import Education from "../ReusableCommponents/Education";

function EducationHistory() {
    const [EducationalHistory, setEducationalHistory] = useState([]);
    function addEducationComponet() {
        setEducationalHistory([...EducationalHistory, <Education />])
    }
    function removeEduationalComponent() {
        setEducationalHistory([...EducationalHistory.slice(0, EducationalHistory.length - 1)]);
    }
    return (
        <div className="educationalHistory">
            {EducationalHistory}
            <div className="addRemoveBtns rowFlex">
                <button onClick={addEducationComponet} class="btn btn-dark roundButton">+</button>
                <h4>Eduational History</h4>
                <button onClick={removeEduationalComponent} class="btn btn-dark roundButton">-</button>
            </div>
        </div>
    );
}

export default EducationHistory;

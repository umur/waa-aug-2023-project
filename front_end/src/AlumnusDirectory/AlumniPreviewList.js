import React, { useState } from "react";

import './AlumniPreviewList.css';
import AlumniPreview from "./AlumniPreview";

function AlumniPreviewList() {
    const [almunus, setAlmunus] = useState([
        {picture: '', fName :'Haileab' , lName :'Goitum', phone:'1223424252'},
        {picture: '', fName :'Haileab' , lName :'Goitum', phone:'1223424252'}
    ]);

    return (
        <div className="almuniList columnFlex">
            {almunus.map((alumni) => {
                    return <AlumniPreview 
                                picture={alumni.picture} 
                                fname={alumni.fName} 
                                lname={alumni.lName}
                                phone={alumni.phone}
                            />
                }
            )}
        </div>
    );
}

export default AlumniPreviewList;

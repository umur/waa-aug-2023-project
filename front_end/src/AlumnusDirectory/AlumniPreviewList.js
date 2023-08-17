import React, { useEffect, useState } from "react";

import './AlumniPreviewList.css';
import AlumniPreview from "./AlumniPreview";
import axios from "axios";

function AlumniPreviewList() {
    const [almunus, setAlmunus] = useState([]);

    useEffect(()=>{
        const token = localStorage.getItem('token');
        console.log(token);
        axios.get('http://localhost:8080/alumnus', {headers: {Authorization: 'Bearer ' + token}})
            .then((res)=>{
                setAlmunus(...almunus, res.data);
                console.log("res", res.data);
            })
            .catch(err => console.log(err))
    },[]);

    return (
        <div className="almuniList columnFlex">
            {almunus.map((alumni) => {
                    return <AlumniPreview 
                                picture={alumni.profilePic} 
                                fname={alumni.firstName} 
                                lname={alumni.lastName}
                                phone={alumni.phoneNum}
                            />
                }
            )}
        </div>
    );
}

export default AlumniPreviewList;

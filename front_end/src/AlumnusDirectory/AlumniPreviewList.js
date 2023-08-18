import React, { useEffect, useState } from "react";

import './AlumniPreviewList.css';
import AlumniPreview from "./AlumniPreview";
import axios from "axios";
import { useSelector } from "react-redux";
import { selectDeptFilter } from "./deptFilterSlice";

function AlumniPreviewList() {
    const [almunus, setAlmunus] = useState([]);

    const deptFilter = useSelector(selectDeptFilter);

    useEffect(()=>{
        const token = localStorage.getItem('token');
        console.log(token);
        axios.get('http://localhost:8080/alumnus', {headers: {Authorization: 'Bearer ' + token}})
            .then((res)=>{
                const data = res.data;
                setAlmunus([...almunus, ...data]);
                console.log("res", res.data);
            })
            .catch(err => console.log(err))
    },[]);

    useEffect(()=>{
        const token = localStorage.getItem('token');
        console.log(token);
        axios.get('http://localhost:8080/filterByDept?dept='+ deptFilter, {headers: {Authorization: 'Bearer ' + token}})
            .then((res)=>{
                const data = res.data;
                setAlmunus([...almunus, ...data]);
                console.log("res fiter", res.data);
            })
            .catch(err => console.log(err))
    },[deptFilter]);

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

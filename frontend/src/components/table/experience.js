
import React from 'react';
import { Link } from 'react-router-dom';

const Experience = ({id, companyName, position}) => {
    // console.log("Received props:", { id, companyName, position });
    return (
        <div className="user-table-container">
            <table className="user-table">
            <thead>
                <tr>
                    <th>Company Name</th>
                    <th>Position</th>
                </tr>
            </thead>
            <tbody>
                <tr key={id}>
                    <td>{companyName}</td>
                    <td>{position}</td>
                    <td>
                        <Link to={`/jobEx/${id}/edit`}>Update</Link>
                        <br/>
                        <Link to={`/experiences/${id}/update`}>Delete</Link>
                    </td>
                </tr>
            </tbody>
        </table>
        </div>
    )
}
export default Experience;
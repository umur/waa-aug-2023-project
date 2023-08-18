// JobListTable.js

import React from 'react';
import { Link } from 'react-router-dom';

const Job = ({ id, title, description, state, companyName, city}) => {
    return (
        <table className="user-table">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>State</th>
                    <th>Company Name</th>
                    <th>City</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr key={id}>
                    <td>{title}</td>
                    <td>{description}</td>
                    <td>{state}</td>
                    <td>{companyName}</td>
                    <td>{city}</td>
                    <td>
                        <Link to={`/jobs/${id}/update`}>Update</Link>
                    </td>
                </tr>
            </tbody>
        </table>
    );
};

export default Job;

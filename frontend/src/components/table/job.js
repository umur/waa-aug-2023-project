// JobListTable.js

import React from 'react';
import { Link } from 'react-router-dom';

const Job = ({ id, title, city }) => {
    return (
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>City</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr key={id}>
                    <td>{title}</td>
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

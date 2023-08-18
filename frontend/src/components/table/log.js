import React from 'react';

const Log = ({ logLevel, logMessage}) => {
    return (
        <table className="user-table">
            <thead>
                <tr>
                    <th>Log Level</th>
                    <th>Log Message</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{logLevel}</td>
                    <td>{logMessage}</td>
                </tr>
            </tbody>
        </table>
    );
};

export default Log;

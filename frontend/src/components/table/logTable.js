import React, { useState, useEffect } from 'react';
import '../../css/UserList.css';
import Log from './log';
import AdminService from '../../services/AdminService';

const LogTable = () => {
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const data = await AdminService.handleGetLogsApi();
                setUserData(data.data);
                console.log(data.data);
            } catch (error) {
                console.error(error.message);
            }
        }
        fetchData();
    }, []);

    return (
        <div className="user-list-container">
            <h1>Log Table</h1>
            <ul>
                {userData.map(log => (
                    <Log
                        logLevel={log.logLevel}
                        logMessage={log.logMessage}
                    />
                ))}
            </ul>
        </div>
    );
}

export default LogTable;

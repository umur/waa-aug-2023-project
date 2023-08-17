import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import bookingService, { handleFetchList } from '../../services/bookingService'; // Update with your actual import path
import UserService from '../../services/userService';
import UserTable from '../table/userTable';
import '../../css/UserList.css';

const UserList = () => {
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const data = await UserService.handleGetApi("users");
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
            <h1>User Table</h1>
            <ul>
                {userData.map(user => (
                    <UserTable
                        id={user.id}
                        email={user.email}
                        userRole={user.userRole}
                        lastLogin={user.lastLogin}
                        loginAttempt={user.loginAttempt}
                        active={user.active}
                    />
                ))}
            </ul>
        </div>
    );
}

export default UserList;

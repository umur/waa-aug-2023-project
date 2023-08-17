import React, { useState } from 'react';
import '../../css/UserTable.css';
import AdminService from '../../services/AdminService';

const UserTable = ({ id, email, userRole, lastLogin, loginAttempt, active }) => {
    const [isChecked, setIsChecked] = useState(active);

    const handleCheckboxChange = async () => {
        try {
            if (userRole === 'ADMIN') {
                alert("Cannot deactivate users with role ADMIN");
                return;
            }

            if (isChecked) {
                await AdminService.handleDeactiveApi('admin', id);
            } else {
                await AdminService.handleActiveApi('admin', id);
            }
            setIsChecked(prev => !prev);
        } catch (error) {
            console.error('An error occurred:', error);
        }
    };

    return (
        <table className="user-table">
            <thead>
                {/* ... */}
            </thead>
            <tbody>
                <tr key={id}>
                    <td>{id}</td>
                    <td>{email}</td>
                    <td>{userRole}</td>
                    <td>{lastLogin}</td>
                    <td>{loginAttempt}</td>
                    <td>
                        <input
                            className="active-checkbox"
                            type="checkbox"
                            checked={isChecked}
                            onChange={handleCheckboxChange}
                        />
                    </td>
                </tr>
            </tbody>
        </table>
    );
};

export default UserTable;

import React, { useState } from 'react';
import AdminService from '../../services/AdminService';
import '../../css/ResetPasswordForm.css';
import { useNavigate, useParams } from 'react-router-dom';

const ResetPasswordForm = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [newPassword, setNewPassword] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    const handlePasswordReset = async () => {
        try {
            setIsLoading(true);
            const requestData = { newPassword };
            await AdminService.handleResetPasswordApi('admin', id, requestData);
            setIsLoading(false);
            alert('Password reset successful');
            navigate("/admin/user")
        } catch (error) {
            setIsLoading(false);
            console.error('An error occurred:', error);
            alert('Password reset failed');
        }
    };

    return (
        <div className="reset-password-form-container">
            <h2>Reset Password</h2>
            <label>New Password:</label>
            <input
                type="password"
                value={newPassword}
                onChange={(e) => setNewPassword(e.target.value)}
            />
            <button onClick={handlePasswordReset} disabled={isLoading}>
                {isLoading ? 'Resetting...' : 'Reset Password'}
            </button>
        </div>
    );
};

export default ResetPasswordForm;

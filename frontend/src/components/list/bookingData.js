import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import bookingService, { handleFetchList } from '../../services/bookingService'; // Update with your actual import path
import { handleFetchListMock } from '../../services/handleFetchListMock';

const BookingData = () => {
    const navigate = useNavigate();
    const [userData, setUserData] = useState([]);

    useEffect(() => {
        async function fetchData() {
            try {
                const data = await bookingService.handleFetchList('list');
                setUserData(data);
                console.log(data);
            } catch (error) {
                console.error(error.message);
            }
        }
        fetchData();
    }, []);

    return (
        <div>
            <h1>User List</h1>
            <ul>
                {userData.map(user => (
                    <li>{user.bookingid}</li>
                ))}
            </ul>
        </div>
    );
}

export default BookingData;

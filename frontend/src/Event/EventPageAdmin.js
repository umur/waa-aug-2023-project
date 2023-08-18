import { useEffect, useState } from 'react';
import CreateEvent from './CreateEvent';
import axios from 'axios';
import Event from './Event';
import { useNavigate } from 'react-router-dom'
import {useToken } from '../Context/TokenContext'
export default function EventPage() {

    const navigate = useNavigate();
    const { token } = useToken();


    let [eventState, setEventState] = useState({
        events: []
    })

    const getEvents = async () => {
        try {
            const response = await axios.get('http://localhost:8080/event');
            console.log(response.data);

            // Clear existing reviews and add new ones
            setEventState({
                events: response.data
            });
        } catch (error) {
            console.error('Axios Error:', error);
        }
    };
    useEffect(() => {
        getEvents();
    }, []);

    // Check if there is a token, if not, navigate to "/"
    if (!token) {
        navigate('/');
        return null; // You can also render a message or component if you prefer
    }

    function addEvent(newEvent) {
        setEventState((prevState) => ({
            ...prevState,
            events: [...prevState.events, newEvent],
        }));
    }

 

   


    function listEvents(events) {
        return events.map((event) => {
            return (
                <div key={event.id} className="review-container">
                    <Event event={event} />
                </div>
            )
        });
    }



    return (
        <div>
            <h1>Event Portal</h1>
            <CreateEvent addEvent={addEvent} />
            {listEvents(eventState.events)}
        </div>
    );
}
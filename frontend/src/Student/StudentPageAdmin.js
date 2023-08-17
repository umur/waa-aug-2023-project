import { useEffect, useState } from 'react';
import CreateStudent from './CreateStudent';
import Student from './Student';
import axios from 'axios';
import { useNavigate } from 'react-router-dom'
import { useToken } from '../Context/TokenContext'
export default function StudentPage() {

    const navigate = useNavigate();
    const { token } = useToken();
    let [studentState, setStudentState] = useState({
        students: []
    })

    function addStudent(newStudent) {
        setStudentState((prevState) => ({
            ...prevState,
            students: [...prevState.students, newStudent],
        }));
    }

    const getStudents = async () => {
        try {
            const response = await axios.get('http://localhost:8080/student');
            console.log(response.data);

            // Clear existing reviews and add new ones
            setStudentState({
                students: response.data
            });
        } catch (error) {
            console.error('Axios Error:', error);
        }
    };

    useEffect(() => {
        getStudents();
    }, []);
    // Check if there is a token, if not, navigate to "/"
    if (!token) {
        navigate('/');
        return null; // You can also render a message or component if you prefer
    }



    function listStudents(students) {
        return students.map((student, i) => {
            return (
                <div key={i} className="review-container">
                    <Student student={student} />
                </div>
            )
        });
    }



    return (
        <div>
        <h1>Alumni Directory</h1>
            <CreateStudent addStudent={addStudent} />
            {listStudents(studentState.students)}
        </div>
    );
}
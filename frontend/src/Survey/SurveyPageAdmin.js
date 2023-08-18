import { useEffect, useState } from 'react';
import axios from 'axios';
import Survey from './Survey';
import CreateSurvey from './CreateSurvey';
import { useNavigate } from 'react-router-dom'
import { useToken } from '../Context/TokenContext'
export default function SurveyPage() {
    const navigate = useNavigate();
    const { token } = useToken();
    let [surveyState, setSurveyState] = useState({
        surveys: []
    })

    function addSurvey(newSurvey) {
        setSurveyState((prevState) => ({
            ...prevState,
            surveys: [...prevState.surveys, newSurvey],
        }));
    }

    const getSurveys = async () => {
        try {
            const response = await axios.get('http://localhost:8080/survey');
            console.log(response.data);

            // Clear existing reviews and add new ones
            setSurveyState({
                surveys: response.data
            });
        } catch (error) {
            console.error('Axios Error:', error);
        }
    };

    useEffect(() => {
        getSurveys();
    }, []);
    if (!token) {
        navigate('/');
        return null; // You can also render a message or component if you prefer
    }



    function listSurveys(surveys) {
        return surveys.map((survey) => {
            return (
                <div key={survey.id} className="review-container">
                    <Survey survey={survey} />
                </div>
            )
        });
    }



    return (
        <div>
            <h1>Survey Portal</h1>
            <CreateSurvey addSurvey={addSurvey} />
            {listSurveys(surveyState.surveys)}
        </div>
    );
}
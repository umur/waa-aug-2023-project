import { useEffect, useState } from 'react';
import CreateNews from './CreateNews';
import axios from 'axios';
import News from './News';
import { useNavigate } from 'react-router-dom'
import { useToken } from '../Context/TokenContext'
export default function NewsPage() {
    const navigate = useNavigate();
    const { token } = useToken();
    let [newsState, setNewsState] = useState({
        newses: []
    })

    const getNews = async () => {
        try {
            const response = await axios.get('http://localhost:8080/news');
            console.log(response.data);

            // Clear existing reviews and add new ones
            setNewsState({
                newses: response.data
            });
        } catch (error) {
            console.error('Axios Error:', error);
        }
    };

    useEffect(() => {
        getNews();
    }, []);

    // Check if there is a token, if not, navigate to "/"
    if (!token) {
        navigate('/');
        return null; // You can also render a message or component if you prefer
    }

    function addNews(newNews) {
        setNewsState((prevState) => ({
            ...prevState,
            newses: [...prevState.newses, newNews],
        }));
    }

 


    function listNews(newses) {
        return newses.map((news) => {
            return (
                <div key={news.id} className="review-container">
                    <News news={news} />
                </div>
            )
        });
    }



    return (
        <div>
            <h1>News Portal</h1>
            <CreateNews addNews={addNews} />
            {listNews(newsState.newses)}
        </div>
    );
}
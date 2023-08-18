import axios from 'axios';
import ReactEcharts from 'echarts-for-react';
import { useEffect, useState } from 'react';

const Dashboard = () => {

  const [cityData, setCityData] = useState('');
  const [stateData, setStateData] = useState('');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      // Simulating response data for studentsPerState and studentsPerCity
      const response1 = await axios.get('/auth/studentsPerState');
      setCityData(response1.data);

      const response2 = await axios.get('/auth/studentsPerCity');
      setStateData(response2.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  // Dummy data for cities and studentPerCityCounter
  const cities = ['City A', 'City B', 'City C', 'City D', 'City E'];
  const studentPerCityCounter = [150, 120, 200, 80, 300];

  // Dummy data for states and studentPerStateCounter
  const states = ['State X', 'State Y', 'State Z', 'State W', 'State V'];
  const studentPerStateCounter = [700, 500, 300, 900, 1200];

  const cityOption = {
    title: {
      text: 'Number of Students in Each City',
    },
    tooltip: {},
    xAxis: {
      data: cities,
    },
    yAxis: {},
    series: [
      {
        name: 'Student Count',
        type: 'bar',
        data: studentPerCityCounter,
      },
    ],
  };

  const stateOption = {
    title: {
      text: 'Number of Students in Each State',
    },
    tooltip: {},
    xAxis: {
      data: states,
    },
    yAxis: {},
    series: [
      {
        name: 'Student Count',
        type: 'bar',
        data: studentPerStateCounter,
      },
    ],
  };

  return (
    <>
      <ReactEcharts option={cityOption} style={{ height: '400px' }} />
      <br />
      <ReactEcharts option={stateOption} style={{ height: '400px' }} />
    </>
  );
}

export default Dashboard;

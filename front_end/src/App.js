import React from 'react';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import './App.css';
import AlumniProfile from './AlumniProfile/AlumniProfile';
import AlumnusDirectory from './AlumnusDirectory/AlumnusDirectory';
import ExploreJobs from './ExploreJobs/ExploreJobs';
import Login from './Login/Login';
import NavBar from './NavBar/NavBar';
import { Outlet } from 'react-router';
function App() {
  return (
    <div className="app">
      <div className='exculdeBg'>
      <NavBar/>
      </div>
        {/* <ExploreJobs/> */}
        {/* <AlumnusDirectory/> */}
        {/* <AlumniProfile/> */}
       <Outlet/>

    </div>
  );
}

export default App;

import React from 'react';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import './App.css';
import AlumniProfile from './AlumniProfile/AlumniProfile';
import AlumnusDirectory from './AlumnusDirectory/AlumnusDirectory';
import ExploreJobs from './ExploreJobs/ExploreJobs';
function App() {
  return (
    <div className="app">
      <ExploreJobs/>
      {/* <AlumnusDirectory/> */}
      {/* <AlumniProfile/> */}
    </div>
  );
}

export default App;

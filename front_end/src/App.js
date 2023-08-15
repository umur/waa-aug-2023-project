import React from 'react';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import './App.css';
import AlumniProfile from './AlumniProfile/AlumniProfile';
import AlumnusDirectory from './AlumnusDirectory/AlumnusDirectory';
function App() {
  return (
    <div className="app">
      <AlumnusDirectory/>
      {/* <AlumniProfile/> */}
    </div>
  );
}

export default App;

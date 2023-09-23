import React from 'react';
import { createRoot } from 'react-dom/client';
import { Provider } from 'react-redux';
import { store } from './app/store';
import App from './App';
import reportWebVitals from './reportWebVitals';
import './index.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AlumnusDirectory from './AlumnusDirectory/AlumnusDirectory';
import AlumniProfile from './AlumniProfile/AlumniProfile';
import ExploreJobs from './ExploreJobs/ExploreJobs';
import Login from './Login/Login';
import Register from './Register/Register';
import JobPost from './JobPost/JobPost';
import AlumniDashboard from './AlumniDashboard/AlumniDashboard';

const container = document.getElementById('root');
const root = createRoot(container);

root.render(
  
    <Provider store={store}>
      <BrowserRouter>
      <Routes>
        <Route path='/' element={<App/>}>
          <Route index element={<AlumnusDirectory/>} />
          <Route path='directory' element = {<AlumnusDirectory/>}/>
          <Route path='alumniProfile' element={<AlumniProfile/>} />
          <Route path='exploreJobs' element={<ExploreJobs/>} />
          <Route path='login' element={<Login/>}/>
          <Route path='register' element={<Register/>}/>
          <Route path='jobPost' element={<JobPost/>}/>
          <Route path='dashboard' element={<AlumniDashboard/>}/>
        </Route>
      </Routes>
      </BrowserRouter>
    </Provider>


);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

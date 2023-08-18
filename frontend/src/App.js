// App.js
import React, { Component, Suspense, useContext } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import loading from './components/loading/loading';
import ThemeProvider from './contexts/ThemeContext';
import './css/dark-theme.css'
import AppHeader from './components/header/AppHeader';
import AppSidebar from './components/sidebar/AppSidebar';
import Register from './views/register';
import AppFooter from './components/footer/AppFooter';
import { AuthProvider, useAuth } from './contexts/AuthContext';
import User from './views/user';
import Reset from './views/reset';
import LogSystem from './views/logSystem';

const Home = React.lazy(() => import('./views/home'))
const Login = React.lazy(() => import('./views/login'))
const CreateProfile = React.lazy(() => import('./views/createProfile'))
const CreateJob = React.lazy(() => import('./views/createJobAd'))
const CreateJobEx = React.lazy(() => import('./views/createJobEx'))
const EditJobEx = React.lazy(() => import('./views/editJobEx'))
const EditProfile = React.lazy(() => import('./views/editProfile'))
const EditJobList = React.lazy(() => import('./views/editJobAdList'))
const EditJob = React.lazy(() => import('./views/editJobAd'))
const NotFoundError = React.lazy(() => import('./views/404'))
const InternalServerError = React.lazy(() => import('./views/500'))
const Experience = React.lazy(() => import('./views/experience'))

class App extends Component {
  render() {
    return (
      <div className="App">
        <ThemeProvider>
          <AuthProvider>
            <BrowserRouter>
              <div className="app-container">
                <AppSidebar />
                <div className="app-main">
                  <AppHeader />
                  <Suspense fallback={loading}>
                    <Routes>
                      <Route path="/login" name="Login Page" element={<Login />} />
                      <Route path="/register" name="Register Page" element={<Register />} />
                      <Route path="/profile/create" name="Create Profile Page" element={<CreateProfile />} />
                      <Route path="/profile/edit" name="Create Profile Page" element={<EditProfile />} />
                      <Route path="/jobEx/create" name="Create Job Experience Page" element={<CreateJobEx />} />
                      <Route path="/jobEx/:id/edit" name="Edit Job Experience Page" element={<EditJobEx />} />
                      <Route path="/jobs/create" name="Create Job Advertiment Page" element={<CreateJob />} />
                      <Route path="/jobs/edit" name="Edit Job Advertisment List Page" element={<EditJobList />} />
                      <Route path="/jobs/:id/update" name="Edit Job Advertisment Page" element={<EditJob />} />
                      <Route path="/admin/user" name="User Page" element={<User />} />
                      <Route path="/admin/reset-password/:id" name="Reset Password Page" element={<Reset />} />
                      <Route path="/admin/log" name="Log System Page" element={<LogSystem />} />
                      <Route path="/404" name="Not Found Page" element={<NotFoundError />} />
                      <Route path="/500" name="Internal Server Page" element={<InternalServerError />} />
                      <Route path="/experiences" name="Edit Job Experience Page" element={<Experience />} />
                      <Route path="*" element={<Home />} />
                    </Routes>
                  </Suspense>
                  <AppFooter />
                </div>
              </div>
            </BrowserRouter>
          </AuthProvider>
        </ThemeProvider>
      </div>
    );
  }
}

export default App;
// App.js
import React, { Component, Suspense } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import loading from './components/loading/loading';
import ThemeProvider from './contexts/ThemeContext';
import './css/dark-theme.css'
import AppHeader from './components/header/AppHeader';
import AppSidebar from './components/sidebar/AppSidebar';

const Home = React.lazy(() => import('./views/home'))
const Login = React.lazy(() => import('./views/login'))
const Profile = React.lazy(() => import('./views/profile'))
const NotFoundError = React.lazy(() => import('./views/404'))
const InternalServerError = React.lazy(() => import('./views/500'))

class App extends Component {
  render() {
    return (
      <div className="App">
        <ThemeProvider>
          <BrowserRouter>
            <div className="app-container">
              <AppSidebar />
              <div className="app-main">
                <AppHeader />
                <Suspense fallback={loading}>
                  <Routes>
                    <Route path="/login" name="Login Page" element={<Login />} />
                    <Route path="/profile" name="Profile Page" element={<Profile />} />
                    <Route path="/404" name="Not Found Page" element={<NotFoundError />} />
                    <Route path="/500" name="Internal Server Page" element={<InternalServerError />} />
                    <Route path="*" element={<Home />} />
                  </Routes>
                </Suspense>
              </div>
            </div>
          </BrowserRouter>
        </ThemeProvider>
      </div>
    );
  }
}

export default App;
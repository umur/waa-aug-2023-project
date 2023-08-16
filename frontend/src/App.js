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

const Home = React.lazy(() => import('./views/home'))
const Login = React.lazy(() => import('./views/login'))
const CreateProfile = React.lazy(() => import('./views/createProfile'))
const EditProfile = React.lazy(() => import('./views/editProfile'))
const NotFoundError = React.lazy(() => import('./views/404'))
const InternalServerError = React.lazy(() => import('./views/500'))

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
                      <Route path="/create-profile" name="Create Profile Page" element={<CreateProfile />} />
                      <Route path="/edit-profile" name="Create Profile Page" element={<EditProfile />} />
                      <Route path="/404" name="Not Found Page" element={<NotFoundError />} />
                      <Route path="/500" name="Internal Server Page" element={<InternalServerError />} />
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
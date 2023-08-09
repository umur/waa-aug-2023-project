import React, { Component, Suspense } from 'react';
import { HashRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import loading from './components/loading/loading';
import ThemeProvider from './contexts/ThemeContext';
import './css/dark-theme.css'
import DefaultLayout from './layout/DefaultLayout';

const Home = React.lazy(() => import('./views/home'))
const Login = React.lazy(() => import('./views/login'))
const NotFoundError = React.lazy(() => import('./views/404'))
const InternalServerError = React.lazy(() => import('./views/500'))

class App extends Component {
  render() {
    return (
      <div className="App">
        <ThemeProvider>
          <HashRouter>
            <Suspense fallback={loading} >
              <Routes>
                <Route path="/login" name="Login Page" element={<Login />} />
                <Route path="/404" name="Not Found Page" element={<NotFoundError />} />
                <Route path="/500" name="Internal Server Page" element={<InternalServerError />} />
                <Route path="*" element={<Home />} />
              </Routes>
            </Suspense>
          </HashRouter>
        </ThemeProvider>
      </div>
    );
  }
}

export default App;

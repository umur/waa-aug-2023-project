import React, { Component, Suspense } from 'react';
import { HashRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import loading from './components/loading/loading';

const Home = React.lazy(() => import('./views/home'))
const Login = React.lazy(() => import('./views/login'))
const NotFoundError = React.lazy(() => import('./views/404'))
const InternalServerError = React.lazy(() => import('./views/500'))

class App extends Component {
  render() {
    return (
      <div className="App">
        <HashRouter>
          <Suspense fallback={loading} >
          <Routes>
            <Route path="/login" name="Login Page" element={<Login />} />
            <Route path="/404" name="Not Found Page" element={<NotFoundError />} />
            <Route path="/500" name="Internal Server Page" element={<InternalServerError />} />
            <Route path="*" name="Home" element={<Home />} />
          </Routes>
          </Suspense>
        </HashRouter>
      </div>
    );
  }
}

export default App;

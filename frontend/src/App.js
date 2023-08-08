import React, { Component, Suspense } from 'react';
import { HashRouter, Route, Routes } from 'react-router-dom';

import Login from './views/login';
import Home from './views/home';
import NotFound from './views/404';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <HashRouter>
          <Suspense fallback="loading" />
          <Routes>
            <Route exact path="/login" name="Login Page" element={<Login />} />
            <Route exact path="/404" name="Login Page" element={<NotFound />} />
            <Route path="*" name="Home" element={<Home />} />
          </Routes>
        </HashRouter>
      </div>
    );
  }
}

export default App;

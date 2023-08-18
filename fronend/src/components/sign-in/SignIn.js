import React, { useState } from "react";
import axios from "axios";
import miuLogo from "./miu_logo.jpg";
import { useNavigate } from "react-router-dom";

function Login({ setUser }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleChange = (event) => {
    const { name, value } = event.target;
    if (name === "userName") {
      setUsername(value);
    } else if (name === "password") {
      setPassword(value);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post("/api/auth/authenticate", {
        username,
        password,
      });

      if (response.status === 200) {
        const { data } = response;
        setUser(data);
        localStorage.setItem("user", data.jwtToken);
        axios.defaults.headers.common["Authorization"] = `Bearer ${data.jwtToken}`;
        navigate("/show-users"); // Redirect to ShowUsers page
      }
    } catch (error) {
      console.error("Login failed!\n", error);
      // Handle login error (display error message, clear form, etc.)
    }
  };

  const onSignUpClick = () => {
    navigate('/sign-up');
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-lg-6 mb-4">
          <img
            className="img-fluid"
            src={miuLogo}
            alt="MIU Logo"
            style={{ width: "100%" }}
          />
        </div>
        <div className="col-lg-6">
          <form className="form-signin p-4 shadow" onSubmit={handleSubmit}>
            <h1 className="h3 mb-3 font-weight-normal text-center">Login</h1>
            <div className="mb-3">
              <label htmlFor="username" className="form-label">
                Username
              </label>
              <input
                type="text"
                id="username"
                name="userName"
                className="form-control"
                placeholder="Username"
                value={username}
                onChange={handleChange}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="password" className="form-label">
                Password
              </label>
              <input
                type="password"
                id="password"
                name="password"
                className="form-control"
                placeholder="Password"
                value={password}
                onChange={handleChange}
              />
            </div>
            <div className="d-grid gap-2">
              <button className="btn btn-primary" type="submit">
                Login
              </button>
              <button
                className="btn btn-secondary"
                type="button"
                onClick={onSignUpClick}
              >
                Sign up
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;

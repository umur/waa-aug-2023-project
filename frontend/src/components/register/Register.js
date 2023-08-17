import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import SignInImage from "../../assets/undraw_signin1.svg";

const Register = () => {
  const [username, setusername] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");

  const navigate = useNavigate();

  const handleLoginSuccess = (token) => {
    localStorage.setItem("authToken", token);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("/auth/register", {
        username,
        password,
        role,
      });
      handleLoginSuccess(response.data.token);
      navigate("/sign-in");
    } catch (error) {
      console.error("Registration failed! \n", error);
    }
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-lg-6 mb-4">
          <img
            className="img-fluid"
            id="signIn-Image"
            src={SignInImage}
            alt="sign-in"
          />
        </div>
        <div className="col-lg-6">
          <form className="form-signin p-4 shadow" onSubmit={handleSubmit}>
            <h1 className="h3 mb-3 font-weight-normal text-center">Register</h1>
            <div className="mb-3">
              <label htmlFor="inputusername" className="sr-only">
                Username
              </label>
              <input
                type="username"
                id="inputusername"
                className="form-control"
                placeholder="Username"
                required
                autoFocus
                value={username}
                onChange={(e) => setusername(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="inputPassword" className="sr-only">
                Password
              </label>
              <input
                type="password"
                id="inputPassword"
                className="form-control"
                placeholder="Password"
                required
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="roleInput" className="form-label">
                Role
              </label>
              <select
                className="custom-select"
                id="roleInput"
                onChange={(e) => setRole(e.target.value)}
                value={role}
              >
                <option value="select one">Select Role</option>
                <option value="STUDENT">Alumni</option>
                <option value="FACULTY">Administrator</option>
              </select>
            </div>
            <div className="checkbox mb-3">
              <label>
                <input type="checkbox" value="remember-me" /> Remember me
              </label>
            </div>
            <button
              className="btn btn-lg btn-primary btn-block"
              type="submit"
            >
              Sign up
            </button>
            <p className="mt-3 mb-0 text-center">
              &copy; Hellcat Team
            </p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;

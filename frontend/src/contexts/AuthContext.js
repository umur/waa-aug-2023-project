
import React, { createContext, useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem('accessToken') || null);
  const [role, setRole] = useState(localStorage.getItem('role') || null);
  const [userId, setUserID] = useState(localStorage.getItem('user_id') || null);
  const [profileId, setProfileId] = useState(localStorage.getItem('profile_id') || null);
  console.log("token level" + token)

  const logout = () => {
    setToken(null);
    localStorage.removeItem('accessToken');
    alert("Logout sucessfully")
    document.location.assign("/login")
  };

  return (
    <AuthContext.Provider value={{ token, role, userId, profileId, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);


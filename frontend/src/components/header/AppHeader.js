import React from 'react';
import { useTheme } from "../../contexts/ThemeContext"
import { useAuth } from "../../contexts/AuthContext"
import "../../css/header.css"

const AppHeader = () => {
    const { theme, toggleTheme } = useTheme();
    const { role, token, logout } = useAuth();
    return (
        <header className={`header ${theme}`}>
            <h1>Hello! {role}</h1>
            <h1>WAA Project - This is header</h1>
            <button onClick={toggleTheme}>Toggle Theme</button>
            {token !== null && (
                <button onClick={logout}>Logout</button>
            )}
        </header>
    )
}

export default AppHeader;
import React from 'react';
import { useTheme } from "../../contexts/ThemeContext"
import { useAuth } from "../../contexts/AuthContext"
import "../../css/header.css"

const AppHeader = () => {
    const { theme, toggleTheme } = useTheme();
    const { token, setToken } = useAuth();
    return (
        <header className={`header ${theme}`}>
            <h1>{token}</h1>
            <h1>WAA Project - This is header</h1>
            <button onClick={toggleTheme}>Toggle Theme</button>
        </header>
    )
}

export default AppHeader;
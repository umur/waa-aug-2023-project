import React from 'react';
import { useTheme } from "../../contexts/ThemeContext"
import "../../css/header.css"

const AppHeader = () => {
    const { theme, toggleTheme } = useTheme();
    return (
        <header className={`header ${theme}`}>
            <h1>WAA Project - This is header</h1>
            <button onClick={toggleTheme}>Toggle Theme</button>
        </header>
    )
}

export default AppHeader;
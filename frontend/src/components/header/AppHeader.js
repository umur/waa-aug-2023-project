import React from 'react';
import { useTheme } from "../../contexts/ThemeContext"

const AppHeader = () => {
    const { theme, toggleTheme } = useTheme();
    return (
        <header className={`header ${theme}`}>
            <h1>WAA Project</h1>
            <button onClick={toggleTheme}>Toggle Theme</button>
        </header>
    )
}
export default AppHeader;
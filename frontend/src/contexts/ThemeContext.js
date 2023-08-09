import React, { createContext, useContext, useState, useEffect } from 'react';

let color = 'light';

const ThemeContext = createContext();

const ThemeProvider = ({ children }) => {
    const [theme, setTheme] = useState(require('../css/light-theme.css'))
    const ThemeDark = () => {
        document.body.classList.remove('light-theme');
        setTheme(require(`../css/${color === 'light' ? 'dark' : 'light'}-theme.css`));
        document.body.classList.add('dark-theme');
    };

    const ThemeLight = () => {
        document.body.classList.remove('dark-theme');
        setTheme(require(`../css/${color === 'dark' ? 'light' : 'dark'}-theme.css`));
        document.body.classList.add('light-theme');
    };

    const toggleTheme = () => {
        console.log('theme change', color);
        if (color === 'light') {
            ThemeDark();
        } else {
            ThemeLight();
        }
        color = color === 'light' ? 'dark' : 'light';
    };
    return (
        <ThemeContext.Provider value={{ theme, toggleTheme }}>
            {children}
        </ThemeContext.Provider>
    )
}
export const useTheme = () => {
    return useContext(ThemeContext);
}

export default ThemeProvider;
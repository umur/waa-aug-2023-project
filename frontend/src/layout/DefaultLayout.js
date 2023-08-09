import React from 'react';
import AppHeader from '../components/header/AppHeader';
import AppSidebar from '../components/sidebar/AppSidebar';

const DefaultLayout = ({ children }) => { // Receive children as a prop
    return (
        <div className="wrapper d-flex flex-column min-vh-100 bg-light">
            <AppHeader />
            <div className="d-flex flex-row flex-grow-1">
                <AppSidebar />
                <div className="flex-grow-1">
                    {children} {/* Render the passed children (main content) */}
                </div>
            </div>
        </div>
    );
};

export default DefaultLayout;

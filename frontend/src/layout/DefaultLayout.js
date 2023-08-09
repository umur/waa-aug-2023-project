import React from 'react'
import AppHeader from '../components/header/AppHeader'

const DefaultLayout = () => {
    return (
        <div>
            <div className="wrapper d-flex flex-column min-vh-100 bg-light">
                <AppHeader />
            </div>
        </div>
    )
}
export default DefaultLayout

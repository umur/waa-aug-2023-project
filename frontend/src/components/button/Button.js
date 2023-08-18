import React from 'react';
import PropTypes from "prop-types";
import '../../css/button.css'

const Button = ({color,onClick,disabled,children}) => {
    return (
        <button
            className={`custom-button ${color}`}
            onClick={onClick}
            disabled={disabled}
        >
            {children}
        </button>
    )
}

Button.propTypes = {
    color: PropTypes.string,
    onClick: PropTypes.func,
    disabled: PropTypes.bool,
    children: PropTypes.node.isRequired,
}

export default Button;

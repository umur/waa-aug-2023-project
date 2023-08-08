import React from 'react';
import PropTypes from 'prop-types';

const Input = ({ color, type, onClick, disabled, value }) => {
  return (
    <input
      className={`custom-input ${color}`} // Adjust the class name if needed
      type={type}
      onClick={onClick}
      disabled={disabled}
      value={value}
    />
  );
};

Input.propTypes = {
  color: PropTypes.string,
  type: PropTypes.string.isRequired,
  onClick: PropTypes.func,
  disabled: PropTypes.bool,
  value: PropTypes.node,
};

export default Input;

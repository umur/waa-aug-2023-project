import React from 'react';
import PropTypes from 'prop-types';

const Input = ({ color, type, onClick, disabled, children }) => {
  return (
    <input
      className={`custom-input ${color}`} // Adjust the class name if needed
      type={type}
      onClick={onClick}
      disabled={disabled}
    />
  );
};

Input.propTypes = {
  color: PropTypes.string,
  type: PropTypes.string.isRequired, // Make the 'type' prop required
  onClick: PropTypes.func,
  disabled: PropTypes.bool,
  children: PropTypes.node, // 'children' prop should be 'node', not 'isRequired'
};

export default Input;

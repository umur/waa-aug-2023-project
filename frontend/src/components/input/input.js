import React from 'react';
import PropTypes from 'prop-types';

const Input = ({ color, type, onChange, disabled, value }) => {
  console.log(onChange)
  return (
    <input
      className={`custom-input ${color}`}
      type={type}
      onChange={onChange}
      disabled={disabled}
      value={value}
    />
  );
};

Input.propTypes = {
  color: PropTypes.string,
  type: PropTypes.string.isRequired,
  onChange: PropTypes.func,
  disabled: PropTypes.bool,
  value: PropTypes.string,
};

export default Input;

import { createSlice } from "@reduxjs/toolkit";

const initialState ={
    value : localStorage.getItem('token') ? true : false
}

export const isLoggedInSlice = createSlice({
    name: 'isLoggedIn',
    initialState,
    reducers : {
        setIsLoggedIn: (state, action) => {
            state.value = action.payload
        }
    }
});

export const selectIsLoggedIn = (state) => state.isLoggedIn.value;

export const {setIsLoggedIn} = isLoggedInSlice.actions;

export default isLoggedInSlice.reducer;
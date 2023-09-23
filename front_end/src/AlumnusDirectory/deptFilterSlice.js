import { createSlice } from "@reduxjs/toolkit";

const initialState ={
    value : ''
}

export const deptFilterSlice = createSlice({
    name: 'deptFilter',
    initialState,
    reducers : {
        setDeptFilter: (state, action) => {
            state.value = action.payload
        }
    }
});

export const selectDeptFilter = (state) => state.deptFilter.value;

export const {setDeptFilter} = deptFilterSlice.actions;

export default deptFilterSlice.reducer;
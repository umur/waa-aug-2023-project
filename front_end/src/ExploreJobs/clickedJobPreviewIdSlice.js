import { createSlice } from "@reduxjs/toolkit";

const initialState ={
    value : 1
}

export const clickedJobPreviewIdSlice = createSlice({
    name: 'jobPostPreviewId',
    initialState,
    reducers : {
        setJobPostPreviewId: (state, action) => {
            state.value = action.payload
        }
    }
});

export const selectJobPostPreviewId = (state) => state.jobPostPreviewId.value;

export const {setJobPostPreviewId} = clickedJobPreviewIdSlice.actions;

export default clickedJobPreviewIdSlice.reducer;
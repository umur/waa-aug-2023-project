import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import  jobPostPreviewIdReducer  from '../ExploreJobs/clickedJobPreviewIdSlice';
import isLoggedInReducer from '../NavBar/isLoggedInSlice';
import deptFilterReducer from '../AlumnusDirectory/deptFilterSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    jobPostPreviewId: jobPostPreviewIdReducer,
    isLoggedIn: isLoggedInReducer,
    deptFilter: deptFilterReducer,
  },
});

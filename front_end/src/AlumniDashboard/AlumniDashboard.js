import React from "react";
import WorkIcon from '@mui/icons-material/Work';
import EventIcon from '@mui/icons-material/Event';
import EmojiEmotionsIcon from '@mui/icons-material/EmojiEmotions';

import './AlumniDashboard.css'
import { useNavigate } from "react-router";

function AlumniDashboard() {
  const navigate = useNavigate();
  return (
    <div className="almuniDashboard">

      <div className="row rowFlex">

        <div onClick={()=>navigate('/jobPost')} className="cell rowFlex">
          <WorkIcon/>
          <h4>Post Job</h4>
        </div>

        <div className="cell rowFlex">
          <EventIcon/>
          <h4>Post Event</h4>
        </div>

        <div className="cell rowFlex">
          <EmojiEmotionsIcon/>
          <h4>Fill Survey</h4>
        </div>

      </div>

    </div>
  );
}

export default AlumniDashboard;

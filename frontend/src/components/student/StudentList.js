import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const StudentList = ({ students, title, handleUpdate, handleDelete }) => {
  const [downloadLinks, setDownloadLinks] = useState({});

  useEffect(() => {
    const fetchDownloadLinks = async () => {
      const links = {};
      for (const student of students) {
        try {
          if (student.cv == null) {
            links[student.id] = null;
          } else {
            let cvString = extractFileName(student.cv);
            links[student.id] = cvString;
          }
        } catch (error) {
          console.error(error);
          links[student.id] = null;
        }
      }
      setDownloadLinks(links);
    };

    fetchDownloadLinks();
  }, [students]);

  const extractFileName = (filePath) => {
    const fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
    return fileName;
  };

  const handleDownload = async (fileName) => {
    let res = await axios.get(`/downloads/${fileName}`, { responseType: "blob" }, {
      headers: {
        Authorization: `Bearer ${localStorage.getItem("authToken")}`
      }
    });
    const url = window.URL.createObjectURL(new Blob([res.data]));
    const link = document.createElement("a");
    link.href = url;
    link.setAttribute("download", fileName);
    document.body.appendChild(link);
    link.click();
  };

  return (
    <div>
      <div className="d-flex justify-content-between">
        <div>
          <h2>{title}</h2>
        </div>
        <div>
          <Link to="/create-students" className="btn btn-md btn-success">
            Add new Student
          </Link>
        </div>
      </div>

      <div className="mt-5">
        <table className="table">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">First Name</th>
              <th scope="col">Last Name</th>
              <th scope="col">Username</th>
              <th scope="col">Phone</th>
              <th scope="col">CV</th>
              <th scope="col">Employed?</th>
              <th scope="col">Update</th>
              <th scope="col">Delete</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student, index) => (
              <tr key={student.id}>
                <td>{index + 1}</td>
                <td>{student.firstName}</td>
                <td>{student.lastName}</td>
                <td>{student.username}</td>
                <td>{student.phone}</td>
                <td>
                  {downloadLinks[student.id] ? (
                    <button
                      className="btn btn-sm btn-info"
                      onClick={() => handleDownload(downloadLinks[student.id])}
                      title={`Download ${student.firstName}'s cv`}
                    >
                      Download
                    </button>
                  ) : (
                    "N/A"
                  )}
                </td>
                <td>{student.isCurrentlyEmployed ? "Yes" : "No"}</td>
                <td>
                  <button
                    className="btn btn-sm btn-primary"
                    onClick={() => handleUpdate(student.id)}
                  >
                    Update
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-sm btn-danger"
                    onClick={() => handleDelete(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

const dummyStudents = [
  {
    id: 1,
    firstName: "Diaa",
    lastName: "Nassar",
    username: "nass.diaa",
    phone: "213-997-3299",
    isCurrentlyEmployed: true,
    cv: "/path/to/john_cv.pdf", // Provide actual CV path
  },
  {
    id: 2,
    firstName: "Omar",
    lastName: "AlTamimi",
    username: "omar.altamimi",
    phone: "213-452-4014",
    isCurrentlyEmployed: true,
    cv: "/path/to/omt.pdf",
  },
  {
    id: 3,
    firstName: "Mohammed",
    lastName: "Rashaideh",
    username: "mohammed.rashaideh",
    phone: "987-654-3210",
    isCurrentlyEmployed: true,
    cv: "/path/to/moe_cv.pdf",
  },
  {
    id: 4,
    firstName: "Aiman",
    lastName: "Obeidat",
    username: "obeidat.aiman",
    phone: "789-999-999",
    isCurrentlyEmployed: false,
    cv: "/path/to/aiman_cv.pdf",
  },
  // Add more dummy students as needed
];

const App = () => {
  const [students, setStudents] = useState(dummyStudents);

  // Dummy implementations for handleUpdate and handleDelete
  const handleUpdate = (studentId) => {
    console.log(`Update student with ID ${studentId}`);
  };

  const handleDelete = (studentId) => {
    console.log(`Delete student with ID ${studentId}`);
  };

  return (
    <div>
      <StudentList
        students={students}
        title="Alumni List"
        handleUpdate={handleUpdate}
        handleDelete={handleDelete}
      />
    </div>
  );
};

export default App;

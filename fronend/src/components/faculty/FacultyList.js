import React from "react";
import { Link } from "react-router-dom";

const FacultyList = ({ faculties, title, handleUpdate, handleDelete }) => {
  // Dummy data for faculties
  const dummyFaculties = [
    {
      id: 1,
      firstName: "John",
      lastName: "Doe",
      username: "john.doe",
      phone: "123-456-7890",
      title: "Professor",
    },
    {
      id: 2,
      firstName: "Jane",
      lastName: "Smith",
      username: "jane.smith",
      phone: "987-654-3210",
      title: "Associate Professor",
    },
    // Add more dummy faculties as needed
  ];

  return (
    <>
      <div>
        <div className="d-flex justify-content-between">
          <div>
            <h2>{title}</h2>
          </div>
          <div>
            <Link to="/create-faculties" className="btn btn-md btn-success">
              Add new Faculty
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
                <th scope="col">Title</th>
                <th scope="col">Update</th>
                <th scope="col">Delete</th>
              </tr>
            </thead>
            <tbody>
              {dummyFaculties.map((faculty, index) => (
                <tr key={faculty.id}>
                  <td>{index + 1}</td>
                  <td>{faculty.firstName}</td>
                  <td>{faculty.lastName}</td>
                  <td>{faculty.username}</td>
                  <td>{faculty.phone}</td>
                  <td>{faculty.title}</td>
                  <td>
                    <button
                      className="btn btn-sm btn-primary"
                      onClick={() => handleUpdate(faculty.id)}
                    >
                      Update
                    </button>
                  </td>
                  <td>
                    <button
                      className="btn btn-sm btn-danger"
                      onClick={() => handleDelete(faculty.id)}
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
    </>
  );
};

export default FacultyList;

import React, { useEffect, useState } from "react";
import axios from "axios";
import User from "./User";
import Template from "./Template";

export default function ShowUsers(props) {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const getUsers = async () => {
      try {
        const response = await axios.get("/alumni");
        setUsers(response.data);
      } catch (error) {
        console.log(error);
      }
    };

    getUsers();
  }, []);

  return (
    <Template {...props}>
      <table>
        <thead>
          <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Username</th>
            <th>Role</th>
            <th>Active</th>
            <th>Get Info</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <User
              key={user.id}
              id={user.id}
              name={user.name}
              username={user.username}
              role={user.role}
              active={user.active + ""}
            />
          ))}
        </tbody>
      </table>
    </Template>
  );
}

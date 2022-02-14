import React, { Component } from "react";
import axios from "axios";
import api from "../../../common/api";

import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import CreateUserModal from "./CreateUserModal/createUser";

class UsersContainer extends Component {
  state = {
    users: [],
    create: false,
  };
  toggleCreate = () => {
    this.setState({ create: !this.state.create });
  };
  getUsers = async () => {
    const url = api.baseURL + "/admin/users";
    const token = localStorage.getItem("evtoken");
    await axios
      .get(url, { headers: { Authorization: `Bearer ${token}` } })
      .then((res) => {
        console.log(res.data);
        if (res.status === 200) {
          this.setState({ users: res.data });
        }
      })
      .catch((err) => console.log(err));
  };
  componentDidMount() {
    this.getUsers();
  }
  render() {
    return (
      <div
        className="bg-light px-5 py-3"
        style={{
          minHeight: "90vh",
        }}
      >
        <div
          className="d-flex justify-content-between align-items-center my-4 py-2 px-4 border bg-white"
          style={{
            borderRadius: "12px",
          }}
        >
          <div>
            <h1>Users</h1>
          </div>
          <div>
            <div className="d-flex">
              <button className="btn btn-primary" onClick={this.toggleCreate}>
                Create User
              </button>
            </div>
          </div>
        </div>

        <div className="my-5 px-4">
          <div>
            <TableContainer component={Paper}>
              <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell align="center">Sl No.</TableCell>
                    <TableCell align="center">Username</TableCell>
                    <TableCell align="center">Email(g)</TableCell>
                    <TableCell align="center">Mobile Number</TableCell>
                    <TableCell align="center">Role</TableCell>
                    <TableCell align="center">Active</TableCell>
                    <TableCell align="center">Date of Joining</TableCell>
                    <TableCell align="center">Actions</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {this.state.users.map((user, index) => (
                    <TableRow
                      key={user.email}
                      sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                    >
                      <TableCell align="center" component="th" scope="row">
                        {index + 1}
                      </TableCell>
                      <TableCell align="center">{user.username}</TableCell>
                      <TableCell align="center">{user.email}</TableCell>
                      <TableCell align="center">{user.mobileNumber}</TableCell>
                      <TableCell align="center">{user.role}</TableCell>
                      <TableCell align="center">
                        {user.active ? "YES" : "NO"}
                      </TableCell>
                      <TableCell align="center">{user.doj}</TableCell>
                      <TableCell align="center">
                        <div className="d-flex justify-content-around align-items-center">
                          <i className="fas fa-edit text-primary cursor-pointer"></i>
                          <i className="fas fa-trash text-danger cursor-pointer"></i>
                        </div>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </div>
        </div>
        <CreateUserModal
          show={this.state.create}
          toggle={this.toggleCreate}
          getUsers={this.getUsers}
        />
      </div>
    );
  }
}

export default UsersContainer;

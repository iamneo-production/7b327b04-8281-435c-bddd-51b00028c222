import React, { Component } from "react";
import { Modal, ModalHeader, ModalBody } from "reactstrap";
import Select from "@mui/material/Select";
import TextField from "@mui/material/TextField";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import axios from "axios";
import api from "../../../../common/api";

class EditUserModal extends Component {
  state = {
    username: this.props.data.username,
    email: this.props.data.email,
    password: this.props.data.password,
    mobileNumber: this.props.data.mobileNumber,
    role: this.props.data.role,
  };
  updateUser = async () => {
    const url = api.baseURL + "/admin/user/" + this.props.data.id + "/edit";
    const token = localStorage.getItem("evtoken");
    // const formData = new FormData();
    // formData.append("email", this.state.email);
    // formData.append("password", this.state.password);
    // formData.append("userRole", this.state.role);
    // formData.append("mobileNumber", this.state.mobileNumber);
    // formData.append("username", this.state.username);
    const body = {
      email: this.state.email,
      username: this.state.username,
      password: this.state.password,
      userRole: this.state.userRole,
      mobileNumber: this.state.mobileNumber,
    };
    await axios
      .put(url, body, { headers: { Authorization: `Bearer ${token}` } })
      .then((res) => {
        console.log(res.data);
        if (res.status < 210) {
          this.props.getUsers();
          this.props.toggle();
        }
      })
      .catch((err) => console.log(err));
  };
  render() {
    const { show, toggle } = this.props;
    return (
      <Modal size="lg" isOpen={show} toggle={toggle}>
        <ModalHeader toggle={toggle}>Create User</ModalHeader>
        <ModalBody>
          <div className="d-flex flex-column">
            <div className="my-2">
              <TextField
                label="Username*"
                className="w-100"
                variant="outlined"
                value={this.state.username}
                onChange={(e) => this.setState({ username: e.target.value })}
              />
            </div>
            <div className="my-2">
              <TextField
                label="Email*"
                className="w-100"
                variant="outlined"
                value={this.state.email}
                onChange={(e) => this.setState({ email: e.target.value })}
              />
            </div>
            <div className="my-2">
              <TextField
                label="Password*"
                className="w-100"
                type="password"
                variant="outlined"
                value={this.state.password}
                onChange={(e) => this.setState({ password: e.target.value })}
              />
            </div>
            <div className="my-2">
              <TextField
                label="Mobile Number*"
                className="w-100"
                variant="outlined"
                value={this.state.mobileNumber}
                onChange={(e) =>
                  this.setState({ mobileNumber: e.target.value })
                }
              />
            </div>
            {/* <div className="my-2">
              <FormControl fullWidth>
                <InputLabel id="role-select-label">Role</InputLabel>
                <Select
                  labelId="role-select-label"
                  id="role-select"
                  value={this.state.role}
                  label="Role"
                  onChange={(e) => this.setState({ role: e.target.value })}
                >
                  <MenuItem value="ADMIN">Admin</MenuItem>
                  <MenuItem value="CUSTOMER">Customer</MenuItem>
                </Select>
              </FormControl>
            </div> */}

            <div className="my-3">
              <div className="d-flex justify-content-center align-items-center">
                <button
                  className="btn btn-primary mx-1"
                  disabled={
                    this.state.username === "" ||
                    this.state.email === "" ||
                    this.state.password === "" ||
                    this.state.mobileNumber === ""
                  }
                  onClick={this.updateUser}
                >
                  Update
                </button>
                <button className="btn btn-danger mx-1" onClick={toggle}>
                  Cancel
                </button>
              </div>
            </div>
          </div>
        </ModalBody>
      </Modal>
    );
  }
}

export default EditUserModal;

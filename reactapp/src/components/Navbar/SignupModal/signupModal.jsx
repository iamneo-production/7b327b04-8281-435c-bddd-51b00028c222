import React, { useState } from "react";
import Backdrop from "@mui/material/Backdrop";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import Fade from "@mui/material/Fade";
import TextField from "@mui/material/TextField";
import api from "../../../common/api";
import axios from "axios";
import actionTypes from "../../../store/actions/actionTypes";
import { connect } from "react-redux";
import { toast } from "react-toastify";

const modalStyle = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "50vw",
  bgcolor: "white",
  border: "2px solid #fff",
  borderRadius: 10,
  boxShadow: 24,
  p: 4,
};

const TransitionsModal = ({ show, toggle, setUser }) => {
  const [username, setusername] = useState("");
  const [email, setemail] = useState("");
  const [password, setpassword] = useState("");
  const [activeTab, setactiveTab] = useState(0);

  const resetFields = () => {
    setusername("");
    setemail("");
    setpassword("");
    setactiveTab(0);
  };
  const userCreate = async () => {
    const url = api.baseURL + "/users/create";
    const body = {
      username,
      email,
      password,
    };
    await axios
      .post(url, body)
      .then((res) => {
        console.log(res.data);
        if (res.data.success) {
          localStorage.setItem("user", JSON.stringify(res.data.data));
          setUser(res.data.data);
          resetFields();
          toggle();
        } else {
          toast.warning(res.data.message);
        }
      })
      .catch((err) => console.log(err));
  };
  const userLogin = async () => {
    const url = api.baseURL + "/users/login";
    const body = {
      email,
      password,
    };
    await axios
      .post(url, body)
      .then((res) => {
        console.log(res.data);
        if (res.data.success) {
          localStorage.setItem("user", JSON.stringify(res.data.data));
          setUser(res.data.data);
          resetFields();
          toggle();
        }
      })
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <Modal
        aria-labelledby="transition-modal-title"
        aria-describedby="transition-modal-description"
        open={show}
        onClose={() => {
          resetFields();
          toggle();
        }}
        closeAfterTransition
        BackdropComponent={Backdrop}
        BackdropProps={{
          timeout: 500,
        }}
      >
        <Fade in={show}>
          <Box sx={modalStyle}>
            <div className="p-3">
              <div className="d-flex flex-column">
                <div className="d-flex flex-row mb-2">
                  <p
                    className="fs-20 text-white w-50 py-3 text-center rounded-left"
                    style={{
                      backgroundColor: activeTab === 0 ? "#1ab188" : "#435259",
                      cursor: "pointer",
                    }}
                    onClick={resetFields}
                  >
                    Sign Up
                  </p>
                  <p
                    className="fs-20 text-white w-50 py-3 text-center rounded-right"
                    style={{
                      backgroundColor: activeTab === 1 ? "#1ab188" : "#435259",
                      cursor: "pointer",
                    }}
                    onClick={() => {
                      resetFields();
                      setactiveTab(1);
                    }}
                  >
                    Log In
                  </p>
                </div>
              </div>
              <div className="my-2">
                <h1 className="text-center">
                  {activeTab === 0 ? "Sign Up for Free" : "Welcome Back"}
                </h1>
              </div>
              {activeTab === 0 ? (
                <div className="d-flex flex-column">
                  <div className="my-2">
                    <TextField
                      label="Username*"
                      className="w-100"
                      variant="outlined"
                      value={username}
                      onChange={(e) => setusername(e.target.value)}
                    />
                  </div>
                  <div className="my-2">
                    <TextField
                      label="Email*"
                      className="w-100"
                      variant="outlined"
                      value={email}
                      onChange={(e) => setemail(e.target.value)}
                    />
                  </div>
                  <div className="my-2">
                    <TextField
                      label="Password*"
                      className="w-100"
                      type="password"
                      variant="outlined"
                      value={password}
                      onChange={(e) => setpassword(e.target.value)}
                    />
                  </div>
                  <div className="mt-4 mb-2 d-flex flex-row justify-content-center">
                    <button
                      className="btn w-100 text-white"
                      onClick={userCreate}
                      style={{
                        backgroundColor: "#1ab188",
                      }}
                      disabled={
                        username === "" || email === "" || password === ""
                      }
                    >
                      <p className="fs-24 mb-0">GET STARTED</p>
                    </button>
                  </div>
                </div>
              ) : (
                <div className="d-flex flex-column">
                  <div className="my-2">
                    <TextField
                      label="Email*"
                      className="w-100"
                      variant="outlined"
                      value={email}
                      onChange={(e) => setemail(e.target.value)}
                    />
                  </div>
                  <div className="my-2">
                    <TextField
                      label="Password*"
                      className="w-100"
                      type="password"
                      variant="outlined"
                      value={password}
                      onChange={(e) => setpassword(e.target.value)}
                    />
                  </div>
                  <div className="mt-4 mb-2 d-flex flex-row justify-content-center">
                    <button
                      className="btn w-100 text-white"
                      onClick={userLogin}
                      style={{
                        backgroundColor: "#1ab188",
                      }}
                      disabled={email === "" || password === ""}
                    >
                      <p className="fs-24 mb-0">LOG IN</p>
                    </button>
                  </div>
                </div>
              )}
            </div>
          </Box>
        </Fade>
      </Modal>
    </div>
  );
};

const mapDispatchtoProps = (dispatch) => {
  return {
    setUser: (data) => dispatch({ type: actionTypes.SET_USER, data: data }),
  };
};

export default connect(null, mapDispatchtoProps)(TransitionsModal);

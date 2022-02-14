import axios from "axios";
import * as actionTypes from "./actionTypes";
import api from "../../common/api";

export const signup = (data) => {
  return (dispatch) => {
    const url = api.baseURL + "/user/signup";
    const body = data;
    axios
      .post(url, body)
      .then((res) => {
        console.log("Signup", res.data);
        if (res.status === 201) {
          dispatch({ type: actionTypes.SET_USER, data: res.data });
        }
      })
      .catch((err) => console.log(err));
  };
};

export const login = (data) => {
  return (dispatch) => {
    const url = api.baseURL + "/user/login";
    const formData = new FormData();
    formData.append("email", data.email);
    formData.append("password", data.password);
    axios
      .post(url, formData)
      .then((res) => {
        console.log("Login", res.data);
        dispatch({ type: actionTypes.SET_USER, data: {} });
        localStorage.setItem("evtoken", res.data.access_token);
        localStorage.setItem("role", res.data.role);
      })
      .catch((err) => console.log(err));
  };
};

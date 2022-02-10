import React, { useEffect } from "react";
import "./App.css";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Header from "./components/Navbar/navbar";
import "bootstrap/dist/css/bootstrap.css";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import HomePage from "./components/HomePage/homePage";
import { connect } from "react-redux";
import actionTypes from "./store/actions/actionTypes";

function App() {
  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("user"));
    if (user) {
      //props.setUser(user);
    } else {
      //window.location.href = "/";
    }
  }, []);
  return (
    <div className="App">
      <BrowserRouter>
        <div className="App">
          <Header />
          <Switch>
            <Route path="/" component={HomePage} />
          </Switch>
        </div>
      </BrowserRouter>
      <ToastContainer />
    </div>
  );
}

export default App;

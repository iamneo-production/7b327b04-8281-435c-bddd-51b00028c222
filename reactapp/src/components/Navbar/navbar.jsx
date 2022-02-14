import React, { useState } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
} from "reactstrap";
import { Link } from "react-router-dom";
import { withRouter } from "react-router";
import SignupModal from "./SignupModal/signupModal";
import { connect } from "react-redux";
import * as actionTypes from "../../store/actions/actionTypes";

const Header = ({ location, auth, user, logout }) => {
  const [isOpen, setisOpen] = useState(false);
  const [signupModal, setsignupModal] = useState(false);
  const toggle = () => {
    setisOpen((isOpen) => !isOpen);
  };
  const onLogout = () => {
    localStorage.removeItem("user");
    logout();
  };
  return (
    <div id="masthead" class="header ttm-header-style-classic-overlay">
      <div class="ttm-header-wrap">
        <div
          id="ttm-stickable-header-w"
          class="ttm-stickable-header-w clearfix"
        >
          <div id="site-header-menu" class="site-header-menu">
            <div class="site-header-menu-inner ttm-stickable-header">
              <div class="container">
                <div class="site-branding">
                  <Link class="home-link" rel="home" to="/home">
                    <h2 style={{ color: "white" }} id="io">
                      {" "}
                      Wedding Planners
                    </h2>
                  </Link>
                </div>

                <div class="ttm-header-icons">
                  <span class="ttm-header-icon ttm-header-cart-link">
                    <Link to="/">
                      <i class="fa fa-shopping-cart"></i>
                      <span class="number-cart">0</span>
                    </Link>
                  </span>
                  <div class="ttm-header-icon ttm-header-search-link">
                    <Link to="/" class="open">
                      <i class="ti ti-search"></i>
                    </Link>
                    <div class="ttm-search-overlay">
                      <div class="container">
                        <div class="row">
                          <form
                            method="get"
                            class="ttm-site-searchform"
                            action="#"
                          >
                            <div class="w-search-form-h">
                              <div class="w-search-form-row">
                                <div class="w-search-input">
                                  <input
                                    type="search"
                                    class="field searchform-s"
                                    name="s"
                                    placeholder="Type Word Then Enter..."
                                  />
                                  <button type="submit">
                                    <i class="ti ti-search"></i>
                                  </button>
                                </div>
                              </div>
                            </div>
                          </form>
                          <div class="ttm-search-close">
                            <i class="fa fa-close"></i>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div id="site-navigation" class="site-navigation">
                  <div class="ttm-menu-toggle">
                    <input type="checkbox" id="menu-toggle-form" />
                    <label for="menu-toggle-form" class="ttm-menu-toggle-block">
                      <span class="toggle-block toggle-blocks-1"></span>
                      <span class="toggle-block toggle-blocks-2"></span>
                      <span class="toggle-block toggle-blocks-3"></span>
                    </label>
                  </div>
                  <nav id="menu" class="menu">
                    <ul class="dropdown">
                      <li class="active">
                        <Link to="/home">Home</Link>
                      </li>
                      <li>
                        <a href="#">About Us</a>
                      </li>
                      <li>
                        <a href="#">Services</a>
                      </li>
                      <li>
                        <a href="#">Pricing</a>
                      </li>
                      <li>
                        <button
                          className="btn btn-danger"
                          onClick={() => setsignupModal(true)}
                        >
                          Login
                        </button>
                      </li>
                    </ul>
                  </nav>
                </div>
              </div>
            </div>
          </div>
        </div>
        <SignupModal
          show={signupModal}
          toggle={() => setsignupModal(!signupModal)}
        />
      </div>
    </div>
  );
};

const mapStatetoProps = (state) => {
  return {
    user: state.user.user,
    auth: state.user.auth,
  };
};

const mapDispatchtoProps = (dispatch) => {
  return {
    logout: () => dispatch({ type: actionTypes.LOGOUT }),
  };
};

export default connect(mapStatetoProps, mapDispatchtoProps)(withRouter(Header));

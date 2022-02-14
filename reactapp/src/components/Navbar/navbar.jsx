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
    localStorage.removeItem("evtoken");
    localStorage.removeItem("role");
    logout();
  };
  return (
    <div>
      <Navbar
        dark
        expand="md"
        style={{
          backgroundColor: "rgb(0,0,0)",
        }}
      >
        <div className="container">
          <NavbarBrand href="/">
            <div className="d-flex flex-row justify-content-between align-items-center">
              <h1 className="mb-0 text-white">EMS</h1>
            </div>
          </NavbarBrand>
          <NavbarToggler onClick={toggle} />
          <Collapse isOpen={isOpen} navbar>
            <Nav className="ml-auto d-flex align-items-center" navbar>
              <NavItem>
                <NavLink>
                  <Link
                    to="/"
                    style={{
                      textDecoration: "none",
                      color: "inherit",
                    }}
                  >
                    <span
                      className="text-white"
                      style={
                        location.pathname === "/"
                          ? {
                              borderBottom: "2px solid yellow",
                            }
                          : {}
                      }
                    >
                      Home
                    </span>
                  </Link>
                </NavLink>
              </NavItem>

              <NavItem>
                <NavLink>
                  <Link
                    to="/admin/users"
                    style={{
                      textDecoration: "none",
                      color: "inherit",
                    }}
                  >
                    <span
                      className="text-white"
                      style={
                        location.pathname === "/admin/users"
                          ? {
                              borderBottom: "2px solid yellow",
                            }
                          : {}
                      }
                    >
                      Users
                    </span>
                  </Link>
                </NavLink>
              </NavItem>

              {!auth ? (
                <NavItem>
                  <NavLink>
                    <button
                      className="btn btn-warning"
                      onClick={() => setsignupModal(true)}
                    >
                      Sign Up
                    </button>
                  </NavLink>
                </NavItem>
              ) : (
                <UncontrolledDropdown nav inNavbar>
                  <DropdownToggle nav>
                    <i className="far text-white fa-2x fa-user-circle"></i>
                  </DropdownToggle>
                  <DropdownMenu right>
                    <Link
                      to="/profile"
                      style={{
                        textDecoration: "none",
                      }}
                    >
                      <DropdownItem>Profile</DropdownItem>
                    </Link>
                    <DropdownItem onClick={onLogout}>Logout</DropdownItem>
                  </DropdownMenu>
                </UncontrolledDropdown>
              )}
            </Nav>
          </Collapse>
        </div>
      </Navbar>
      <SignupModal
        show={signupModal}
        toggle={() => setsignupModal(!signupModal)}
      />
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

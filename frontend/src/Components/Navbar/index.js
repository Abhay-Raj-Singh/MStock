import React from "react";
import { Nav, NavLink, Heading, NavMenu } from "./NavbarElements";

const Navbar = () => {
  const handleLogout = () => {
    localStorage.clear();
    // window.location.reload(false);
  };

  const loggedInUser = localStorage.getItem("user");

  if (loggedInUser) {
    return (
      <>
        <Nav>
          <NavMenu>
            <Heading activestyle="true">mStock</Heading>

            <NavLink to="/companies" activestyle="true">
              Companies
            </NavLink>
            <NavLink to="/watchlist" activestyle="true">
              Watch List
            </NavLink>
            <NavLink to="/comparePerformance" activestyle="true">
              Compare Performance
            </NavLink>
            <NavLink
              to="/Login"
              onClick={handleLogout}
              exact={true}
              activestyle="true"
            >
              Logout
            </NavLink>
          </NavMenu>
        </Nav>
      </>
    );
  } else {
    return (
      <>
        <Nav>
          <NavMenu>
            <Heading activestyle="true">mStock</Heading>

            <NavLink to="/Login">Login</NavLink>
            <NavLink to="/companies" activestyle="true">
              Companies
            </NavLink>
          </NavMenu>
        </Nav>
      </>
    );
  }
};

export default Navbar;

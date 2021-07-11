import React from "react";
import "./App.css";
import Navbar from "./Components/Navbar";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from "./pages/Login";
import Watchlist from "./pages/Watchlist";
import Companies from "./pages/Companies";
import ComparePerformance from "./pages/ComparePerformance";

function App() {
  return (
    <Router forceRefresh>
      <Navbar />
      <Switch>
        <Route path="/Login" exact component={Login} />
        <Route path="/Logout" component={Login} />
        <Route path="/Watchlist" component={Watchlist} />
        <Route path="/Companies" component={Companies} />
        <Route path="/ComparePerformance" component={ComparePerformance} />
      </Switch>
    </Router>
  );
}

export default App;

import React, { useState, useEffect } from "react";
import axios from "axios";
import "../Login.css";
import { useHistory } from "react-router-dom";
const Login = () => {
  const [user_email, setUsername] = useState("");
  const [user_pwd, setPassword] = useState("");
  const [user, setUser] = useState();

  useEffect(() => {
    const loggedInUser = localStorage.getItem("user");
    if (loggedInUser) {
      const foundUser = JSON.parse(loggedInUser);
      setUser(foundUser);
    }
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const user = { user_email, user_pwd };
    // send the username and password to the server
    const response = await axios.post(
      "http://localhost:8989/api/stock/login",
      user
    );
    // set the state of the user
    setUser(response.data);
    // store the user in localStorage
    localStorage.setItem("user", response.data.user_id);
    console.log(response.data);
    window.location.reload(false);
  };

  // if there's a user show the message below
  const history = useHistory();
  if (user) {
    history.push("/Watchlist");
  }
  // if there's no user, show the login form
  return (
    <div className="login-wrapper">
      <form onSubmit={handleSubmit}>
        <label htmlFor="username">Username: </label>
        <input
          type="text"
          value={user_email}
          placeholder="enter a username"
          onChange={({ target }) => setUsername(target.value)}
        />
        <div>
          <label htmlFor="password">password: </label>
          <input
            type="password"
            value={user_pwd}
            placeholder="enter a password"
            onChange={({ target }) => setPassword(target.value)}
          />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};
export default Login;

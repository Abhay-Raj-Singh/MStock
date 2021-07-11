import React, { useState, useEffect } from "react";
import axios from "axios";
import { Card, CardDeck } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";

const Watchlist = () => {
  const [watchlist, setWatchlist] = useState([]);

  const loadWatchlist = () => {
    axios
      .get(
        "http://localhost:8989/api/stock/watchlist/displayAll/" +
          parseInt(localStorage.getItem("user"))
      )
      .then((response) => {
        console.log(response.data);
        setWatchlist(response.data);
      })
      .catch((error) => {
        // setError(error.response.data);
        console.log(error);
      });
  };

  function removeFromWatchlist(company_id) {
    let loggedInUser = parseInt(localStorage.getItem("user"));

    axios
      .delete(
        "http://localhost:8989/api/stock/watchlist/deleteCompany/" +
          loggedInUser +
          "/" +
          company_id
      )
      .then(console.log("Removed From Watchlist"));
    window.location.reload(false);
  }

  // other wise it will load infinite times
  useEffect(() => {
    loadWatchlist();
  }, []);

  return (
    <div>
      <h1>Watchlist</h1>
      <div className="d-flex flex-row flex-nowrap">
        {watchlist.map((company) => {
          return (
            <CardDeck>
              <Card border="dark" style={{ margin: "1.8rem", width: "18rem" }}>
                <Card.Body>
                  <Card.Title>{company.company_name}</Card.Title>
                  <Card.Text>{company.company_des}</Card.Text>
                  <Card.Text>Year 2019: ${company.avg_price_2019}</Card.Text>
                  <Card.Text>Year 2020: ${company.avg_price_2020}</Card.Text>
                  <Card.Text>Year 2021: ${company.avg_price_2021}</Card.Text>

                  {localStorage.getItem("user") !== null ? (
                    <button
                      onClick={() => removeFromWatchlist(company.company_id)}
                    >
                      Delete
                    </button>
                  ) : (
                    <Card.Link href="#"></Card.Link>
                  )}
                </Card.Body>
              </Card>
            </CardDeck>
          );
        })}
      </div>
    </div>
  );
};

export default Watchlist;

import React, { useState, useEffect } from "react";
import axios from "axios";
import { Card, CardDeck } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.css";

const Companies = () => {
  const [companies, setCompanies] = useState([]);

  const loadCompanies = () => {
    axios
      .get("http://localhost:8989/api/stock/companystocks")
      .then((response) => {
        console.log(response.data);
        setCompanies(response.data);
      })
      .catch((error) => {
        // setError(error.response.data);
        console.log(error);
      });
  };

  function addToWatchlist(company_id) {
    const loggedInUser = parseInt(localStorage.getItem("user"));

    let item = {
      company_id: company_id,
    };
    axios
      .post(
        "http://localhost:8989/api/stock/watchlist/addCompany/" + loggedInUser,
        item
      )
      .then
      //window.alert("Added to watchlist")
      ()
      .catch((error) => {
        // setError(error.response.data);
        window.alert("Already present in watchlist");
      });
  }

  // other wise it will load infinite times
  useEffect(() => {
    loadCompanies();
  }, []);

  return (
    <div>
      <h1>Companies</h1>
      <div className="d-flex flex-row flex-nowrap">
        {companies.map((company) => {
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
                    <button onClick={() => addToWatchlist(company.company_id)}>
                      Add to Watchlist
                    </button>
                  ) : (
                    ""
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

export default Companies;

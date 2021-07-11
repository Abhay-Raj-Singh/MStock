import React, { useState, useEffect } from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.css";

const ComparePerformance = () => {
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

  const [company1, setCompany1] = useState("");
  const [company2, setCompany2] = useState("");
  const [compare, setCompare] = useState([]);

  const loadCompare = (e) => {
    console.log(e);
    if (company1 !== 0 && company2 !== 0) {
      axios
        .get(
          "http://localhost:8989/api/stock/comparison/" +
            company1 +
            "/" +
            company2
        )
        .then((response) => {
          console.log(response.data);
          setCompare(response.data);
        })
        .catch((error) => {
          // setError(error.response.data);
          console.log(error);
        });
    }
  };

  useEffect(() => {
    loadCompanies();
  }, []); //  it indicates the function will only run once when the component will load initially

  const renderTable = () => {
    return compare.map((company) => {
      return (
        <tr>
          {<th scope="row">{company.company_name}</th>}
          <td>{company.avg_price_2019}</td>
          <td>{company.avg_price_2020}</td>
          <td>{company.avg_price_2021}</td>
        </tr>
      );
    });
  };

  return (
    <div className=" container">
      <h1 className="mt-5">Compare Potential Companies</h1>
      <h3 className="text-muted mt-3">Make smart investment decision</h3>

      <div className="row mt-4">
        <div className="col-sm-6">
          <div className=" mb-3">
            <label>Select Company 1</label>
            <select
              className="custom-select"
              onChange={({ target }) => setCompany1(target.value)}
              name="company1"
            >
              {<option selected>Choose...</option>}
              {companies.map((company) => (
                <option value={company.company_name}>
                  {company.company_name}{" "}
                </option>
              ))}
            </select>
          </div>
        </div>

        <div className="col-sm-6">
          <div className="mb-3">
            <label>Select Company 2</label>
            <select
              className="custom-select"
              onChange={({ target }) => setCompany2(target.value)}
              name="company2"
            >
              {<option selected>Choose...</option>}
              {companies.map((company) => (
                <option value={company.company_name}>
                  {company.company_name}{" "}
                </option>
              ))}
            </select>
          </div>
        </div>
      </div>
      <div className="row mt-4">
        <div className="col-sm-6 mt-4 mb-4">
          <button
            className="btn btn-primary"
            onClick={(e) => loadCompare()}
            type="button"
          >
            Fetch
          </button>
        </div>
      </div>

      <table className="table">
        <thead>
          <tr>
            <th scope="col">Company</th>
            <th scope="col">Stock Price 2019</th>
            <th scope="col">Stock Price 2020</th>
            <th scope="col">Stock Price 2021</th>
          </tr>
        </thead>
        <tbody>{compare != null ? renderTable() : ""}</tbody>
      </table>
    </div>
  );
};

export default ComparePerformance;

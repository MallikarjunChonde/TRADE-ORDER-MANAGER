import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Addtrade() {
  let navigate = useNavigate();

  const [trade, setTrade] = useState({
    tradeDateTime: "",
    stockName: "",
    listingPrice: "",
    quantity: "",
    type: "",
    pricePerUnit: "",
  });

  const {
    tradeDateTime,
    stockName,
    listingPrice,
    quantity,
    type,
    pricePerUnit,
  } = trade;

  const onInputChange = (e) => {
    const name = e.target.name;
    const data = e.target.value;
    name === "stockName"
      ? setTrade({ ...trade, stockName: data })
      : name === "listingPrice"
      ? setTrade({ ...trade, listingPrice: data })
      : name === "quantity"
      ? setTrade({ ...trade, quantity: data })
      : name === "type"
      ? setTrade({ ...trade, type: data })
      : name === "tradeDateTime"
      ? setTrade({ ...trade, tradeDateTime: data })
      : name === "pricePerUnit" 
      && setTrade({ ...trade, pricePerUnit: data });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    const response = await axios.post("http://localhost:8080/trade-details/save", trade, {
      headers:{
        "Content-Type":"application/json"
      }
    });
    if(response.status === 200) {
      console.log(response.data.data)
      navigate("/")
     }
     else console.log("error")
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register trade</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="TradeDateTime" className="form-label">
                TradeDateTime
              </label>
              <input
                type={"datetime-local"}
                className="form-control"
                placeholder="Enter your TradeDateTime"
                name="tradeDateTime"
                value={tradeDateTime}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="StockName" className="form-label">
                Stock Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your StockName"
                name="stockName"
                value={stockName}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="ListingPrice" className="form-label">
                Listing Price
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter trade listing price"
                name="listingPrice"
                value={listingPrice}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Quantity" className="form-label">
                Quantity
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter your Quantity"
                name="quantity"
                value={quantity}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Type" className="form-label">
                Type(buy/sell)
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter buy/sell"
                name="type"
                value={type}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="PricePerUnit" className="form-label">
                Price Per Unit
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your Price Per Unit"
                name="pricePerUnit"
                value={pricePerUnit}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
  5;
}

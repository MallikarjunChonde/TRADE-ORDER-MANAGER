
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function Edittrade() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [trade, setTrade] = useState({
    tradeDateTime: "",
    stockName: "",
    listingPrice: "",
    quantity: "",
    type: "",
    pricePerUnit: "",
  });

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

  useEffect(() => {
    loadtrade();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    const response = await axios.post("http://localhost:8080/trade-details/update", trade, {
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

  const loadtrade = async () => {
    const response = await axios.get(`http://localhost:8080/trade-details/${id}`);
    setTrade(response.data.data);
  };

  const {
    tradeDateTime,
    stockName,
    listingPrice,
    quantity,
    type,
    pricePerUnit,
  } = trade;

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Update trade</h2>

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
                value={new Date(tradeDateTime)}
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
              UPDATE
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}

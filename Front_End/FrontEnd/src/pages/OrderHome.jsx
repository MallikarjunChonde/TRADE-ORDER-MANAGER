import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function OrderHome() {
  const [orders, setOrders] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadtrades();
  }, []);

  const loadtrades = async () => {
    const response = await axios.get("http://localhost:8080/order-master/fetchAll",{
      headers: {
        "Content-Type": "application/json"
      }
    });
    console.log(response.data.data)
    setOrders(response.data.data);
  };

  return (
    <div className="container">
      <div className="py-2">
        <table className="table border shadow">
          <thead>
          <tr>
                  <th scope='col'>Traid_id</th>
                  <th scope='col'>Traid_Date_Time</th>
                  <th scope='col'>StockName</th>
                  <th scope='col'>ListingPrice</th>
                  <th scope='col'>Quantity</th>
                  <th scope='col'>Type(buy/sell)</th>                  
                  <th scope='col'>price_per_unit</th>
                  <th scope='col'>OrderStatus</th>
                </tr>
          </thead>
          <tbody>
            {orders.map((order, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{order.tradeDetails.tradeDateTime}</td>
                <td>{order.tradeDetails.stockName}</td>
                <td>{order.tradeDetails.listingPrice}</td>
                <td>{order.tradeDetails.quantity}</td>
                <td>{order.tradeDetails.type}</td>
                <td>{order.tradeDetails.pricePerUnit}</td>
                <td>{order.orderStatus}</td>
                <td></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
    
  );
}
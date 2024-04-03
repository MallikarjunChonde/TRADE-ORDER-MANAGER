import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [trades, settrades] = useState([]);

  const { id } = useParams();

  useEffect(() => {
    loadtrades();
  }, []);

  const loadtrades = async () => {
    const response = await axios.get("http://localhost:8080/trade-details/fetchAll",{
      headers: {
        "Content-Type": "application/json"
      }
    });
    settrades(response.data.data);
  };

  const deletetrade = async (id) => {
    await axios.delete(`http://localhost:8080/trade-details/delete/${id}`);
    loadtrades();
  };

  const handleCreateOrder = async (id) => {
    try{
      const response = await axios.post(`http://localhost:8080/trade-details/${id}/order-masters`, {}, {
      headers:{
        "Content-Type": "application/json"
      }
    })

    if(response.status === 200){
      console.log(response.data.data)
    }else{
      console.log(response)
    }
    }catch(error){
      console.log(error)
    }
  }

  return (
    <div className="container">
      <div className="py-4">
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
                  <th scope='col'>Actions</th>
                </tr>
          </thead>
          <tbody>
            {trades.map((trade, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{trade.tradeDateTime}</td>
                <td>{trade.stockName}</td>
                <td>{trade.listingPrice}</td>
                <td>{trade.quantity}</td>
                <td>{trade.type}</td>
                <td>{trade.pricePerUnit}</td>
                <td>
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/edittrade/${trade.id}`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => deletetrade(trade.id)}
                  >
                    Delete
                  </button>
                  <button
                    className="btn btn-danger mx-2"
                    onClick={() => handleCreateOrder(trade.id)}
                  >
                    Create Order
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
    
  );
}
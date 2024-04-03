import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./Layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom"
import UpdateTrade from "./Trades/UpdateTrade";
import Addtrade from "./Trades/RegisterTrade";
import OrderHome from "./pages/OrderHome";


function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />

        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addtrade" element={<Addtrade />} />
          <Route exact path="/orderhome" element={<OrderHome />} />
          <Route exact path="/edittrade/:id" element={<UpdateTrade />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddGame from "./games/AddGame";
import EditGame from "./games/EditGame";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addgame" element={<AddGame />} />
          <Route exact path="/editgame/:id" element={<EditGame />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

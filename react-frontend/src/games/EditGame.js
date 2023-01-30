import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditGame() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [game, setGame] = useState({
    name: "",
    aggregated_rating: 0,
    first_release_date: "",
  });

  const { name, aggregated_rating, first_release_date } = game;

  const onInputChange = (e) => {
    setGame({ ...game, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadGame();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    game.first_release_date = Date.parse(first_release_date) / 1000;
    await axios.put(`http://localhost:8080/api/v1/games/${id}`, game);
    navigate("/");
  };

  const loadGame = async () => {
    const result = await axios.get(`http://localhost:8080/api/v1/games/${id}`);
    const { data } = result;
    data.first_release_date = new Date(data.first_release_date * 1000)
      .toISOString()
      .split("T")[0];
    setGame(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit Game</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Title" className="form-label">
                Title
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter title"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Rating" className="form-label">
                Rating (%)
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter game rating"
                name="aggregated_rating"
                value={aggregated_rating}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Release" className="form-label">
                Release date
              </label>
              <input
                type={"date"}
                className="form-control"
                placeholder="Enter release date"
                name="first_release_date"
                value={first_release_date}
                onChange={(e) => onInputChange(e)}
                required
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Update
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

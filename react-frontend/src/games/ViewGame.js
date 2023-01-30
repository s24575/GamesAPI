import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewGame() {
  const [game, setGame] = useState({
    name: "",
    aggregated_rating: 0,
    first_release_date: "",
  });

  const { id } = useParams();

  useEffect(() => {
    loadGame();
  }, []);

  const loadGame = async () => {
    const result = await axios.get(`http://localhost:8080/api/v1/games/${id}`);
    const { data } = result;
    data.first_release_date = new Date(
      data.first_release_date * 1000
    ).toLocaleDateString();
    setGame(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Game Details</h2>
          <div className="card">
            <div className="card-header">
              Details: {game.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Title: </b>
                  {game.name}
                </li>
                <li className="list-group-item">
                  <b>Rating: </b>
                  {game.aggregated_rating} %
                </li>
                <li className="list-group-item">
                  <b>Release: </b>
                  {game.first_release_date}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Main Menu
          </Link>
        </div>
      </div>
    </div>
  );
}

import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Home() {
  const [games, setGames] = useState([]);

  // const { id } = useParams;

  useEffect(() => {
    loadGames();
  }, []);

  const loadGames = async () => {
    const result = await axios.get("http://localhost:8080/api/v1/games");
    setGames(result.data);
  };

  const deleteGame = async (id) => {
    await axios.delete(`http://localhost:8080/api/v1/games/${id}`);
    loadGames();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Title</th>
              <th scope="col">Score</th>
              <th scope="col">Release</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {games.map((game, index) => {
              var date = new Date(
                game.first_release_date * 1000
              ).toLocaleDateString("pl");
              return (
                <tr>
                  <th scope="row" key={index}>
                    {index + 1}
                  </th>
                  <td>{game.name}</td>
                  <td>{game.aggregated_rating}%</td>
                  <td>{date}</td>
                  <td>
                    <Link
                      className="btn btn-primary mx-2"
                      to={`/viewgame/${game.id}`}
                    >
                      View
                    </Link>
                    <Link
                      className="btn btn-outline-primary mx-2"
                      to={`/editgame/${game.id}`}
                    >
                      Edit
                    </Link>
                    <button
                      className="btn btn-danger mx-2"
                      onClick={() => deleteGame(game.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

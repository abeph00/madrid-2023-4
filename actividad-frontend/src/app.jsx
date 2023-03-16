import { Header } from "./components/header";
import { Placeholder } from "./components/placeholder";
import Card from '@mui/material/Card';
import "./app.css";
import CardContent from '@mui/material/CardContent';
import React, { useState, useEffect } from 'react';
import CardMedia from '@mui/material/CardMedia';

function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch('/report-summary/');
      const json = await response.json();
      setData(json);
    };
    fetchData();
  }, []);
  return (
    <div className="app">
      <Header />
      <div className="container">
        <div className="summary">
          {/* TODO: Ejercicio 2 - Crear el componente resumen  */}
          <div className="cards">
            <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                  {data.totalOrders}
                </span>
                <span>
                  pedidos
                </span>
              </CardContent>
            </Card>
            <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                  {data.totalProducts}
                </span>
                <span>
                  unidades
                </span>
              </CardContent>
            </Card>
            <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                  {data.totalSales}
                </span>
                <span>
                  importe
                </span>
              </CardContent>
            </Card>
          </div>
        </div>
        <div className="ranking">
          {/* TODO: Ejercicio 3 - Crear el componente ranking  */}
          <div className="list">
          <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                <CardMedia
                            component="img"
                            height="194"
                            image={"/assets/products/dress_a.jpg"}
                            alt="Paella dish"
                        />
                </span>
                <span>
                </span>
              </CardContent>
            </Card>
            <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                <CardMedia
                            component="img"
                            height="194"
                            image={"/assets/products/dress_a.jpg"}
                            alt="Paella dish"
                        />
                </span>
                <span>
                </span>
              </CardContent>
            </Card>
            <Card className="middle" sx={{ minWidth: 275 }}>
              <CardContent>
                <span className="size">
                <CardMedia
                            component="img"
                            height="194"
                            image={"/assets/products/dress_a.jpg"}
                            alt="Paella dish"
                        />
                </span>
                <span>
                </span>
              </CardContent>
            </Card>
            </div>
        </div>
      </div>
    </div>
  )
}

export default App;

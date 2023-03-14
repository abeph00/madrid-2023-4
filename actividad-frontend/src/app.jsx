import { Header } from "./components/header";
import { Placeholder } from "./components/placeholder";
import "./app.css";

function App() {
  return (
    <div className="app">
      <Header />
      <div className="container">
        <div className="filters">
          {/* TODO: Ejercicio 2 - Crea el componente de filtros */}
          <Placeholder />
        </div>
        <div className="summary">
          {/* TODO: Ejercicio 3 - Crear el componente resumen  */}
          <Placeholder />
        </div>
        <div className="content">
          <div className="orders">
            {/* TODO: Ejercicio 4 - Crear el componente ordenes  */}
            <Placeholder />
          </div>
          <div className="ranking">
            {/* TODO: Ejercicio 5 - Crear el componente ranking  */}
            <Placeholder />
          </div>
        </div>
      </div>
    </div>
  )
}

export default App;

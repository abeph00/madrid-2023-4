import { Header } from "./components/header";
import { Placeholder } from "./components/placeholder";

import "./app.css";

function App() {
  return (
    <div className="app">
      <Header />
      <div className="container">
        <div className="summary">
          {/* TODO: Ejercicio 2 - Crear el componente resumen  */}
          <Placeholder />
        </div>
        <div className="ranking">
          {/* TODO: Ejercicio 3 - Crear el componente ranking  */}
          <Placeholder />
        </div>
      </div>
    </div>
  )
}

export default App;

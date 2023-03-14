import zaraLogo from "../../assets/images/zara-logo.svg";
import { Placeholder } from "../placeholder";
import "./style.css";

export const Header = () => {

    const onClick = () => {
        window.location.reload();
    }

    return (
        <div className="header">
            <div className="header__logo">
                <img src={zaraLogo} alt="Zara" data-testid="zara-logo" onClick={onClick} />
            </div>
            <div className="header__avatar">
                {/* TODO: Ejercicio 1 cambiar el componente Placeholder por nuestro componente Avatar */}
                <Placeholder width={30} height={30} />
            </div>
        </div>
    )
}
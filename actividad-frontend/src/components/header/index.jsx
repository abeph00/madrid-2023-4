import zaraLogo from "../../assets/images/zara-logo.svg";
import { Placeholder } from "../placeholder";
import "./style.css";
import Avatar from '@mui/material/Avatar';

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
                <Avatar>H</Avatar>
            </div>
        </div>
    )
}
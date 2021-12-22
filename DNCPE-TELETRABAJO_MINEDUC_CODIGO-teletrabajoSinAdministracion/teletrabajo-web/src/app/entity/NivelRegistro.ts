import { ItemCatalogo } from "./ItemCatalogo";
import { CabeceraRegistro } from "./CabeceraRegistro";

export class NivelRegistro {
    public codNivelRegistro: number;
    public telCabeceraRegistro: CabeceraRegistro;
    public telAsignatura: ItemCatalogo;
    public telGrado: ItemCatalogo;    
    public telNivel: ItemCatalogo;
}
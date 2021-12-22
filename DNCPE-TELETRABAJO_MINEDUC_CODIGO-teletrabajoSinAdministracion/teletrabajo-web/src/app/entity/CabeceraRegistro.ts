import { ItemCatalogo } from "./ItemCatalogo";
import { Usuario } from "./Usuario";
import { InsEducativa } from "./InsEducativa";
import { Distrito } from "./Distrito";

export class CabeceraRegistro {
    public codCabeceraRegistro: number;
    public telCargo: ItemCatalogo;
    public telOfertaEducativa: ItemCatalogo;
    public telItemCatalogo: ItemCatalogo;
    public telUsuario: Usuario;
    public telInsEducativa: InsEducativa; 
    public telDistritoCabecera: Distrito;
    public telRegimen: ItemCatalogo;
}
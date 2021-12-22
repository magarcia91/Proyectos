import { Actividad } from "./actividad";

export class Semana {
    codigoRegistro: number;
    codSemana: number;
    fechaFin: Date;
    fechaInicio: Date;
    actividades: Actividad[];
}
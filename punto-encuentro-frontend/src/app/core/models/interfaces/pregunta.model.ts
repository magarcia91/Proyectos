import { Respuesta } from "./respuesta.model";

export interface Pregunta{
    preCodigo: number;
    prePresentar: number;
    prePregunta: string;
    tpeCodigo: number;
    respuestas:Respuesta[];
}

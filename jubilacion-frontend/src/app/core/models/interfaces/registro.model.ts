export interface Registro{
     id?:number;
     documentoIdentidad:string;
     nombre:string;
     fechaNacimiento:Date;
     genero:string;
     discapacidad:number;
     nacionalidad:number;
     etnia?:number;
     celular: string;
     direccion?: string;
     movilidadHumana?: number;
     conectividad?: number;
     cambio_vivienda?: number;
     IE_cerca?: number;
     sede: number;
     grado: number;
     esMatriculado:number;
     peso:number;
     talla:number;
     comidasAlDia:number;
     visitaMedico:number;
     estIdentidad?:string;
}
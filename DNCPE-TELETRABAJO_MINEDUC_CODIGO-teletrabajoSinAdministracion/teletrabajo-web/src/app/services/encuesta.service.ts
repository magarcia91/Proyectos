import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { NivelRegistro } from 'app/entity/NivelRegistro';

@Injectable({
  providedIn: 'root'
})
export class EncuestaService {

  header = {
    headers: new HttpHeaders()
        .set('Authorization', localStorage.getItem('token'))
  };

  constructor(private httpClient: HttpClient) { }


  getPreguntas() {                
    return this.httpClient.get(environment.url_back_end + '/encuesta/recuperarEncuesta?identificacion='+localStorage.getItem('identificacion')+'&codigoEncuesta='+localStorage.getItem('codigoEncuesta'), this.header);
  }

  guardarRespuestas(encuesta: any) {   
    return this.httpClient.post(environment.url_back_end + '/encuesta/salvarRespuestas', encuesta, this.header);
  }

  getExistenPreguntasGuardadas(codCabeceraRegistro:any) {            
    return this.httpClient.get(environment.url_back_end + '/encuesta/validarExistenRespuestas?codigoCabeceraRegistro='+codCabeceraRegistro, this.header);
  }

  getEncuestasHabilitadas(identificacion:any) {            
    return this.httpClient.get(environment.url_back_end + '/encuesta/listarEncuestasHabilitadas?identificacion='+identificacion, this.header);
  }
}

import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { environment } from "environments/environment";

@Injectable()
export class AgendaService {

    header = {
        headers: new HttpHeaders()
            .set('Authorization', localStorage.getItem('token'))
    };
    constructor(private httpClient: HttpClient) { }

    getSemana() {
        return this.httpClient.get(environment.url_back_end + '/agenda/semana', this.header);
    }

    getActivities() {
        return this.httpClient.get(environment.url_back_end + '/agenda/actividades', this.header);
    }

    save(registro) {
        return this.httpClient.post(environment.url_back_end + '/agenda', registro, this.header);
    }

    getCabecera() {
        return this.httpClient.get(environment.url_back_end + '/agenda/cabecera', this.header);
    }

    guardarTrabajoPresencial(registro: any) {
        return this.httpClient.post(environment.url_back_end + '/agenda/guardarTrabajoPresencial', registro, this.header);
    }

    inactivarActividades(registro: any) {
        return this.httpClient.post(environment.url_back_end + '/agenda/inactivarActividades', registro, this.header);
    }
    
}
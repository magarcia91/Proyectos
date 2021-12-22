import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { NivelRegistro } from 'app/entity/NivelRegistro';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  header = {
    headers: new HttpHeaders()
        .set('Authorization', localStorage.getItem('token'))
  };

  constructor(private httpClient: HttpClient) { }

  getDatosUsuario() {            
    return this.httpClient.get(environment.url_back_end + '/docente/findByIdentificacion?identificacion='+localStorage.getItem('identificacion'), this.header);
  }

  getOfertasEducativas() {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarOfertaEducativa', this.header);
  }

  getFuncionesCargos(codigoItemCatalogo: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarFuncionesCargos?codigoPadre='+codigoItemCatalogo, this.header);
  }

  getNivelesSubniveles(codigoItemCatalogo: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarNivelesSubniveles?codigoPadre='+codigoItemCatalogo, this.header);
  }

  getGrados(codigoItemCatalogo: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarGrados?codigoPadre='+codigoItemCatalogo, this.header);
  }

  getAreasAsignaturas(codigoItemCatalogo: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarAreasAsignaturas?codigoPadre='+codigoItemCatalogo, this.header);
  }

  getCabeceraRegistro() {            
    return this.httpClient.get(environment.url_back_end + '/docente/obtenerCabeceraRegistro?identificacion='+localStorage.getItem('identificacion'), this.header);
  }

  getDistrito() {               
    return this.httpClient.get(environment.url_back_end + '/docente/obtenerDistritoDpa?dpaDistrito='+localStorage.getItem('distrito'), this.header);
  }

  getDistritosPorZona(codigoZona: any) {               
    return this.httpClient.get(environment.url_back_end + '/docente/listarDistritosZona?codZona='+codigoZona, this.header);
  }

  getZonas() {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarZonas', this.header);
  }

  getRegimenes() {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarRegimenes', this.header);
  }

  getProvincias(codigoZona: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarProvincias?codZona='+codigoZona, this.header);
  }

  getDistritos(codigoProvincia: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarDistritos?codProvincia='+codigoProvincia, this.header);
  }

  getInstitucionesPorDistrito(codigoDistrito: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarInstitucionesEducativasPorDistrito?codDistrito='+codigoDistrito, this.header);
  }

  getInstitucionesPorOferta(nemonicoOferta: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarInstitucionesEducativasPorOferta?nemonicoOferta='+nemonicoOferta, this.header);
  }

  getInstitucionesPorDistritoYOferta(codigoDistrito: any, nemonicoOferta: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarInstitucionesEducativasPorDistritoYOferta?codDistrito='+codigoDistrito+'&nemonicoOferta='+nemonicoOferta, this.header);
  }

  getNivelesRegistroGuardados(codigoCabecera: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarNivelesGuardados?codigoCabeceraRegistro='+codigoCabecera, this.header);
  }

  guardarCabeceraRegistro(registro) {
    return this.httpClient.post(environment.url_back_end + '/docente', registro, this.header);
  }

  guardarNivelesRegistro(niveles: NivelRegistro[]) {
    return this.httpClient.post(environment.url_back_end + '/docente/saveNiveles', niveles, this.header);
  }

  guardarDistritosRegistro(distritos: any[]) {
    return this.httpClient.post(environment.url_back_end + '/docente/saveDistritos', distritos, this.header);
  }

  getDistritosRegistroGuardados(codigoCabecera: any) {            
    return this.httpClient.get(environment.url_back_end + '/docente/listarDistritosGuardados?codigoCabeceraRegistro='+codigoCabecera, this.header);
  }

  guardarClaveUsuario(claveUsuario: any){
    return this.httpClient.post(environment.url_back_end + '/clave/guardarClave', claveUsuario, this.header);
  }
}

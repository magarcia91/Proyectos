import { environment } from '../../../environments/environment';
import { Injectable, Pipe } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';
import { NgxSpinnerService } from 'ngx-spinner';


@Injectable()
export class AuthService {
  result: any;
  // tslint:disable-next-line: variable-name
  private _token: string;
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  header = {
    headers: new HttpHeaders()
        .set('Authorization', localStorage.getItem('token'))
      };

  constructor(public router: Router,
              private httpClient: HttpClient,
              public spinner: NgxSpinnerService) {}

  // tslint:disable-next-line: typedef
  async login(cedula: string, password: string) {
    try {
      this.spinner.show();
      // tslint:disable-next-line: max-line-length
      const usuarioLogueo = {
        identificacion: cedula,
        clave: password,
      };

      this.httpClient
        .post(`${environment.url_back_end}/public/login`, usuarioLogueo)
        .subscribe(
          (res: any): void => {
            this.result = res;
            if (this.result.codigoError === 0) {
              const fechaActual = new Date();
              localStorage.setItem('fechaInicio', JSON.stringify(fechaActual));
              localStorage.setItem('menu', JSON.stringify(this.result.menu));
              localStorage.setItem('token', this.result.token);
              localStorage.setItem('nombre', this.result.mensaje);
              localStorage.setItem('roles', JSON.stringify(this.result.roles));
              localStorage.setItem(
                'identificacion',
                this.result.identificacion
              );
              localStorage.setItem('codUsuario', this.result.codigo);
              location.reload();
              /* this.spinner.hide(); */
            } else {
              if (this.result.codigoError === 2) {
                this.spinner.hide();
                Swal.fire(
                  'Atención',
                  'Debe realizar el autocenso. Por favor acceder  <a href="https://servicios.educacion.gob.ec/gestion-docente-web/">aquí</a>',
                  'warning'
                );
              } else {
                this.spinner.hide();
                Swal.fire(
                  'Atención',
                  'Usuario y/o contraseña incorrecto',
                  'warning'
                );
              }
            }
          },
          (error) => {
            this.spinner.hide();
            Swal.fire(
              'Atención',
              'Usuario y/o contraseña incorrecto',
              'warning'
            );
          }
        );
    } catch (e) {
      this.spinner.hide();
      Swal.fire('Atención', 'Usuario y/o contraseña incorrecto', 'warning');
    }
  }

  public get token(): string{
    if (this._token !== undefined) {
      return this._token;
    }else if (this._token === undefined && localStorage.getItem('token') != null) {
      this._token = localStorage.getItem('token');
      return this._token;
    }
    return null;
  }

  obtenerDatosToken(accessToken: string): any {
    if (accessToken != null) {
      return JSON.parse(atob(accessToken.split('.')[1]));
    }
    return null;
  }

  isAuthenticated(): boolean {
    // tslint:disable-next-line: prefer-const
    let payload = this.obtenerDatosToken(this.token);
    if (payload != null && payload.identificacion && payload.identificacion.length > 0) {
      return true;
    }
    return false;
  }


  async logout(): Promise<void> {
    localStorage.clear();
    location.reload();
  }

  isLoggedIn(): boolean {
    const user = localStorage.getItem('token');
    return user !== null;
  }

  getRoles(): any {
    const roles = localStorage.getItem('roles');
    return roles;
  }
  getMenu(): any {
    const menuNames = JSON.parse(localStorage.getItem('menu'));
    const menusArray: Array<any> = menuNames;
    return menusArray;
  }

  hasRole(role: string): boolean {
    if (this.getRoles().includes(role)) {
      return true;
    }
    return false;
  }

  hasRoles(roles: string[]): boolean {
    let hasRole = false;
    roles.forEach((role) => {
      if (this.hasRole(role)) {
        hasRole = true;
      }
    });
    if (hasRole) {
      return true;
    }
  }

  validateLogin(recurso: any): void {
    const user = localStorage.getItem('token');
    if (user !== null) {
      this.router.navigate([recurso]);
    } else {
      this.router.navigate(['/login']);
    }
  }

}

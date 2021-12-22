import { AuthService } from 'src/app/core/services/authService';
import { map } from 'rxjs/operators';
import { IpListService } from './core/services/ip-list.service';
import { Component } from '@angular/core';
import { AudSesion } from './core/models/aud-sesion';
import { of, Observable, Observer } from 'rxjs';
import { AuthenticationService } from './core/services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'encuentro-web-app';
  cargando = true;
  usuario = true;
  audSesion: AudSesion = new AudSesion();
  public errores: string[];

  observer: Observer<any> = {
    next: value => console.log('siguiente [next]:', value),
    error: error => console.warn('error [obs]:', error),
    complete: () => console.log('completado [obs]')
  };

  constructor(
    private ipListService: IpListService,
    public authService: AuthService,
    private authenticationService: AuthenticationService
  ) {
    setTimeout(() => {
    this.usuario = this.authService.isLoggedIn();
    this.cargando = false;
  }, 1000);
  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngOnInit(): void {
    if (this.authService.isAuthenticated()) {
      const AuthInformation = of(this.authenticationService.getAuthData());
      AuthInformation.pipe().subscribe((x) => {
        this.audSesion.sesUsuario = x[0];
        this.audSesion.sesFechaInicio = x[1];
        this.audSesion.sesAplicacion = x[2];
        this.getIpAddress().pipe(map(ip => {
          if (ip) {
            /* this.audSesion.sesIpExterna = ip; */
            //this.guardarSesion();
          }
        })).subscribe();
      });
    }
  }

  /*public guardarSesion(): void {
    this.authenticationService.guardarDatosSesion(this.audSesion).subscribe(
      this.observer
    );
  }*/

  public getIpAddress(): Observable<string> {
    const ip = this.ipListService.getIpList()
    .pipe(map((res) => (this.audSesion.sesIpExterna = res.ip)));
    return ip;
  }
}

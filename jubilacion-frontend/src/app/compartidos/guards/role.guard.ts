import { AuthService } from '../../core/services/authService';
import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(public authService: AuthService,
              private router: Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      const roles = route.data.role as string[];
      let hasRole = false;
      roles.forEach((role) => {
        if (this.authService.hasRole(role)) {
          hasRole = true;
          }
        const valor = this.authService.hasRole(role);
      });
      if (hasRole) {
        return true;
      }else if (hasRole === false){
        swal.fire('Acceso denegado', 'No tienes acceso a este recurso !!!', 'warning');
        this.router.navigate(['/login']);
      }
  }
}

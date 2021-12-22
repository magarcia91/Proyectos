import { AuthService } from '../../core/services/authService';
import { Injectable } from '@angular/core';
import {
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
    CanActivate
} from '@angular/router';




@Injectable({
    providedIn: 'root'
})
export class AppAuthGuard implements CanActivate {

    constructor(protected router: Router, private readonly authService: AuthService) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if (this.authService.isLoggedIn()) {
            const roles: string[] = this.authService.getRoles().split(',');
            if (route.data.roles && roles.indexOf(route.data.roles[0]) === -1) {
                this.router.navigate(['/login']);
                return false;
            }
            return true;
        } else {
            this.router.navigate(['/login']);
            return false;
        }

        /*
        const expectedRol = route.data.expectedRol;
        const roles = this.tokenService.getAuthorities();
        this.realRol = 'user';
        roles.forEach(rol => {
            if (rol === 'ROLE_ADMIN') {
                this.realRol = 'admin';
            }
        });
        if (!this.tokenService.getToken() || expectedRol.indexOf(this.realRol) === -1) {
            this.router.navigate(['']);
            return false;
        }
        return true;*/
    }

}

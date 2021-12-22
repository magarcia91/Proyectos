/*
 * Nombre: app-auth-guard.ts
 * Descripción: Permite asegurar a cada ruta que se esté utilizando con el canActivate
 * Dependencias:
 * Autor: Sebastian Araujo
 * Consideraciones_generales:
 * Copyright 2020 Ministerio de Educación (https://educacion.gob.ec/). Todos los derechos reservados.
 */
import { Injectable } from '@angular/core';
import {
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
    CanActivate
} from '@angular/router';
import { AuthService } from 'app/services/AuthService';



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
            return false
        }
    }

}

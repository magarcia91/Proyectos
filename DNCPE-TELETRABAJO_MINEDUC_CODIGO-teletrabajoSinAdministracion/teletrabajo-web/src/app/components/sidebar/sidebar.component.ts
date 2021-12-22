import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  public routesPath: RouteInfo[];

  constructor() { }

  ngOnInit() {        
    this.routesPath = [
      { path: '/datosDocente', title: 'Datos principales', icon: 'insert_drive_file', class: '' },
      { path: '/dashboard', title: 'Agenda', icon: 'calendar_today', class: '' }      
    ];
    //habilitar encuesta
    if(localStorage.getItem('habilitadaEncuesta') != null && localStorage.getItem('habilitadaEncuesta') == 'true'){
      this.routesPath.push({ path: '/encuesta', title: 'Encuesta', icon: 'text_snippet', class: '' });      
    }
    this.menuItems = this.routesPath.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  };
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { from, of } from 'rxjs';
import { AuthService } from 'src/app/core/services/authService';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {

  obj: string[] = JSON.parse(this.authService.getRoles());
  objValues = Object.values(this.obj);

  constructor(public router: Router, public authService: AuthService) {}

  ngOnInit(): void {}

  // tslint:disable-next-line: typedef
  logout() {
    this.authService.logout();
    console.log(this.authService.logout());
  }

/*   getRoles(): any{
    const obj = JSON.parse(this.authService.getRoles());
    const roles: string = this.authService.getRoles();
    return obj;
  } */
}

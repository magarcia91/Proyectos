import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../core/services/authService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public token: any;
  public usuario: string;
  public pass: string;

  constructor(private router: Router, private authService: AuthService) {
    this.authService.isAuthenticated();
   }

  ngOnInit(): void {
    this.token = localStorage.getItem('token');
    if (this.token != null) {
      this.router.navigate(['private/registro']);
    }
  }

  // tslint:disable-next-line: typedef
  public onSubmit() {
    // tslint:disable-next-line: max-line-length
    this.authService.login(this.usuario, this.pass);
    //console.log(this.usuario, this.pass);
  }
}

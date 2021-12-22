import { Component } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute,NavigationEnd,Router } from '@angular/router';
import { Email } from './model/email';
import { EmailService } from './service/email.service';
import { filter, map, mergeMap } from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None,
  providers:[EmailService],
})

export class AppComponent {
  title = 'email';

  email : Email[];
  
  constructor(private dataEmail : EmailService, private titleService: Title, 
    private router:Router,private activatedRoute: ActivatedRoute){
      //this.getListEmail();  
      //this.titleService.setTitle("Home");      
    }  

  ngOnInit(){
 
    this.router.events
      .pipe(
        filter(event => event instanceof NavigationEnd),
        map(() => {
          let route = this.activatedRoute;
          while (route.firstChild)
             route = route.firstChild;
          return route;
        }),
        filter((route: any) => route.outlet === "primary"),
        mergeMap((route: any) => route.data),
        map((data: any) => {
          if (data.title) {
            return data.title;
          } else {
            return "Inicio";
          }
        })
      )
      .subscribe(pathString => this.titleService.setTitle(pathString));

    // this.dataEmail.listEmail.subscribe((res) => {
    //   console.log('Emails', res);
    // });
  }
  
  getListEmail(){
   
    this.dataEmail.listEmail().subscribe((resp) => {
      resp = this.email;      
    console.log('Resp', resp);
    });    
  }

}

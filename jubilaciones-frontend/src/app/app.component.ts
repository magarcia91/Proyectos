import { Component } from '@angular/core';
import { Parjub } from './model/parjub';
import { ParjubService } from './service/parjub-service';
import { Title } from '@angular/platform-browser';
import { filter, map, mergeMap } from "rxjs/operators";
import { ActivatedRoute,NavigationEnd,Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jubilaciones-frontend';

  parJub : Parjub[];
  parJub1: any;
   
  constructor(private parJubService : ParjubService, private titleService: Title,private router:Router, private activatedRoute: ActivatedRoute){  
    //titleService.setTitle("Jubilaciones Web App");         
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
            return "Jubilaciones Web App";
          }
        })
      )
      .subscribe(pathString => this.titleService.setTitle(pathString));
  }
   
}



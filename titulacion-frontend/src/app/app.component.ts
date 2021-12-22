import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute,NavigationEnd,Router } from '@angular/router';
import { filter, map, mergeMap } from "rxjs/operators";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'titulacion-frontend';

  constructor(private titleService: Title,private router:Router, private activatedRoute: ActivatedRoute){             
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
              return "Titulación Web App";
            }
          })
        )
        .subscribe(pathString => this.titleService.setTitle(pathString));
    }
    

}





import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmailService } from 'src/app/service/email.service';
import { Email } from 'src/app/model/email';



@Component({
  selector: 'app-contacto-email',
  templateUrl: './contacto-email.component.html',
  styleUrls: ['./contacto-email.component.css']
})
export class ContactoEmailComponent implements OnInit { 
  
  constructor(private emailService :EmailService, private http :HttpClient, private router:Router) { }
  
  email :Email = new Email();
  email1 :Email [];


  ngOnInit(): void {
  }
 
  goToHome() {    
   return this.router.navigate(['/']);
   /* this.emailService.listEmail().subscribe(data => {
      this.email1 = data;
        console.log(data);
      }); */
   }
 
  sendEmail() {
    this.emailService.enviarEmail(this.email)
      .subscribe(data => console.log(data));
  }

  reset(){
    this.email.nombre='';
    this.email.email='';
    this.email.mensaje='';     
  }
}

import { Component, OnInit } from '@angular/core';
import { EmailService } from 'src/app/service/email.service';
import { Email } from 'src/app/model/email';

@Component({
  selector: 'app-listar-contacto',
  templateUrl: './listar-contacto.component.html',
  styleUrls: ['./listar-contacto.component.css']
})
export class ListarContactoComponent implements OnInit {

  email: Email[];

  constructor(private emailService: EmailService) { }

  ngOnInit(): void {
    this.listEmail();
  }
  
  listEmail(){
    this.emailService.listEmail().subscribe(data => {
      this.email = data;
        console.log(data);
    });
  }

}

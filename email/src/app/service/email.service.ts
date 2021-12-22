import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Email } from '../model/email';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EmailService { 
  
  constructor(private http :HttpClient) { }

 listEmail(): Observable<Email[]> {
    return this.http.get<Email[]>(`${environment.baseUrl}/emails`);
  }

  enviarEmail(email :Email): Observable<any> {
    return this.http.post(`${environment.baseUrl}/emails/sendEmail`, email);
  }
}

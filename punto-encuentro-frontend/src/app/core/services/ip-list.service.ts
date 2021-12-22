import { IpListResult } from './../models/ip-list-result';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { switchMap, shareReplay, tap, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class IpListService {


  constructor(private http: HttpClient) {}

  // tslint:disable-next-line: typedef
  public getIpList() {
    return this.http.get<IpListResult>('https://iplist.cc/api/').pipe(catchError(this.handleError));
  }


  // tslint:disable-next-line: typedef
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('Un error ocurrio:', error.error.message);
    } else {
      console.error(
        `Backend codigo de retorno ${error.status}, ` +
        `body: ${error.error}`);
    }
    return throwError(
      'Algo a pasado, por favor trata de nuevo. !!!');
  }
}

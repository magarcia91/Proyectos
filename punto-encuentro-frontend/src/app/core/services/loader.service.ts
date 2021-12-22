import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoaderService {

  isLoading = new BehaviorSubject(false);
  // tslint:disable-next-line: typedef
  show() {
    this.isLoading.next(true);
  }

  // tslint:disable-next-line: typedef
  hide() {
    this.isLoading.next(false);
  }
}

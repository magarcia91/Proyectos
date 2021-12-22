import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoaderService } from '../core/services/loader.service';

@Injectable()
export class LoaderInterceptor implements HttpInterceptor {

  private requests: HttpRequest<any>[] = [];

  constructor(public loaderService: LoaderService) { }

  // tslint:disable-next-line: typedef
  removeRequest(req: HttpRequest<any>) {
    const i = this.requests.indexOf(req);
    if (i >= 0) {
      this.requests.splice(i, 1); // This removes the request from our array
    }
    // Let's tell our service of the updated status
    this.loaderService.isLoading.next(this.requests.length > 0);
  }


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.requests.push(req); // Let's store this request
    this.loaderService.isLoading.next(true);
    // tslint:disable-next-line: deprecation
    return Observable.create(observer => {
      // And subscribe to the original observable to ensure the HttpRequest is made
      const subscription = next.handle(req)
        .subscribe(
          event => {
            if (event instanceof HttpResponse) {
              this.removeRequest(req);
              observer.next(event);
            }
          },
          err => { this.removeRequest(req); observer.error(err); },
          () => { this.removeRequest(req); observer.complete(); });
      // return teardown logic in case of cancelled requests
      return () => {
        this.removeRequest(req);
        subscription.unsubscribe();
      };
    });
  }

}

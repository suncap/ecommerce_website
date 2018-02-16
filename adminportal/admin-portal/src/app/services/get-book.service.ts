import { Injectable } from '@angular/core';
import { Http, Headers} from '@angular/http';

@Injectable()
export class GetBookService {

  constructor(private http: Http) { }

  getBook(id: number){
    let url = "http://localhost:8181/book/list";

    let headers = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.get(url, {headers : headers});
  }
}

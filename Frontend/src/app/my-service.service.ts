import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from './models/event.model'; // Adjust the import path as necessary
@Injectable({
  providedIn: 'root'
})
export class MyServiceService {

  private url = 'http://localhost:8080/events';

  constructor(private http: HttpClient) { }

  getEvents(): Observable<Event[]> {
    return this.http.get<Event[]>(this.url);
  }
}

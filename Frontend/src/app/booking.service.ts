import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  bookEvent(userId: number, eventId: number): Observable<any> {
    return this.http.post('http://localhost:8080/book', { userId, eventId }).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 409) {
          return throwError(() => new Error('Event already booked with this Id'));
        }
        return throwError(() => new Error('Booking failed. Please try again'));
      })
    );
  }
}

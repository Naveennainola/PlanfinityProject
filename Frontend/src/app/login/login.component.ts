import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginData = {
    email: '',
    password: ''
  }
  constructor(private http: HttpClient, private router: Router, private bookingService: BookingService, private snackBar: MatSnackBar) { }

  onLogin() {
  this.http.post('http://localhost:8080/login', this.loginData).subscribe({
    next: (response) => {
      sessionStorage.setItem('loggedInUser', JSON.stringify(response)); // Adjust based on API response
      const returnUrl = sessionStorage.getItem('returnUrl') || '/events';
      sessionStorage.removeItem('returnUrl');
      if (returnUrl.startsWith('/event/')) {
        const eventId = returnUrl.split('/').pop();
        const user = JSON.parse(sessionStorage.getItem('loggedInUser') || '{}');
        if (user.userId && eventId) {
          this.bookingService.bookEvent(user.userId, Number(eventId)).subscribe({
            next: () => {
              this.snackBar.open('Event booked successfully','Close', { duration: 3000 });
              this.router.navigate([returnUrl]);
            },
            error: (err) => {
              console.error('Booking failed:', err);
              this.snackBar.open('Booking failed. Please try again','Close', { duration: 3000 });
              this.router.navigate([returnUrl]);
            }
          });
        } else {
          this.snackBar.open('Invalid user or event data.','Close', { duration: 3000 });
          this.router.navigate([returnUrl]);
        }
      } else {
        this.router.navigate([returnUrl]);
      }
    },
    error: (err) => {
      console.error('Login failed:', err);
      this.snackBar.open('Login failed. Please check your credentials.', 'Close', { duration: 3000 });
    }
  });
}
}

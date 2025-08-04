import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Event, Router } from '@angular/router';
import { BookingService } from 'src/app/booking.service';

@Component({
  selector: 'app-eventinfo',
  templateUrl: './eventinfo.component.html',
  styleUrls: ['./eventinfo.component.css']
})
export class EventinfoComponent {
  constructor(private http: HttpClient,
              private router: ActivatedRoute, 
              private route: Router, 
              private bookingService: BookingService, 
              private snackBar: MatSnackBar) {}
  event: any = {};
  ngOnInit() {

    const id = this.router.snapshot.paramMap.get('id');

    this.http.get<Event>('http://localhost:8080/eventinfo/'+id).subscribe({
    next: (data) => {
      console.log(data);
      this.event = data;
    },
    error:(err) => {
      console.error("Error loading event", err);
    }
  });

    console.log("Event info loaded:", this.event);
  }

  bookEvent() {
    const user = sessionStorage.getItem('loggedInUser');
    if(!user) {
      sessionStorage.setItem('returnUrl', `/eventinfo/${this.event.eventId}`);
      this.snackBar.open("Please log in to book an event.", 'Close', { duration: 3000 });
      this.route.navigate(['/login']);
      return;
    }

    const userData = JSON.parse(user);
    this.bookingService.bookEvent(userData.userId, Number(this.event.eventId))
    .subscribe({
      next: () => {
      this.snackBar.open('Event booked successfully', 'Close', { duration: 3000 });
      this.route.navigate(['/']);
    },
    error: (err) => {
      console.error('Booking failed:', err);
      this.snackBar.open(err.message || 'Booking failed. Please try again', 'Close', { duration: 3000 });
    }
    });
    
  }  

}

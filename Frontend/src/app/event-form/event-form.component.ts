import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';


@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent {
  event: any = {
    title: '',
    description: '',
    eventDate: '',
    location: '',
    price: 0,
    capacity: 0,
    category: '',
    organizer: { user_id: 2}
  }

  selectedFile!: File;
  constructor(private http: HttpClient, private snackBar: MatSnackBar, private router: Router) { }
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }
  submitEvent(): void {
    const formData = new FormData();

    formData.append('image', this.selectedFile);

    const eventJson = JSON.stringify(this.event);
    formData.append('event', eventJson);

    this.http.post('http://localhost:8080/event', formData)
    .subscribe(
      res => console.log('Event submitted successfully', res),
      err => console.error('Error submitting event', err)
    )
  }

}

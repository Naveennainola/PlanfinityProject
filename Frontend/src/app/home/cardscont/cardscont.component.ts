import { Component } from '@angular/core';
import { MyServiceService } from 'src/app/my-service.service';
import { Event } from 'src/app/models/event.model'; // Adjust the import path as necessary
import { Router } from '@angular/router';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-cardscont',
  templateUrl: './cardscont.component.html',
  styleUrls: ['./cardscont.component.css']
})
export class CardscontComponent {
  constructor(private myService: MyServiceService, private router: Router, private sanitizer: DomSanitizer){}
  events: Event[] = [];
  ngOnInit(): void {
    this.myService.getEvents().subscribe({
     next: (data: any[]) => {
        this.events = data.map(event => {
          let image: SafeUrl | null = null;
          if (event.image) {
            try {
              // Validate base64 string
              const base64Pattern = /^[A-Za-z0-9+/=]+$/;
              if (!base64Pattern.test(event.image)) {
                console.error('Invalid base64 string for event', event.eventId);
                return { ...event, image };
              }
              const dataUrl = `data:image/jpeg;base64,${event.image}`;
              image = this.sanitizer.bypassSecurityTrustUrl(dataUrl);
            } catch (e) {
              console.error('Error processing image for event', event.eventId, e);
            }
          }
          return { ...event, image };
        });
        console.log('Processed events:', this.events); // Debug
      },
      error: (err) => {
        console.error('Error loading events', err);
      }
    });
  }
        
  onCardClick(event: Event){
    console.log("Card clicked with ID:", event.eventId);
    this.router.navigate(['/eventinfo', event.eventId]);
  
  }
}


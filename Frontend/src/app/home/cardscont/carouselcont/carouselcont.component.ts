import { Component } from '@angular/core';
@Component({
  selector: 'app-carouselcont',
  templateUrl: './carouselcont.component.html',
  styleUrls: ['./carouselcont.component.css']
})
export class CarouselcontComponent {
  carouselEvents = [
    {
      id: 5,
      title:'Youth Fest',
      date: 'October 15, 2025',
      location: 'Chennai, India',
      image: 'assets/carouselImages/img1.webp' 
    },
    {
      id: 6,
      title: 'Food festival',
      date: 'November 20, 2025',
      location: 'Kolkata, India',
      image: 'assets/carouselImages/img2.webp'
    },
    {
      id: 7,
      title: 'Musical Fest',
      date: 'December 25, 2025',
      location: 'Pune, India',
      image: 'assets/carouselImages/img3.webp'
    }
  ];
}

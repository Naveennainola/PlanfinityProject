import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router, private snackBar: MatSnackBar) { }

  isLoggedIn(): boolean{
    return !!sessionStorage.getItem('loggedInUser');
  }

  logout(): void{
    sessionStorage.removeItem('loggedInUser');
    sessionStorage.removeItem('returnUrl');
    this.snackBar.open('Logged out successfully', 'Close', { duration: 3000 });
    this.router.navigate(['/']);
    console.log("Logging out");
  }

}

import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user = {
    name: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: ''
  }

  constructor(private http: HttpClient, private router: Router, private snackBar: MatSnackBar) { }

  onSubmit() {
    if(this.user.password !== this.user.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

  const user_data = {
    name: this.user.name,
    email: this.user.email,
    password: this.user.password,
    role: this.user.role
  };

  this.http.post('http://localhost:8080/register', user_data, { responseType:'json' }).subscribe(
     {
        next: (response: any) => {
          this.snackBar.open(response.message);
          this.router.navigate(['/login']);
        },
        // Optionally, redirect to login or home page
      
      error: (err)=> {
        console.error("Error during registration:", err.error.message);
        this.snackBar.open(err.error?.message || "Registration failed. Please try again.");
      }
  });
  }

}

import {Component, OnInit} from '@angular/core';
import {UserDetailsResponse, UserService} from '../../service/user.service';

@Component({
  selector: 'app-main-layout',
  templateUrl: './main-layout.component.html',
  styleUrls: ['./main-layout.component.css']
})
export class MainLayoutComponent implements OnInit {

  userDetails: UserDetailsResponse;

  constructor(private sampleService: UserService) {
  }

  ngOnInit(): void {
    this.sampleService.userDetails.subscribe(value => {
      if (value) {
        this.userDetails = value;
      }
    });
    this.loadDetails();
  }

  loadDetails(): void {
    this.sampleService.loadUserDetails().then();
  }

}

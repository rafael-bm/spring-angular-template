import {Component, OnInit} from '@angular/core';
import {SampleService} from '../../service/sample.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  serverTime: string;

  constructor(private sampleService: SampleService) {
  }

  ngOnInit(): void {
  }

  getServerTime(): void {
    this.serverTime = '';
    this.sampleService.serverTime()
    .then(value =>
      this.serverTime = value.time
    );
  }

}

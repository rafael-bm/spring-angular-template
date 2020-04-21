import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SampleService {

  constructor(private http: HttpClient) {
  }

  serverTime(): Promise<SampleResponse> {
    return this.http
    .get<SampleResponse>('api/samples')
    .toPromise();
  }

}

interface SampleResponse {
  time: string;
}

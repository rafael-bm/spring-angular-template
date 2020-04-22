import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  serviceEndpoint = environment.serviceEndpoint;
  userDetails = new BehaviorSubject({
    picture: '',
    locale: '',
    name: '',
    email: ''
  });

  constructor(private http: HttpClient) {
  }

  loadUserDetails(): Promise<boolean> {
    return new Promise<boolean>(resolve => {
      this.http
      .get<UserDetailsResponse>(`${this.serviceEndpoint}api/me`)
      .toPromise()
      .then(details => {
        this.userDetails.next(details);
        resolve(true);
      })
      .catch(reason => {
        console.error(`error loadUserDetails: ${JSON.stringify(reason)}`);
        this.userDetails.error(reason);
        resolve(true);
      });
    });
  }

}

export interface UserDetailsResponse {
  picture: string;
  locale: string;
  name: string;
  email: string;
}

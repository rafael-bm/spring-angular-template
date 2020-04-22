import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {MatDialog} from '@angular/material/dialog';
import {ConfirmDialogComponent} from '../confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-top-header',
  templateUrl: './top-header.component.html',
  styleUrls: ['./top-header.component.css']
})
export class TopHeaderComponent implements OnInit {

  avatarSubject = new BehaviorSubject(null);
  nameSubject = new BehaviorSubject(null);
  emailSubject = new BehaviorSubject(null);

  @Input()
  set avatar(value) {
    this.avatarSubject.next(value);
  }

  get avatar() {
    return this.avatarSubject.getValue();
  }

  @Input()
  set name(value) {
    this.nameSubject.next(value);
  }

  get name() {
    return this.nameSubject.getValue();
  }

  @Input()
  set email(value) {
    this.emailSubject.next(value);
  }

  get email() {
    return this.emailSubject.getValue();
  }

  @Output()
  homeEvent: EventEmitter<any> = new EventEmitter<any>();

  @Output()
  profileEvent: EventEmitter<any> = new EventEmitter<any>();

  constructor(public dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  homeClick() {
    this.homeEvent.emit();
  }

  profileClick() {
    this.profileEvent.emit();
  }

  logoutClick() {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: 'Are you sure you want to logout?'
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        window.location.href = 'logout';
      }
    });
  }
}

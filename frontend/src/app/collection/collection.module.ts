import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TopHeaderComponent} from './top-header/top-header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatMenuModule} from '@angular/material/menu';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ConfirmDialogComponent} from './confirm-dialog/confirm-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  declarations: [
    TopHeaderComponent,
    ConfirmDialogComponent
  ],
  imports: [
    CommonModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule
  ],
  exports: [
    TopHeaderComponent,
    BrowserAnimationsModule,
    MatButtonModule,
    MatMenuModule,
    MatDialogModule
  ]
})
export class CollectionModule {
}

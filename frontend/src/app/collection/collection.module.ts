import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TopHeaderComponent} from './top-header/top-header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';


@NgModule({
  declarations: [
    TopHeaderComponent
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule
  ],
  exports: [
    TopHeaderComponent,
    MatButtonModule
  ]
})
export class CollectionModule {
}

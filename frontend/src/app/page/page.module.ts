import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MainLayoutComponent} from './main-layout/main-layout.component';
import {HomePageComponent} from './home-page/home-page.component';
import {RouterModule} from '@angular/router';
import {CollectionModule} from '../collection/collection.module';
import {FlexLayoutModule} from '@angular/flex-layout';


@NgModule({
  declarations: [MainLayoutComponent, HomePageComponent],
  imports: [
    CommonModule,
    RouterModule,
    FlexLayoutModule,
    CollectionModule
  ]
})
export class PageModule {
}

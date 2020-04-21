import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageModule} from './page/page.module';
import {MainLayoutComponent} from './page/main-layout/main-layout.component';
import {HomePageComponent} from './page/home-page/home-page.component';


const routes: Routes = [
  {
    path: '', component: MainLayoutComponent, children: [
      {path: '', redirectTo: 'home', pathMatch: 'full'},
      {path: 'home', component: HomePageComponent},
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes), PageModule],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

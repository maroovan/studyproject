import { Routes, RouterModule } from '@angular/router';

import { LogInComponent} from './log-in/log-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { UserPageComponent } from './user-page/user-page.component';
import { MusicianPageComponent } from './musician-page/musician-page.component';

const appRoutes: Routes = [
  // { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LogInComponent },
  { path: 'register', component: SignUpComponent },
  { path: 'homepage', component: UserPageComponent },
  { path: 'musician', component: MusicianPageComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

export const AppRoutingModule = RouterModule.forRoot(appRoutes);

import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { LoginComponent} from './components/login/login.component';
import { AddnewbookComponent} from './components/addnewbook/addnewbook.component';

const appRoutes: Routes = [
  {
      path : '',
      redirectTo: '/login',
      pathMatch: 'full'
  },
  {
      path : 'login',
      component: LoginComponent
  },
  {
      path : 'addNewBook',
      component: AddnewbookComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

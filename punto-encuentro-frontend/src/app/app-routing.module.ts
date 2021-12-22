import { RoleGuard } from './compartidos/guards/role.guard';
import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { LoginComponent } from './login/login.component';
import { AppAuthGuard } from './compartidos/guards/app-auth-guard';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'private',
        loadChildren: () =>
          import('./private/private.module').then((mod) => mod.PrivateModule),
          canActivate: [AppAuthGuard, RoleGuard], data: { role: ['OPERADOR'] }
      },
    ],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path:'**',
    component: LoginComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

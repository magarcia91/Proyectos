import { AuthService } from '../../../core/services/authService';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  menuArray: any[];
  constructor(public authService: AuthService) {
    this.menuArray = this.authService.getMenu();
  }


  ngOnInit(): void {
  }
}

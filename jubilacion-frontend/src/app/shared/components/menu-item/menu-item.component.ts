import { NavItem } from './../../../core/models/nav-item';
import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-menu-item',
  templateUrl: './menu-item.component.html',
  styleUrls: ['./menu-item.component.scss']
})
export class MenuItemComponent implements OnInit {
  @Input() items: NavItem[];
  @ViewChild('childMenu', {static: true}) public childMenu: any;

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

}

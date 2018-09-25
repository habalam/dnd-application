import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  private headerIcon: string;

  constructor() {
    this.headerIcon = '/assets/images/dungeons_n_dragons_logo_by_banesbox-da3bgkj_custom_small.png';
  }

  ngOnInit() {
  }

}

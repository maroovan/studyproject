import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService} from '../user.service';
import { AlertService} from '../alert.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  model: any = {};
  loading = false;
  constructor(
    private router: Router,
    private userService: UserService,
    private alertService: AlertService) { }

  ngOnInit() {
  }
  register() {
    this.loading = true;
    this.userService.create(this.model)
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {
          this.loading = false;
        });
  }
}

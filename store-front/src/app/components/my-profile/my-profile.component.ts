import { Component, OnInit } from '@angular/core';
import { AppConst } from '../../constants/app-const';
import { UserService } from '../../services/user.service';
import { User } from '../../models/User';
import { LoginService} from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  private serverPath = AppConst.serverPath;
  private dateFetch = false;
  private loginError:boolean;
  private loggedIn:boolean;
  private credential = {'username':'','password':''};

  private user: User = new User();
  private updateSuccess:boolean;
  private newPassword: string;
  private incorrectPassword: boolean;

  constructor(private loginService:LoginService, private userService:UserService, private router:Router) { }

  onUpdateUserInfo(){
      this.userService.updateUserInfo(this.user, this.newPassword).subscribe(
        res => {
            console.log(res.text());
            this.updateSuccess = true;
        },
        error => {
          console.log(error.text());
          let errorMessage = error.text();
          if(errorMessage === "Incorrect current password!") this.incorrectPassword = true;
        }
      );

  }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
      },
      error => {
        this.loggedIn = false;
        this.router.navigate(['/myAccount']);
      }
    );
  }

}

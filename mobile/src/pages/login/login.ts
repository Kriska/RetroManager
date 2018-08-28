import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams} from 'ionic-angular';
import {LoginServiceProvider} from '../../providers/login-service/login-service';
import {ListPage} from '../list/list';

@IonicPage()
@Component({
    selector: 'page-login',
    templateUrl: 'login.html',
})
export class LoginPage {

    constructor(private navCtrl: NavController,
        private navParams: NavParams,
        private loginService: LoginServiceProvider) {
		}

    login(credentials:any) {
        alert("About to login");
        this.loginService.login(credentials).then((success) => {
            alert("Greate Success login." + success)
			this.navCtrl.push(ListPage, {userName: credentials.userName});
        }).catch(error => alert("Error: " + error))
	   }
}

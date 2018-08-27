import {Component} from '@angular/core';
import {NavController, NavParams} from 'ionic-angular';
import {RetrospectiveServiceProvider} from '../../providers/retrospective-service/retrospective-service';
import {LoginPage} from '../login/login';

@Component({
    selector: 'page-list',
    templateUrl: 'list.html'
})
export class ListPage {

	userName: string = "";
	
    constructor(
        private navCtrl: NavController, private navParams: NavParams,
        private retrospectiveService: RetrospectiveServiceProvider) {
			this.userName = navParams.get('userName');
		}

    public submitData(data:any) {
        alert("About to make http");
		//TODO: add username as part of passed data
        this.retrospectiveService.submitRetrospective(data).then(data => {
           alert("Great Successs: " + data);
        }).catch(error => {
            alert("Error: " + error);
        })
    }
}

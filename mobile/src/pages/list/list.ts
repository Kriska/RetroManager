import {Component} from '@angular/core';
import {NavController, NavParams, AlertController} from 'ionic-angular';
import {RetrospectiveServiceProvider} from '../../providers/retrospective-service/retrospective-service';
import {LoginPage} from '../login/login';

@Component({
    selector: 'page-list',
    templateUrl: 'list.html'
})
export class ListPage {

    userName: string = "";
	
    constructor(private navCtrl: NavController, 
                private navParams: NavParams,
                private retrospectiveService: RetrospectiveServiceProvider,
                private alertCtrl: AlertController) {
        this.userName = navParams.get('userName');
    }

    public submitData(data:any, form:any) {
        console.log("Submitting data to rest controller.");

        data.userName = this.userName;
        this.retrospectiveService.submitRetrospective(data).then(data => {
            console.log("Retrospective data was processed successfully", data);
            
            this.showAlert("Thanks for your feedback", "Data submitted successfully.");
            form.reset();
            //Clear user form.
        }).catch(error => {
            alert("Error: " + error);
        })	
    }

    private showAlert(title: string, message: string) {
        let alert = this.alertCtrl.create({
            title: title,
            subTitle: message,
            buttons: ['OK']
        });
        alert.present();
    }
}

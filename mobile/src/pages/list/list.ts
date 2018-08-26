import {Component} from '@angular/core';
import {NavController} from 'ionic-angular';
import {RetrospectiveServiceProvider} from '../../providers/retrospective-service/retrospective-service';

@Component({
    selector: 'page-list',
    templateUrl: 'list.html'
})
export class ListPage {

    constructor(
        private navCtrl: NavController,
        private retrospectiveService: RetrospectiveServiceProvider) {}

    public submitData(data:any) {
        alert("About to make http");

        this.retrospectiveService.submitRetrospective(data).then(data => {
            alert("Great Successs: " + data);
        }).catch(error => {
            alert("Error: " + error);
        })
    }
}

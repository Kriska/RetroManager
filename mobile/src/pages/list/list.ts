import {Component} from '@angular/core';
import { HTTP } from '@ionic-native/http';
import { HttpModule } from '@angular/http'
import {NavController, NavParams}from 'ionic-angular';
import {HomePage}from '../home/home';
import { RetrospectiveServiceProvider } from '../../providers/retrospective-service/retrospective-service';

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})

export class ListPage {
  selectedItem: any;
  url: string;

  constructor(
                private http: HTTP,
                private navCtrl: NavController,
                private navParams: NavParams,
                private retrospectiveService: RetrospectiveServiceProvider) {

    this.selectedItem = navParams.get('item');
    this.url = "https://www.google.co.uk";
  }


  public submitData2() {
        console.log(this.weather);
  }

  itemTapped(event, item) {
    this.navCtrl.push(ListPage, {
      item: item
    });
  }

  public submitData() {
    this.http.post(this.url,
    {
        weather : this.weather,
    },
    {
    headers: {'Content-Type': 'application/json'}
    })
    .then(data => {
        console.log(data.data);
    }).catch(error => {
        console.log(error.status);
    });
  }

  itemTapped(event, item) {
    this.navCtrl.push(ListPage, {
      item: item
    });
  }
}

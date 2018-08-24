import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HTTP } from '@ionic-native/http';
import { HttpModule } from '@angular/http'

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {
  url: string;

  constructor(  private http: HTTP,
                private navCtrl: NavController,
                private navParams: NavParams) {

     this.url = "https://www.google.co.uk";
  }

  login(){
    this.http.post(this.url,
    {
        username : this.username,
        password : this.password,
    },
    {
    headers: {'Content-Type': 'application/json'}
    })
    .then(data => {
        console.log(this.username);
    }).catch(error => {
        console.log(error.status);
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

}

import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http';

@Injectable()
export class LoginServiceProvider {
    private LOGIN_SERVICE_URL = 'http://192.168.43.232:8080/api/security/authenticate';
    private CONTENT_HEADER = {'Content-Type': 'application/json'};

    constructor(private http: HTTP) {}

    login(credentials:any) {
        return new Promise((resolve, reject) => {
            this.http.setDataSerializer("json");
            this.http.post(this.LOGIN_SERVICE_URL, credentials, this.CONTENT_HEADER).then(
                data => {
                    console.log("[LoginServiceProvider]: Success");

                    resolve(data.data);
                }).catch(error => {
                    alert("[LoginServiceProvider]: Error: " + error);
                    reject("Service is unavailable.");
                });
        });
    }
}

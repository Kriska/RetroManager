import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http';

@Injectable()
export class RetrospectiveServiceProvider {
    private RETRO_SERVICE_URL = 'http://10.216.108.125:8090/api/v1/retrospective';
    private CONTENT_HEADER = {'Content-Type': 'application/json'};

    constructor(private http: HTTP) {}

    submitRetrospective(data:any) {
        return new Promise((resolve, reject) => {
            alert("Data: " + data.sprintWeather + " doWell: " + data.doWell);
            this.http.setDataSerializer("json");
            this.http.post(this.RETRO_SERVICE_URL, data, this.CONTENT_HEADER).then(
                data => {
                    alert("[RetrospectiveServiceProvider]: Success");

                    resolve(data.data);
                }).catch(error => {
                    alert("[RetrospectiveServiceProvider]: Error: " + error);
                    reject("Service is unavailable.");
                });
        });
    }
}

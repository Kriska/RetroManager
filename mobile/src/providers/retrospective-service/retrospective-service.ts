import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http';

@Injectable()
export class RetrospectiveServiceProvider {
    private RETRO_SERVICE_URL = 'http://192.168.43.232:8090/api/v1/retrospective';
    private CONTENT_HEADER = {'Content-Type': 'application/json'};

    constructor(private http: HTTP) {}

    submitRetrospective(data:any) {
        return new Promise((resolve, reject) => {
            this.http.setDataSerializer("json");
            this.http.post(this.RETRO_SERVICE_URL, data, this.CONTENT_HEADER).then(
                data => {
                    console.log("[RetrospectiveServiceProvider]: Data was processed successfully.");

                    resolve(data.data);
                }).catch(error => {
                    alert("[RetrospectiveServiceProvider]: Error: " + error);
                    reject("Service is unavailable.");
                });
        });
    }
}

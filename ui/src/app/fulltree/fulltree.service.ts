import { Injectable } from '@angular/core'
import { Http, Headers, RequestOptions, Response } from '@angular/http'
import { Observable } from 'rxjs/Observable'
import 'rxjs/Rx'

@Injectable()
export class FullTreeService {
    httpUrl: string = '/api' + '/documentType/shallow'
    constructor(private _http: Http) { }

    getFileNames(): Observable<any[]> {
        return this._http.
            get(this.httpUrl).
            map((response: Response) =>
                response.json()
            ).
            catch(this.handleError)
    }

    private handleError(error: Response) {
        return Observable.throw(error.json().error || 'Server Error')
    }
}
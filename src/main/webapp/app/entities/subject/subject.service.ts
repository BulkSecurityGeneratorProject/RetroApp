import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {JhiDateUtils} from 'ng-jhipster';

import {Subject} from './subject.model';
import {createRequestOption, ResponseWrapper} from '../../shared';

@Injectable()
export class SubjectService {

    private resourceUrl = 'api/subjects';

    constructor(private http: Http, private dateUtils: JhiDateUtils) { }

    create(subject: Subject): Observable<Subject> {
        const copy = this.convert(subject);
        return this.http.post(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    update(subject: Subject): Observable<Subject> {
        const copy = this.convert(subject);
        return this.http.put(this.resourceUrl, copy).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    find(id: number): Observable<Subject> {
        return this.http.get(`${this.resourceUrl}/${id}`).map((res: Response) => {
            const jsonResponse = res.json();
            this.convertItemFromServer(jsonResponse);
            return jsonResponse;
        });
    }

    query(req?: any): Observable<ResponseWrapper> {
        const options = createRequestOption(req);
        return this.http.get(this.resourceUrl, options)
            .map((res: Response) => this.convertResponse(res));
    }

    delete(id: number): Observable<Response> {
        return this.http.delete(`${this.resourceUrl}/${id}`);
    }

    private convertResponse(res: Response): ResponseWrapper {
        const jsonResponse = res.json();
        for (let i = 0; i < jsonResponse.length; i++) {
            this.convertItemFromServer(jsonResponse[i]);
        }
        return new ResponseWrapper(res.headers, jsonResponse, res.status);
    }

    private convertItemFromServer(entity: any) {
        entity.dateTest = this.dateUtils
            .convertLocalDateFromServer(entity.dateTest);
    }

    private convert(subject: Subject): Subject {
        const copy: Subject = Object.assign({}, subject);
        copy.dateTest = this.dateUtils
            .convertLocalDateToServer(subject.dateTest);
        return copy;
    }
}

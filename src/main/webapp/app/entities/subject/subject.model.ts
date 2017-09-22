import {BaseEntity} from './../../shared';

export class Subject implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public area?: string,
        public province?: string,
        public dateTest?: any,
        public price?: number,
    ) {
    }
}

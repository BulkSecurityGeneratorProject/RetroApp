import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import {RetroAppSubjectModule} from './subject/subject.module';

import {RetroAppPointsModule} from './points/points.module';
import {RetroAppWeightModule} from './weight/weight.module';
import {RetroAppBloodPressureModule} from './blood-pressure/blood-pressure.module';
import {RetroAppPreferencesModule} from './preferences/preferences.module';

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        RetroAppSubjectModule,
        RetroAppPointsModule,
        RetroAppWeightModule,
        RetroAppBloodPressureModule,
        RetroAppPreferencesModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RetroAppEntityModule {}

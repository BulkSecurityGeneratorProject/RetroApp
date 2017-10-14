import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {RetroAppSharedModule} from '../../shared';
import {RetroAppAdminModule} from '../../admin/admin.module';
import {
    BloodPressureComponent,
    BloodPressureDeleteDialogComponent,
    BloodPressureDeletePopupComponent,
    BloodPressureDetailComponent,
    BloodPressureDialogComponent,
    BloodPressurePopupComponent,
    bloodPressurePopupRoute,
    BloodPressurePopupService,
    BloodPressureResolvePagingParams,
    bloodPressureRoute,
    BloodPressureService,
} from './';

const ENTITY_STATES = [
    ...bloodPressureRoute,
    ...bloodPressurePopupRoute,
];

@NgModule({
    imports: [
        RetroAppSharedModule,
        RetroAppAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        BloodPressureComponent,
        BloodPressureDetailComponent,
        BloodPressureDialogComponent,
        BloodPressureDeleteDialogComponent,
        BloodPressurePopupComponent,
        BloodPressureDeletePopupComponent,
    ],
    entryComponents: [
        BloodPressureComponent,
        BloodPressureDialogComponent,
        BloodPressurePopupComponent,
        BloodPressureDeleteDialogComponent,
        BloodPressureDeletePopupComponent,
    ],
    providers: [
        BloodPressureService,
        BloodPressurePopupService,
        BloodPressureResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RetroAppBloodPressureModule {}

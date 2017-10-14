import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {RetroAppSharedModule} from '../../shared';
import {RetroAppAdminModule} from '../../admin/admin.module';
import {
    WeightComponent,
    WeightDeleteDialogComponent,
    WeightDeletePopupComponent,
    WeightDetailComponent,
    WeightDialogComponent,
    WeightPopupComponent,
    weightPopupRoute,
    WeightPopupService,
    WeightResolvePagingParams,
    weightRoute,
    WeightService,
} from './';

const ENTITY_STATES = [
    ...weightRoute,
    ...weightPopupRoute,
];

@NgModule({
    imports: [
        RetroAppSharedModule,
        RetroAppAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        WeightComponent,
        WeightDetailComponent,
        WeightDialogComponent,
        WeightDeleteDialogComponent,
        WeightPopupComponent,
        WeightDeletePopupComponent,
    ],
    entryComponents: [
        WeightComponent,
        WeightDialogComponent,
        WeightPopupComponent,
        WeightDeleteDialogComponent,
        WeightDeletePopupComponent,
    ],
    providers: [
        WeightService,
        WeightPopupService,
        WeightResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RetroAppWeightModule {}

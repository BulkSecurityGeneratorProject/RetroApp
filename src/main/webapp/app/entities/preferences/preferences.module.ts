import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {RetroAppSharedModule} from '../../shared';
import {RetroAppAdminModule} from '../../admin/admin.module';
import {
    PreferencesComponent,
    PreferencesDeleteDialogComponent,
    PreferencesDeletePopupComponent,
    PreferencesDetailComponent,
    PreferencesDialogComponent,
    PreferencesPopupComponent,
    preferencesPopupRoute,
    PreferencesPopupService,
    PreferencesResolvePagingParams,
    preferencesRoute,
    PreferencesService,
} from './';

const ENTITY_STATES = [
    ...preferencesRoute,
    ...preferencesPopupRoute,
];

@NgModule({
    imports: [
        RetroAppSharedModule,
        RetroAppAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        PreferencesComponent,
        PreferencesDetailComponent,
        PreferencesDialogComponent,
        PreferencesDeleteDialogComponent,
        PreferencesPopupComponent,
        PreferencesDeletePopupComponent,
    ],
    entryComponents: [
        PreferencesComponent,
        PreferencesDialogComponent,
        PreferencesPopupComponent,
        PreferencesDeleteDialogComponent,
        PreferencesDeletePopupComponent,
    ],
    providers: [
        PreferencesService,
        PreferencesPopupService,
        PreferencesResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RetroAppPreferencesModule {}

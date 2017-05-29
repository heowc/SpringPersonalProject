'use strict';

app.component('searchPasswordFormModalComponent', {
    templateUrl : 'app/template/modal/searchPasswordFormModal.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
});
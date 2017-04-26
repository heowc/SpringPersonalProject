'use strict';

app.component('joinFormModalComponent', {
    templateUrl : 'app/template/modal/joinFormModal.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
});
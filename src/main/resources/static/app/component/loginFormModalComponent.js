'use strict';

app.component('loginFormModalComponent', {
    templateUrl : 'app/template/modal/loginFormModal.html',
    bindings: {
        resolve: '<',
        close: '&',
        dismiss: '&'
    }
});
'use strict';

var SaveButton = (context) => {
    let ui = $.summernote.ui;

    // create button
    let button = ui.button({
        contents: '<i class="fa fa-child"/> save',
        tooltip: 'save',
        click: function () {
            // event..
        }
    });

    return button.render();   // return button as jquery object
};
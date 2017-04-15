'use strict';

app.controller('noticeWriteController', (noticeService, $scope) => {

    console.log('noticeWriteController');

    $scope.options = {
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['saveButton', ['save']]
        ],
        buttons: {
            save: SaveButton
        },
        popover: {
            image: [],
            link: [],
            air: []
        }
    };

    $scope.save = () => {
        console.log($scope.text);
    };
});
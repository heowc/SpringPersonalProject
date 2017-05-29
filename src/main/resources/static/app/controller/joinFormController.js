'use strict';

app.controller('joinFormController', (memberService, modalService, $scope, base64) => {

    console.log('joinFormController');

    $scope.input = {
        email    : 'naeun@gmail.com',
        password : '1234',
        nickName : 'naeun'
    };

    $scope.join = () => {
        memberService.join(encryptMember($scope.input))
            .then(
                (response) => {
                    modalService.closeJoinModal();
                },
                (error) => {
                    decryptMember().then(()=> {
                        if (error.status === 500) {
                            alert(error.data.message);
                        }

                        if (error.status === 400) {
                            alert(error.data.defaultMessage);
                        }
                    });
                }
            );
    };

    const encryptMember = (member) => {
        let _member = {};
        _member['email'] = base64.encode(member.email);
        _member['password'] = base64.encode(member.password);
        _member['nickName'] = member.nickName;
        return _member;
    };

    $scope.closeModal = () => {
        modalService.closeJoinModal();
    }
});
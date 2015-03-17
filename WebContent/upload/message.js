(function() {
    'use strict';

    angular
        .module('efs.upload')
        .constant('efsUploadMessage','Please select a new template or upload a completed file...')
        .controller('Message', Message);

    Message.$inject = ['efsUploadMessage'];

    function Message(efsUploadMessage) {
        var vm = this;

        vm.message = efsUploadMessage;

        vm.hide = false;

        vm.close = function() {
            vm.hide = true;
        };
    }

})();

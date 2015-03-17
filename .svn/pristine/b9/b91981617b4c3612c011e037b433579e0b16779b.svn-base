(function() {
    'use strict';

    angular
        .module('blocks.common')
        .controller('serviceResponse', serviceResponse);

    serviceResponse.$inject = ['serviceResponseFactory'];

    function serviceResponse(serviceResponseFactory) {
    	var vm = this;

        vm.message = function() {
            if(serviceResponseFactory.showErrors()) {
                return serviceResponseFactory.getErrors()[0].message;
            }
        };

        vm.show = function() {
            return serviceResponseFactory.showErrors();
        };
        
    }

})();

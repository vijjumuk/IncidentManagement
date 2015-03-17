(function() {
    'use strict';

    angular
        .module('blocks.common')
        .factory('serviceResponseFactory', serviceResponseFactory);
    
    function serviceResponseFactory() {
    	var response = {
                results: []
            };
    	
        response.clearErrors = function () {
            response.results = [];
        };

        response.showErrors = function () {
            return response.results.length > 0;
        };

        response.setErrors = function (data) {
        	response.clearErrors();
        	response.results.push({message: data });           
        };
        
        response.getErrors = function () {
        	return response.results;
        };
        
        return {
            showErrors: response.showErrors,
            getErrors: response.getErrors,
            setErrors: response.setErrors,
            clearErrors: response.clearErrors
        };
    }
})();

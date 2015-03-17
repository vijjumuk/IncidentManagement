(function() {
    'use strict';

    angular
        .module('efs.security')
        .factory('security', security);

    security.$inject = ['$rootScope', 'ngDialog', 'AUTH_EVENTS'];
    
    /* @ngInject */
    function security($rootScope, ngDialog, AUTH_EVENTS) {
        var service = {
            isAuthenticated: isAuthenticated,
            initialize: initialize
        };
        return service;

        function initialize () {
          //Register some event handlers that will trigger our login popup
          $rootScope.$on(AUTH_EVENTS.notAuthenticated, showLoginDialog);
          $rootScope.$on(AUTH_EVENTS.sessionTimeout, showLoginDialog);
      //      $rootScope.$on(AUTH_EVENTS.loginSuccess, loginSuccess);
        }

       /* function loginSuccess(response) {
            ngDialog.close();
        }*/

        function isAuthenticated() {
        	//TODO Test for auth cookie. For now just assume we are logged in
        	return false;
        }

        function showLoginDialog () {
        	ngDialog.open({template: 'security/security.html'});
        }
    }
})();
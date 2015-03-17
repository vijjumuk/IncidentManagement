(function () {
    'use strict';

    angular
        .module('efs.security')
        .controller('LoginController', LoginController)
        .config(['ngDialogProvider', function (ngDialogProvider) {
            ngDialogProvider.setDefaults({
                className: 'ngdialog-theme-default',
                plain: false,
                showClose: true,
                closeByDocument: true,
                closeByEscape: true,
                appendTo: false
            })
        }]);


    function LoginController($rootScope, $scope, ngDialog, AUTH_EVENTS,$http) {
        var vm = this;
        vm.credentials = {
            username: 'testetetet',
            password: ''
        };
       vm.loginDialog =  function  () {
            ngDialog.openConfirm({
                template: 'security/security.html',
                scope: $scope
            }).then(
                function (value) {
                    console.log(value);
                },
                function (value) {
                    console.log(value);
                }
            );
        };

       vm.validate = function (){
            $http({
                url:"../EngineeredFlowScheduleUI/j_security_check",
                method: "POST",
                dataType: "html",
                transformRequest: function(obj) {
                    var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                    return str.join("&");
                },
                data: {j_username: 'nab04', j_password: 'qa02test'},
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                success: function(response){
                    alert($scope.j_username);
                    alert("tested" + response);
                    $rootScope.$broadcast(AUTH_EVENTS.loginSuccess, response);
                   // console.log($("usernameId"));
                   /* if(html == "<div>Error Occured</div>"){
                        $("#errorDiv").html("Please provide a valid user name & password.");
                    }else{
                        alert("get user details");
                    }
                    return false;*/
                }
            });
            return false;
        }

        vm.getUserProfile = function (){
            alert("into validate");
            alert($scope.credentials.username);
            $http({
                url:"http://localhost:8085/archservices/rs/usermanager/getprofile",
                data: { j_username: 'nab04', j_password: 'qa02test' },
                method: "GET",
                dataType: "html",
                success: function(response){
                    alert($scope.j_username);
                    alert("tested" + response);
                    $rootScope.$broadcast(AUTH_EVENTS.loginSuccess, response);
                    // console.log($("usernameId"));
                    /* if(html == "<div>Error Occured</div>"){
                     $("#errorDiv").html("Please provide a valid user name & password.");
                     }else{
                     alert("get user details");
                     }
                     return false;*/
                }

            });
            return false;
        }






    }
})();

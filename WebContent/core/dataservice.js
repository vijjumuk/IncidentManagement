// dataservice factory
angular
    .module('efs.core')
    .factory('dataservice', dataservice);

dataservice.$inject = ['$http', '$resource'];

function dataservice($http, $resource) {
    return {
        getLocations: locations
    };

    function locations() {
        return $resource('rs/location/');
    }
}
describe('Blocks Common: templateParser tests :: ', function () {

    var templateParser,
        q,
        scope,
        Papa,
        LOCATION_HEADER_LIST,
        ORDER_GROUP_HEADER_LIST,
        LOAD_GROUP_PARAMETERS_HEADER_LIST,
        VENDOR_PARAMETERS_HEADER_LIST,
        ROUTE_HEADER_LIST,
        SCHEDULE_HEADER_LIST;

    beforeEach(angular.mock.module('efs.upload'));
    beforeEach(angular.mock.module('efs'));

    beforeEach(angular.mock.inject(function (_templateParser_,
                                             _Papa_,
                                             _LOCATION_HEADER_LIST_,
                                             _ORDER_GROUP_HEADER_LIST_,
                                             _LOAD_GROUP_PARAMETERS_HEADER_LIST_,
                                             _VENDOR_PARAMETERS_HEADER_LIST_,
                                             _ROUTE_HEADER_LIST_,
                                             _SCHEDULE_HEADER_LIST_) {
        templateParser = _templateParser_;
        Papa = _Papa_;
        LOCATION_HEADER_LIST = _LOCATION_HEADER_LIST_;
        ORDER_GROUP_HEADER_LIST = _ORDER_GROUP_HEADER_LIST_;
        LOAD_GROUP_PARAMETERS_HEADER_LIST = _LOAD_GROUP_PARAMETERS_HEADER_LIST_;
        VENDOR_PARAMETERS_HEADER_LIST = _VENDOR_PARAMETERS_HEADER_LIST_;
        ROUTE_HEADER_LIST = _ROUTE_HEADER_LIST_;
        SCHEDULE_HEADER_LIST = _SCHEDULE_HEADER_LIST_;
    }));

    beforeEach(angular.mock.inject(function ($q, $rootScope) {
        scope = $rootScope.$new();
        q = $q;
    }));

    it('templateParser factory service exists', function () {
        expect(templateParser).toBeDefined();
    });

    it('csvParser parseHeaders method exists', function () {
        expect(templateParser.validateTemplate).toBeDefined();
    });

    it('templateParser validate template return 1 for location file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([LOCATION_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(1);
    });

    it('templateParser validate template return -1 for unknown file type', function () {

        var resolvedError = undefined,
            resolvedSuccess = undefined;
            csv = Papa.unparse([['UNKNOWN']]);

        templateParser.validateTemplate(csv).then(success, error);

        function success(result) {
            resolvedSuccess = result;
        }

        function error(error) {
            resolvedError = error;
        }

        expect(resolvedError).toBeUndefined();

        templateParser.validateTemplate(csv).then(
            function (_fileType_) {
                resolvedSuccess = _fileType_;
            },
            function (_fileType_) {
            resolvedError = _fileType_;
        });

        scope.$digest();
        expect(resolvedError).toBe(-1);
        expect(resolvedSuccess).toBe(undefined);
    });

    it('templateParser validate template return 2 for order group file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([ORDER_GROUP_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(2);
    });

    it('templateParser validate template return 3 for load group file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([LOAD_GROUP_PARAMETERS_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(3);
    });

    it('templateParser validate template return 4 for order group file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([VENDOR_PARAMETERS_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(4);
    });

    it('templateParser validate template return 5 for route file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([ROUTE_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(5);
    });

    it('templateParser validate template return 6 for schedule file type', function () {

        var resolved = undefined,
            csv = Papa.unparse([SCHEDULE_HEADER_LIST]);

        templateParser.validateTemplate(csv).then(success);

        function success(result) {
            resolved = result;
        }

        expect(resolved).toBeUndefined();

        templateParser.validateTemplate(csv).then(function (_fileType_) {
            resolved = _fileType_;
        });

        scope.$digest();
        expect(resolved).toBe(6);
    });

});

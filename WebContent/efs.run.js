angular
	.module('efs')
	.run(runBlock);

runBlock.$inject = ['$rootScope', '$timeout', 'security', 'AUTH_EVENTS'];

function runBlock($rootScope, $timeout, security, AUTH_EVENTS) {
	security.initialize();

	//Test if we are already authorized
	if (security.isAuthenticated()) {
		//TODO grab any user info that we may need based on the auth cookie
		//We may want to handle this by setting resolves on our routes instead of using app.runasdasdf
	} else {
		//We are not authorized so fire the global unathourized event
		$rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
	
	}
}
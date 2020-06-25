
//Nombre de la aplicación para control con Angular
var aplicacionServicios = "servicioWebHuellas";

angular.module(aplicacionServicios,
	[
		'ngRoute',
		'ngStorage',
		'ngCookies',
		'ngResource',
		'angular-jwt',
		'ng.deviceDetector',
		'ngAnimate',
//		'blockUI',
		'myUpload',
		'angularUtils.directives.dirPagination',
		'angularModalService',
		'ui.bootstrap',
		'angular-responsive'
	]
);

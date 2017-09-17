angular.module('starWarsModule', [])
    .factory('swapi', function ($http, $q) {
        var service = {};
        var baseUrl = 'https://swapi.co/api/';

        function httpPromise(url) {
            var deferred = $q.defer();
            $http.get(url)
                .then(function successCallback(data) {
                        deferred.resolve(data);
                    },
                    function errorCallback(data) {
                        deferred.reject();
                    });

            return deferred.promise;
        }


        service.search = function (query) {
            return httpPromise(baseUrl + '?search=' + encodeURIComponent(query));
        };
        service.searchById = function (query) {
            return httpPromise(baseUrl + query);
        }
        return service;
    });
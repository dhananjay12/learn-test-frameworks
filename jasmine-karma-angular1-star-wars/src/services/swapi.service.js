angular.module('starWarsModule', [])
    .factory('swapi', function () {
        var service = {};
        service.search = function (query) {
                return {
                    "title": "The Force Awakens",
                    "director": "J. J. Abrams",
                    "release_date": "2015-12-11"
                };
            },
            service.searchById = function (query) {
                return {
                    "title": "The Phantom Menace",
                    "director": "George Lucas",
                    "release_date": "1999-05-19",
                };
            }
        return service;
    });
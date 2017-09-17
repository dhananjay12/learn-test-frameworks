describe('swapi service', function () {
    var movieData = {
        "title": "The Force Awakens",
        "director": "J. J. Abrams",
        "release_date": "2015-12-11"
    };

    var movieDataByFilmId = {
        "title": "The Phantom Menace",
        "director": "George Lucas",
        "release_date": "1999-05-19"
    };
    var swapi = {};
    var $httpBackend;
    beforeEach(module('starWarsModule'));
    beforeEach(inject(function (_swapi_, _$httpBackend_) {
        swapi = _swapi_;
        $httpBackend = _$httpBackend_;
    }));

    it('should return search movie data', function () {
        var responseData;

        var expectedUrl = /^https:\/\/swapi.co\/api\/.*/;

        $httpBackend.when('GET', expectedUrl)
            .respond(200, movieData);
        swapi.search('force').then(function (response) {
            responseData = response.data;
        });
        $httpBackend.flush();
        expect(responseData).toEqual(jasmine.objectContaining({
            title: "The Force Awakens"
        }));

    });

    it('should return movie data by id', function () {
        var responseData;

        var expectedUrl = /^https:\/\/swapi.co\/api\/films\/.*/;

        $httpBackend.when('GET', expectedUrl)
            .respond(200, movieDataByFilmId);
        swapi.searchById('films/5').then(function (response) {
            responseData = response.data;
        });
        $httpBackend.flush();
        expect(responseData).toEqual(jasmine.objectContaining({
            title: "The Phantom Menace"
        }));

    });


    it('should return movie data by id should handle error', function () {
        var responseData;

        var expectedUrl = /^https:\/\/swapi.co\/api\/films\/.*/;

        $httpBackend.when('GET', expectedUrl)
            .respond(500);
        swapi.searchById('films/5').then(function (response) {
            responseData = response.data;
        }).catch(function () {
            responseData = 'Error';
        });
        $httpBackend.flush();
        expect(responseData).toEqual('Error');

    });

});
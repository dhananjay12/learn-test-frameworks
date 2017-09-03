describe('swapi service', function () {
    var swapi = {};
    beforeEach(module('starWarsModule'));
    beforeEach(inject(function (_swapi_) {
        swapi = _swapi_;
    }));

    it('should return search movie data', function () {
        console.log(angular.mock.dump(swapi.search('force')));
        expect(swapi.search('force')).toEqual(jasmine.objectContaining({
            title: "The Force Awakens"
        }));
    });

    it('should return movie data by id', function () {
        expect(swapi.searchById(5)).toEqual(jasmine.objectContaining({
            title: "The Phantom Menace"
        }));
    });

});
var app = angular.module("comtradeReaderApp", []);

app.controller("AppCtrl", function ($scope){
    $scope.faults = [{
        name: 'aaaa',
        time: '10',
        tuom: 'ms',
        fallback: '0.9',
        fuom: 'Amphs'
    }];

    // <tr>
    //     <td>{{item.name}}</td>
    //     <td>{{item.time}}</td>
    //     <td>{{item.tuom}}</td>
    //     <td>{{item.fallback}}</td>
    //     <td>{{item.fuom}}t</td>
    // </tr>
});









const uC = "http://localhost:8999/";
let cL = (() => {
    class n {
        constructor(e) {
            this.http = e
        }

        readAndSave() {
            return this.http.get(`${uC}comtrade/readAndSave`)
        }

        getFault() {
            return this.http.get(`${uC}comtrade/getFault`)
        }
    }

    return n.\u0275fac = function (e) {
        return new (e || n)(w(sC))
    }, n.\u0275prov = A({token: n, factory: n.\u0275fac, providedIn: "root"}), n
})();
const Aurl = 'http://127.0.0.1:8999/comtrade'


function sendRequest(method, url, body = null) {
    return new Promise((resolve, reject) => {
        const xhr = new XMLHttpRequest()
        xhr.open(method, url)
        xhr.responseType = 'json'
        xhr.setRequestHeader('Content-Type', 'application/json')
        xhr.send(JSON.stringify(body))
    })
}

sendRequest('GET', Aurl + '/getFault')
    .then()

sendRequest('POST', Aurl + '/readAndSave',{
    path: 'D:/Java_projects/PET_proj/Comtrade_reader/src/main/resources/comtrade',
    fileName: 'Number start = 690 Test = 4.1.2.1.1 Time = 07_19_2022 13_50_13.811 RTDS'
})
    .then()

// var selectedRow = null;
//
// function onFormSubmit() {
//
// }
//
// function readFormData() {
//     var formData = {};
//     formData["valueName"] = document.getElementById("valueName").value;
//     formData["time"] = document.getElementById("time").value;
//     formData["tuom"] = document.getElementById("valueName").value;
//     formData["fallbackValue"] = document.getElementById("fallbackValue").value;
//     formData["fuom"] = document.getElementById("fuom").value;
//     return formData;
// }
var request = require("request");

var options = { method: 'POST',
  url: 'http://localhost:8080/annotations',
  headers:
   { 'content-type': 'application/x-www-form-urlencoded',
     'postman-token': '895fb2db-6a73-bc2c-7ba1-c8a02087aea7',
     'cache-control': 'no-cache',
     programid: '666' },
  form:
   { annotationTitle: 'Test post',
     annotationText: 'This is a test post of annotation',
     emoji: 'delighted',
     pinType: 'User review',
     pinTypeColor: '#333',
     pinTypeDescription: 'A good one',
     annotationContentType: 'Business review',
     annotationType: 'some many redundant fields!',
     parentDomain: 'www.target.com',
     specificUrl: 'www.target.com/poop/and/stuff?q=1234',
     pinXCoordinate: '32.2233',
     pinYCoordinate: '32.123124',
     annotationMediaType: 'jpeg',
     annotationPageHeight: '3500',
     annotationPageWidth: '800',
     annotationMedia: new ArrayBuffer(),
     programId: 'abc234',
     userId: '4',
     hashtag: '#sogood' } };

request(options, function (error, response, body) {
  if (error) throw new Error(error);

  console.log(body);
});

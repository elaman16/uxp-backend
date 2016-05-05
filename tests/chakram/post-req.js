var chakram = require('chakram'),
    expect = chakram.expect,
    baseURL = "localhost:8080";

describe("POST Requests", function() {
  it("Should be able to POST to /annotations", function() {
    var response = chakram.post(baseURL + '/annotations');
    return expect(response).to.have.status(201);
  })
});

//import statements
//Node.js has a built-in module called HTTP, which allows 
//Node.js to transfer data over the Hyper Text Transfer 
//Protocol (HTTP).
var http = require('http');
//data and time module I made
var dt = require('./myfirstmodule');
//for splitting the query string into readable parts
var url = require('url');

//The HTTP module can create an HTTP server that listens 
//to server ports and gives a response back to the client.
//Use the createServer() method to create an HTTP server:

//create a server object:
//  The function passed into the http.createServer() method, 
//  will be executed when someone tries to access the 
//  computer on port 8081.

//req...
//  from the client, as an object (http.IncomingMessage object)
//  This object has a property called "url" which holds 
//the part of the url that comes after the domain name
//req.url...
//  so localhost:8081/summer... gives you /summer
//  so localhost:8081/winter... gives you /winter
//var q = url.parse(req.url, true).query;
//var txt = q.year + " " + q.month;
//  so localhost:8081/?year=2017&month=July... 2017 July

//res...response

//The first argument of the res.writeHead() method is the 
//status code, 200 means that all is OK, the second argument 
//is an object containing the response headers.
http.createServer(function (req, res) {
  res.writeHead(200, {'Content-Type': 'text/html'});
  //res.write('Hello World!'); //write a response to the client
  //res.write("Date and time: " + dt.myDateTime())
  var q = url.parse(req.url, true).query;
  var txt = q.year + " " + q.month;
  res.write(txt);
  res.end(); //end the response
}).listen(8081); //the server object listens on port 8081

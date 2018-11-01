var express = require('express');
var app = express();
var http = require('http');
var fs = require('fs');
http.createServer(app).listen(process.env.PORT || 1111);

const execSync = require('child_process').execSync;
// import { execSync } from 'child_process';  // replace ^ if using ES modules

app.get("/", function (request, response) {
   console.log("In main page.");
   response.writeHead(200,
      {
         'Content-Type':'text'
      }
   );
   fs.readFile("./page.html", (err, data) => {
		 if(err) throw err;
		 response.end(data);
	 });
});

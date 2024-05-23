/**
 * 
 */

function proposal(){

var csv = require('csv-parser');
var fs = require('fs');

var similarity = require('compute-cosine-similarity');
var sentiment = require('sentiment');

var datas = [];
	  
fs.createReadStream('C:/calendar.csv')
 .pipe(csv())
 .on('data', function (data) {
	 
      var x = [data.listing_id,data.date.length,data.available.length,data.price.length];
      var y = [5731498,10,1,0];
	  
	  var s = similarity(x,y);
	  
	  if(s > 0.9999999999999991000 && s <= 1){
		  datas +=  data.listing_id;
	      //document.getElementById("first name").value = data.date;
		  console.log(x);}
	             
  });



fs.createReadStream('C:/reviews.csv')
  .pipe(csv())
  .on('data', function (data) {
	  
	  var s1 = sentiment(data.comments);
	  
	  var a = [data.listing_id,data.id,data.date.length,data.reviewer_id,data.reviewer_name.length,s1];
	  var b = [5731498,29457107,10,23095855,5,4];
	  
	  var sm = similarity(a,b);
	  
	  for(var i=0; i<datas.length; i++)
	    if(sm > 0.9999999999999991000 && sm <= 1 && datas[i] == data.listing_id)
	    	console.log(a);
	      //document.getElementById("first name").value = data.date;
	             
  }); 
}

proposal();
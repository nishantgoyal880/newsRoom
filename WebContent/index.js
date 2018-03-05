/**
 * 
 */
var myArr;

//Retrieving data from the api
function getdata(){
	var search=document.getElementById("data").value;
	var xmlHttp = new XMLHttpRequest();
	
	var url = "https://newsapi.org/v2/everything?q="+search+"&from=2018-02-26&sortBy=popularity&apiKey=22e9046d2cb54f22a3246226766ad815";
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
           myArr= JSON.parse(this.responseText);
           var x="";
            
	    	for(var i=0;i<myArr.articles.length;i++){
	    	   x+=`
	    		<div class="card">
	    		<div class="card-block">
	    		<h4 class="card-title">${myArr.articles[i].title}</h4>
	    		<p class="card-text">${myArr.articles[i].source.name}<br>
	    		${myArr.articles[i].description}<br>
	    		</p>
	    		<button type="button" onclick="addtofav('${i}')">ADD TO FAV</button>
	    		<p id=para></p>
	    		</div>
	    		</div>
	    		`;
	    	   	
	    		}
	    	document.getElementById('mynews').innerHTML=x;
	    	}     

    
    };
 }

//Adding favourites to the list
function addtofav (i){
	var xmlHttp = new XMLHttpRequest();
	var stringVal="source="+myArr.articles[i].source.name+"&title="+myArr.articles[i].title+"&description="+myArr.articles[i].description;
	var url="http://localhost:8081/newsroom/MainServlet?"+stringVal;
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
    
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            alert(this.responseText);
            
        }
    };
}


//Getting list of favourites
function getfav(){
	var xmlHttp = new XMLHttpRequest();
	var url="http://localhost:8081/newsroom/FavList?id=work";
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
    
    
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
        	var myjson= JSON.parse(this.responseText);
            
        	var x="";
            
	    	for(var i=0;i<myjson.news.length;i++){
	    	   x+=`
	    		<div class="card">
	    		<div class="card-block">
	    		<h4 class="card-title">${myjson.news[i].title}</h4>
	    		<p class="card-text">${myjson.news[i].name}<br>
	    		${myjson.news[i].description}<br>
	    		</p>
	    		<button type="button" onclick="remove('${i}')">REMOVE</button>
	    		<p id=para></p>
	    		</div>
	    		</div>
	    		`;
	    	   	
	    		}
	    	document.getElementById('mynews').innerHTML=x;
	    	     

            
        }
    };
}

//Removing element from the favourite list
function remove(i){
	
	var xmlHttp = new XMLHttpRequest();
	var url="http://localhost:8081/newsroom/RemoveClass?id="+i;
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
    
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
        	alert(this.responseText);
        }
    };
}

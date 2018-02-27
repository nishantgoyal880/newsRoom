/**
 * 
 */

function getdata(){
	var search=document.getElementById("data").value;
	var xmlHttp = new XMLHttpRequest();
	
	var url = "https://newsapi.org/v2/everything?q="+search+"&from=2018-02-26&sortBy=popularity&apiKey=22e9046d2cb54f22a3246226766ad815";
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
    xmlHttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            var myArr= JSON.parse(this.responseText);
            var dataObj= JSON.stringify(myArr);
     
            
            
            
            
            for (i = 0; i < myArr.articles.length; i++) {
                var html_code = "<b>Source</b> : "+myArr.articles[i].source.name+"</br> <b>Title</b> : "+myArr.articles[i].title+
                "</br> <b>Description</b> : "+myArr.articles[i].description+ 
                "</br>"+'<button onClick="addtofav(\'' + myArr.articles[i].source.name +'\',\''+
                myArr.articles[i].title+'\',\''+myArr.articles[i].description+'\')">Add To Fav</button>'+
                " </br> </br> ";
                document.getElementById('content').insertAdjacentHTML('afterend', html_code);
            }
        
            
        }
    };
 }


function addtofav (src,ttl,desc){
	var xmlHttp = new XMLHttpRequest();
	var url="http://localhost:8081/newsroom/MainServlet?source="+src+"&title="+ttl+"&description="+desc;
	xmlHttp.open("GET",url, true);
    xmlHttp.send();
}
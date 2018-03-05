<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>NewsRoom</title>

</head>
<body>

 <div class="py-5 text-white bg-primary text-center">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1>NewsRoom</h1>
          <p class="lead mb-4">Be Updated With The Current News</p>
          <form class="form-inline justify-content-center">
            <div class="input-group my-2 w-50">
              <input type="text" class="form-control mr-3 my-1" id="data" placeholder="Type Your Topic Here"> </div>
            <button type="button" class="btn btn-secondary btn-lg" onclick="getdata()">SEARCH</button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a class="btn btn-block btn-dark text-white" onclick="getfav()">WATCH FAVOURITE</a>
        </div>
      </div>
    </div>
  </div>
  
  
  <div  class="container">
	<div class="row" id="mynews"></div>
  </div> 
 
	
	<script type="text/javascript" src="index.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
	</body>
</html>

	
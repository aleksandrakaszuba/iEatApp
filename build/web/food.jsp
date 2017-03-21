<%-- 
    Document   : food
    Created on : 6-Mar-2017, 10:21:03 PM
    Author     : Ola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div>
	<div>
		<h1>Select Food</h1>
		<hr>
	</div>
	<nav class="navbar navbar-default">
		
		<ul class="nav navbar-nav">
			<li><a href="#food"  class="active"><i class="fa fa-search"></i> Search</a></li>
			<li><a href="#meals" ><i class=" "></i> Meals</a></li>
			<li><a href="#recipies" class=" "><i class=" "></i> Recipies</a></li>
		</ul>
	</nav>
	
	<div  >
		<div class="input-group col-md-12">
			<input type="text" class="form-control input-lg" placeholder="Search food" />
			<span class="input-group-btn">
				<button class="btn btn-info btn-lg" type="button">
				<i class="fa fa-search" aria-hidden="true"></i>
				</button>
			</span>
		</div>
	</div>
	<table class="table table-responsive ">
		<thead>
			
			<th>Name</th>
			<th> </th>
		</thead>
		<tbody>
			<tr >
				<td class="text-left" >Item</td>
				<td class="text-right" ><a href="#select_ingredient"><i class="fa fa-plus" aria-hidden="true"></i></a></td>
				
			</tr>
			<tr >
				<td class="text-left" >Item</td>
				<td class="text-right" ><a href="#select_ingredient"><i class="fa fa-plus" aria-hidden="true"></i></a></td>
				
			</tr>
		</tbody>
		
	</table>
</div>
    </body>
</html>

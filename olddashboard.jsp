<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Dashboard - User Management System</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/tether.min.css">
	<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/tether.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>

	<style>
		.jumbotron {
		    padding: 2rem 2rem;
		}

		body{
			margin-top: 15px;
		}

		.topspace {
			margin-top:10px;
		}
	</style>

</head>
<body>

	<div class="container">


		<header class="row">
			<div class="col-md-6">
				<h3 class="text-muted">User Management System</h3>
			</div>

			<div class="col-md-6 ">
				<ul class="nav nav-pills float-right">
					<li class="nav-item"><a class="nav-link active" href="">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="./index.jsp">Logout</a></li>
					
				</ul>
			</div>
		</header>

		<section style="margin-top:20px;" id="main" class="jumbotron">

			<div class="row">
				<div class="col-sm-6">
					<h4>All Registered Users</h4>
				</div>
				<div class="col-sm-6 input-group">
				    	<input type="text" class="form-control offset-sm-6" placeholder="Search">
				      	<span class="input-group-btn">
				        	<button class="btn btn-secondary" type="button">Go!</button>
				      	</span>
				</div>
			</div>
			<hr>
			<div class="userslist">

				<table class="table">
					<thead>
					<tr>
						<th width="119"><b>ID</b></td>
						<th width="168"><b>Username</b></td>
						<th width="168"><b>Fullname</b></td>
						<th width="168"><b>Password</b></td>
						<th width="168"><b>Action</b></th>
					</tr>
					</thead>

					<tbody>
					<% Iterator itr;%>
					<% List data = (List)request.getAttribute("data"); 

						for (itr=data.iterator(); itr.hasNext();)
						{
							%>
							<tr>
								<% Integer id = (Integer)itr.next(); session.setAttribute("id",id); %>
								<th width="119"><%=id%></th>
								<% String username = (String)itr.next(); %>
								<td width="168"><%=username%></td>
								<% String fullname = (String)itr.next(); %>
								<td width="168"><%=fullname%></td>
								<% String password = (String)itr.next(); %>
								<td width="168"><%=password%></td>
								<td>
									<div class="btn-group" role="group" aria-label="Basic example">
  										<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal">Edit</button><!-- Modal -->

  										<button type="button" class="btn btn-danger"><a style="color:black;" onclick="return confirm('Are you sure you want to delete this user?')" href="userdelete?id=<%=id%>">Remove</a></button>

  										<input type="hidden" name="id" value="<%=id%>">

  										<!-- Modal -->
										<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
										  <div class="modal-dialog" role="document">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
										          <span aria-hidden="true">&times;</span>
										        </button>
										      </div>
										      <div class="modal-body">
										      	<form>
										      		<div class="form-control">
										      			<label><b>ID</b></label><input readonly="true" class="form-control"type="text" name="uid" value="<%=id%>"/>
										      		</div>
										      		<div class="form-control topspace">
										      			<label><b>Username</b></label><input class="form-control" type="text" name="un" value="<%=username%>"/>
										      		</div>
										      		<div class="form-control topspace">
										      			<label><b>Fullname</b></label><input class="form-control" type="text" name="fn" value="<%=fullname%>"/>
										      		</div>
										      		<div class="form-control topspace">
										      			<label><b>Password</b></label><input class="form-control" type="text" name="pw" value="<%=password%>"/>
										      		</div>
										      	</form>
										      </div>
										      <div class="modal-footer">
										        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
										        <button type="button" class="btn btn-primary"><a style="color:black;" href="userupdate?id=<%=id%>">Save changes</a></button>
										      </div>
										    </div>
										  </div>
										</div>
									</div>
								</td>

							</tr>
							<%
						}
					%>
					</tbody>

				</table>

				

			</div> 



		</section>


	</div>

</body>
</html>
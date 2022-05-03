<!DOCTYPE html>
<html lang="en">
<head>

<title>Sign-In Page</title>
</head>

<body style='text-align:center'>

	<h1 class="text-center">Sign-In</h1>


	<h1 style='text-align:center;colour:green'>Congratulations!  </h1>
	
	<h1 style='text-align:center;colour:blue'>Your Account has been verified.</h1>


	<form action="LoginServlet" method="post">
		<div class="form-group">
			<input type="email" name="email" id="n1" class="form-control"
				placeholder="Email">
		</div>

		<div class="form-group">
			<input type="password" name="password" id="n2" class="form-control"
				placeholder="Password">
		</div>

		<input type="submit" class="btn btn-primary btn-block" value="Submit" />
	</form>


	
</body>
</html>
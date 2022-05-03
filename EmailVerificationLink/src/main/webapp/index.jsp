<body>

	<h1 style='text-align: center; color: brown'>Registration Page:</h1>

	<div>
		<form action="RegisterUser" method="post"}>
			<table ALIGN="center">
				<tr>

					<td>First-Name::</td>
					<td><input type="text" name="first_name"></td>
				</tr>

				<tr>
					<td>Last-Name::</td>
					<td><input type="text" name="last_name" ></td>
				</tr>

				<tr>
					<td>Email::</td>
					<td><input type="text" name="email" ></td>
				</tr>

				<tr>
					<td>phone::</td>
					<td><input type="tel" name="phone" maxlength="10" /></td>
				</tr>

				<tr>
					<td><label for="gender">Gender : </label></td>
					<td><input type="radio" id="gender" name="gender" value="male" />
						Male <input type="radio" id="gender" name="gender" value="female" />
						Female <br /></td>
				</tr>

				<tr>
					<td><label for="location">Location: </label></td>
					<td><select name="location">
							<option value="Select">Select</option>
							<option value="Banglore">banglore</option>
							<option value="Mysore">Mysore</option>
							<option value="Hubli">Hubli</option>
							<option value="Shiomga">Shimoga</option>
					</select></td>
				</tr>

				<tr>
					<td>password::</td>
					<td><input type="password" name="password" maxlength="10" /></td>
				</tr>


				<tr>
					<td>DOB ::</td>
					<td><input type="date" name="dob" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Register"></td>
					<td><input type="reset" value="reset"></td>
				</tr>
			</table>
			<h4 style='text-align: center; color: blue'>
				Already have an account-<a href='Login.jsp'>Login</a>
			</h4>
		</form>
	</div>

</body>
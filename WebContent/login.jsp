<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="dist/css/carousel.css" rel="stylesheet">
<link href="dist/css/login.css" rel="stylesheet">


<title>Eng Soft III</title>
</head>
<body>
<div class="container">

      <form class="form-signin" action="Servlet_Login"
		method="post">
        <h2 class="form-signin-heading">Acesso ao Sistema</h2>
        <input name="login" type="text" class="form-control" placeholder="Login" required autofocus>
        <input name="senha" type="password" class="form-control" placeholder="Senha" required>
        <button class="btn btn-lg btn-success btn-block" type="submit">Entrar</button>
      </form>
      
</div> 

</body>
</html>
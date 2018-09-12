<%-- 
    Document   : login
    Created on : 11/09/2018, 05:41:42 PM
    Author     : kathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
    .jumbotron{
      margin-left: 25%;
      margin-right: 25%;
      margin-top: 10%;
    }
    body{
      background-color: rgb(0, 0, 0);
    }
    #holi{
      width: 50%;
      height: 50%;
    }
  </style>
</head>

<body>
  <!--Container general.-->
  <div class="container">
    <!--Jumbotron total.-->
    <div class="jumbotron" >
      <!--Titulo de "Bienvenido"-->
      <h1 align="center">Bienvenido</h1>
      <br>
      <!--Input del campo de Usuario-->
      <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroup-sizing-sm">
            <i style="font-size:24px" class="fa">&#xf007;</i>
          </span>
        </div>
        <input type="text" class="form-control" placeholder="Usuario" name="usuario">
      </div>
      <!--Input del campo de Contraseña-->
      <div class="input-group input-group-sm mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroup-sizing-sm">
            <i style="font-size:24px" class="fa">&#xf0c1;</i>
          </span>
        </div>
        <input type="text" class="form-control" placeholder="Contraseña" name="contraseña">
      </div>
      <center>
        <a href="">
          <button type="button" class="btn btn-outline-dark">Ingresar</button>
        </a>
      </center>
    </div>
  </div>
</body>

</html>

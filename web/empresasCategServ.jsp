<%-- 
    Document   : EmpresasCategServ
    Created on : 11/09/2018, 05:37:15 PM
    Author     : kathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Actualizacion empresas, categorias y servidores</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: rgb(248, 244, 244);
        }
        button{
            width: 100px;
            margin-left: 15px;
            margin-right: 15px;
            margin-top:25px;
        }
        .contenedor{
            margin-left: 50px;
            margin-right: 50px;
            align: right;
        }
    </style>
</head>

<body>
    <div class="contenedor">
            <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                      <div class="navbar-header">
                        <a class="navbar-brand" href="#">Control Operaciones</a>
                      </div>
                      <ul class="nav navbar-nav">
                        <li><a href="actividades.jsp">Registro actividades</a></li>
                        <li><a href="empleados.jsp">Registro Empleados</a></li>
                        <li><a href="#">Registro Empresas y Categorías</a></li>
                      </ul>
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                      </ul>
                    </div>
                  </nav>
        <div class="row">
            <div class="col-sm-8">
                <form action="ServletECS" method="POST">
                    <h1>Empresas: </h1>
                    <hr>
                    <label id="codigo" style="margin-right: 10px;">Código: </label>
                    <input type="text" name="codigo" id="codigo">
                    <br>
                    <label id="nombreEmp" style="margin-right: 10px;">Nombre Empresa: </label>
                    <input type="text" name="nombreEmp" id="nombreEmp" style="width: 80.58%;">
                    <br>
                    <label for="sede" id="sede" style="margin-right: 10px;">Sede: </label>
                    <select id="sede">
                        <option>Slamena</option>
                        <option>Shapka</option>
                        <option>Javier</option>
                        <option>Gonzalez</option>
                    </select>
                    <br>
                    <center>
                        <a href="">
                            <button  id="ingresar">Ingresar</button>
                        </a>
                        <a href="">
                            <button type="button" id="acualizar">Actualizar</button>
                        </a>
                        <a href="">
                            <button type="button" id="buscar">Buscar</button>
                        </a>
                        <a href="">
                            <button type="button" id="editar">Editar</button>
                        </a>
                    </center>
                    <br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>john@example.com</td>
                            </tr>
                            <tr>
                                <td>Mary</td>
                                <td>Moe</td>
                                <td>mary@example.com</td>
                            </tr>
                            <tr>
                                <td>July</td>
                                <td>Dooley</td>
                                <td>july@example.com</td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <div class="col-sm-4">
                <form>
                    <h1>Categorias: </h1>
                    <hr>
                    <label id="codigo" style="margin-right: 10px;">Código: </label>
                    <input type="text" name="codigo" id="codigo">
                    <br>
                    <label id="nombreEmp" style="margin-right: 10px;">Nombre Categoria: </label>
                    <input type="text" name="nombreEmp" id="nombreEmp" style="width: 57%;">
                    <br>
                    <center>
                        <a href="">
                            <button type="button"  id="ingresar">Ingresar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="acualizar">Actualizar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="buscar">Buscar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="editar">Editar</button>
                        </a>
                    </center>
                </form>
                <br>
                <form>
                    <h1>Servidores: </h1>
                    <hr>
                    <label id="codigo" style="margin-right: 10px;">Código: </label>
                    <input type="text" name="codigo" id="codigo">
                    <br>
                    <label id="nombreEmp" style="margin-right: 10px;">Nombre Servidor: </label>
                    <input type="text" name="nombreEmp" id="nombreEmp" style="width: 60%;">
                    <br>
                    <label id="codigoEmp" style="margin-right: 15px;">Código Empresa: </label>
                    <input type="text" name="codigoEmp" id="codigoEmp" style="width: 60.3%;">
                    <br>
                    <center>
                        <a href="">
                            <button type="button"  id="ingresar">Ingresar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="acualizar">Actualizar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="buscar">Buscar</button>
                        </a>
                        <a href="">
                            <button type="button"  id="editar">Editar</button>
                        </a>
                    </center>
                </form>
            </div>
        </div>
    </div>
</body>

</html>

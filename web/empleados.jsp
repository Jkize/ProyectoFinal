<%-- 
    Document   : Empleados
    Created on : 11/09/2018, 05:36:56 PM
    Author     : kathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Ingreso Operadores</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: rgb(248, 244, 244);
        }
        .contenedor{
            margin-left: 50px;
            margin-right: 50px;
            align: right;
        }
        input{
            
        }
        label#correo{
            margin-right: 90px;
        }
        label#nombre{
            margin-right: 80px;
        }
        label#contraseña{
            margin-right: 100px;
        }
        label#cargo{
            margin-right: 138px;
        }
        label#sede{
            margin-right: 145px;
        }
        input#correo{
            width: 60%;
        }
        input#nombre{
            width: 60%;
        }
        input#contraseña{
            width: 53.55%;
        }
        label#fechaInicio{
            margin-right: 13px;
        }
        label#fechaFin{
            margin-right: 30px;
        }
        button{
            width: 40%;
            margin-top: 40px;
            margin-left: 20px;
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
                        <li><a href="#">Registro Empleados</a></li>
                        <li><a href="empresasCategServ.jsp">Registro Empresas y Categorías</a></li>
                      </ul>
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                      </ul>
                    </div>
                  </nav>
        <div>
            <form action=" " method="">
                <div class="row">
                    <div class="col-sm-6">
                        <h1>Registro Operadores</h1>
                        <hr>
                        <label id="correo">Correo: </label>
                        <input type="text" name="correo" id="correo">
                        <br>
                        <label id="nombre">Nombre: </label>
                        <input type="text" name="nombre" id="nombre">
                        <br>
                        <label id="contraseña">Contraseña: </label>
                        <input type="text" name="contraseña" id="contraseña">
                        <br>
                        <div class="form-group">
                            <label for="cargo" id="cargo">Cargo: </label>
                            <select id="cargo">
                                <option>Slamena</option>
                                <option>Shapka</option>
                                <option>Javier</option>
                                <option>Gonzalez</option>
                            </select>
                            <br>
                            <label for="sede" id="sede">Sede: </label>
                            <select id="sede">
                                <option>Slamena</option>
                                <option>Shapka</option>
                                <option>Javier</option>
                                <option>Gonzalez</option>
                            </select>
                        </div>

                    </div>
                    <div class="col-sm-6">
                        <h1>Datos Extra Operador Suplente</h1>
                        <hr>
                        
                        
                        <label id="correoO">Correo Operario Original: </label>
                        <input type="text" name="correoOperario" id="correoO" style="width:70%;">
                        <br>
                        <label id="fechaInicio">Fecha Inicio: </label>
                        <input type="date" name="fechaInicio" id="fechaInicio">
                        <br>
                        <label id="fechaFin">Fecha Fin: </label>
                        <input type="date" name="fechaFin" id="fechaFin">
                    </div>
                </div>
            </form>

        </div>

        <div class="row">
            <div class="col-sm-8">
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
            </div>
            <div class="col-sm-4">
                <a href="">
                    <button type="button" id="ingresar">Ingresar</button>
                </a>
                <a href="">
                    <button type="button" id="acualizar">Actualizar</button>
                </a>
                <a href="">
                    <button type="button" id="buscar">Buscar</button>
                </a>
                <a href="">
                    <button type="button"  id="editar">Editar</button>
                </a>
            </div>
        </div>
    </div>
</body>

</html>

<%-- 
    Document   : actividades
    Created on : 11/09/2018, 05:34:48 PM
    Author     : kathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Actualización Tareas</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>

    body{
        background-color: rgb(248, 244, 244);
    }

    #container {
        margin-top: 0%;
        margin-bottom: 0%;
        background-color:rgb(252, 248, 244);
    }
    #formato{margin-top: 2.5%;}

    #inputcito {
        width: 50%;
        height: 20%;
    }
    .contenedor{
            margin-left: 50px;
            margin-right: 50px;
            align: right;
        }
    #inp20 {
        width: 25%;
        height: 20%;
    }

    #inp {
        width: 75%;
        height: 20%;
    }

    #Ingresar {
        height: 20%;
        width: 100%;
    }

    #Actualizar {
        margin-top: 2%;
        height: 20%;
        width: 100%;
    }

    #Eliminar {
        margin-top: 2%;
        height: 20%;
        width: 100%;
    }

    #Buscar {
        margin-top: 2%;
        height: 20%;
        width: 100%;
    }
    #inputcito2{width: 50%;}
</style>

<body>
    <div class="contenedor" >
            <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                      <div class="navbar-header">
                        <a class="navbar-brand" href="#">Control Operaciones</a>
                      </div>
                      <ul class="nav navbar-nav">
                        <li><a href="#">Registro actividades</a></li>
                        <li><a href="empleados.jsp">Registro Empleados</a></li>
                        <li><a href="empresasCategServ.jsp">Registro Empresas y Categorías</a></li>
                      </ul>
                      <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                      </ul>
                    </div>
                  </nav>
        
        <form action="ServletActividades" method="POST"style="height: 80%;" >
            <div id="formato">
                <div class="row">
                    <div class="col-sm-2" id="cosa1">
                        <label> Código: </label>
                        <input id="inputcito">
                        <label for="sel1">Empresa:</label>
                        <select class="form-inclide" id="inputcito2">
                            <% 
                            String[] vehiculos = {"hol","lan","gof"};
                            for (int idx = 0; idx < vehiculos.length; idx++) {
                                   %>
                                   <option><%=vehiculos[idx]%></option>
                               <%     
                                }
                            %>
                            
                        </select>
                    </div>
                    <div class="col-sm-6" id="cosa2">
                        <label>Nombre Tarea: </label>
                        <input id="inp"><br>
                        <label>Duración estimada (min): </label>
                        <input id="inp20">
                    </div>
                    <div class="col-sm-2" id="cosa3">
                        <label for="sel12">Categoría:</label>
                        <select style="width: 50%;" class="form-inclide" id="inputcito23">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                        <label for="sel11">Servidor:</label>
                        <select style="width: 55%;" class="form-inclide" id="inputcito24">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="col-sm-2" id="cosa4">
                        <button id="Ingresar" name="Ingresar">Ingresar Tarea</button>
                        <button id="Actualizar" name="Actualizar">Actualizar Tarea</button>
                        <button id="Buscar" name="Buscar">Buscar Tarea</button>
                        <button id="Eliminar" name="Eliminar">Eliminar Tarea</button>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6" id="cosa5">
                    <h6>Ejecución</h6>
                    <label class="radio-inline"><input type="radio" name="optradio" checked> Último día mes </label>
                    <label class="radio-inline"><input type="radio" name="optradio"> Primer día mes </label>
                    <label class="radio-inline"><input type="radio" name="optradio"> Proceso crítico </label>
                    <h6>Programación Semana</h6>
                    <label class="checkbox-inline"><input type="checkbox" value="">Lu</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Ma</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Mi</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Ju</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Vi</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Sa</label>
                    <label class="checkbox-inline"><input type="checkbox" value="">Do</label><br>
                    <label class="radio-inline"><input type="radio" name="optradio" checked> Decadal </label>
                    <label class="radio-inline"><input type="radio" name="optradio"> Quincenal </label>
                    <label style="color:tomato;" class="checkbox-inline"><input type="checkbox" value="">No ejecutar en
                        días festivos</label><br>
                    <input style="width: 5%; height: 9%;"id="inp">
                    <label style="color:tomato;" >Días comodín (Solo si es último día mes)</label>
                    <h6>Fechas Específicas</h6>
                    <input style="width: 32%" type="date" id="fechaa">
                    <input style="width: 32%" type="date" id="fechaa">
                    <input style="width: 32%" type="date" id="fechaa">
                    <input style="width: 32%" type="date" id="fechaa">
                    <input style="width: 32%" type="date" id="fechaa">
                </div>
                <div class="col-sm-2" id="cosa5">
                    <label style="color:tomato;margin-top: 15%;">Intervalo de Tiempo: </label>
                    <input id="intervalo" style="height: 10%;width: 50%;"><br>
                    <label style="color:tomato;margin-top: 15%;">Hora de inicio: </label> <br>
                    <input type="time" id="hora" style="height: 10%;width: 70%;"><br>
                    <label style="color:tomato;margin-top: 15%;"># veces al día: </label> <br>
                    <input id="veces" style="height: 10%;width: 50%;">
                </div>
                <div class="col-sm-4" id="cosa6">
                    <h6>Descripción Tarea</h6>
                    <label> Descripción: </label><br>
                    <input style="width: 100%;height: 200%;" type="text"><br>
                    <label> URL Manual: </label><br>
                    <input type="url"><br>
                    <label> URL Video explicativo: </label><br>
                    <input type="url">
                </div>
            </div>

        </form>
        <div class="row">
            <div class="col-sm-10">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Descripción</th>
                            <th>Empresa</th>
                            <th>Categoría</th>
                            <th>Pro_decadal</th>
                            <th>Pro_quincenal</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>John</td>
                            <td>Doe</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                        </tr>
                        <tr>
                            <td>Mary</td>
                            <td>Moe</td>
                            <td>mary@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                        </tr>
                        <tr>
                            <td>July</td>
                            <td>Dooley</td>
                            <td>july@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                            <td>john@example.com</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-2">
                <button style="width: 100%;" id="Grabar"disabled="true">Grabar</button>
                <button style="width: 100%; margin-top: 10%;" id="Activar" disabled="true">Activar</button>
                <button style="width: 100%;margin-top: 10%;" id="Ignorar"disabled="true">Ignorar</button>
            </div>

        </div>

    </div>
</body>

</html>

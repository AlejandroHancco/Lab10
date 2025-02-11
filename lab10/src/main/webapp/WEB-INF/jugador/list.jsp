
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab10.entidad.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Jugador>lista=(ArrayList<Jugador>) request.getAttribute("listarJugadores");%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>LAB 9</title>
    </head>
    <body>
    <jsp:include page="/WEB-INF/includes/navbar.jsp" />

        <div class='container'>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>Lista de Jugadores</h1>
                </div>
                <div class="col-lg-6 my-auto text-lg-right">
                    <a href="<%= request.getContextPath()%>/JugadorServlet?action=crear" class="btn btn-primary">Crear
                        Jugador</a>
                </div>

            </div>
            <table class="table">

                <tr>
                    <th>#</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Posicion</th>
                    <th>Club</th>
                    <th>Seleccion</th>

                    <th></th>
                </tr>

                    <% for (Jugador jugador : lista){ %>
                <tr>
                    <td><%=jugador.getIdJugadores()%></td>
                    <td><%=jugador.getNombre()%></td>
                    <td><%=jugador.getEdad()%></td>
                    <td><%=jugador.getPosicion()%></td>
                    <td><%=jugador.getClub()%></td>
                    <td><%=jugador.getSn_idSeleccion()%></td>
                    <td>
                        <a href="<%=request.getContextPath()%>/JugadorServlet?action=borrar&id=<%=jugador.getIdJugadores()%>">
                            Borrar
                        </a>
                    </td>
                </tr>
                <%}%>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
    </body>
</html>

<jsp:include page="/template/head.jsp"></jsp:include>
<jsp:include page="/template/navbar.jsp"></jsp:include>

<% String result = (String)request.getAttribute("resultado"); %>

<h1>Resultado de la operación: <%=result%></h1>


<jsp:include page="/template/footer.jsp"></jsp:include>
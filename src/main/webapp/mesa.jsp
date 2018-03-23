<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="template/head.jsp"></jsp:include>
<jsp:include page="template/navbar.jsp"></jsp:include>

<%
	//Recoger atributo del controlador si es que existe
	Mesa mesa = (Mesa)request.getAttribute("mesa");
	
%>


	
		<div class="container">
  <form action="generar-mesa" method="post">
    <div class="row">
      <div class="col-25">
	 
        <label for="fname">N&uacute;mero de patas</label>
      </div>
      <div class="col-75">
        <input type="number" id="fname" name="patas" value="<%=mesa.getNumeroPatas() %>" required">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">Dimensiones</label>
      </div>
      <div class="col-75">
        <input type="number" id="lname" name="dimensiones" placeholder="<%=mesa.getDimension() %>">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="material">Material</label>
      </div>
      <div class="col-75">
        <select id="material" name="material">
          <option value="1">Madera</option>
          <option value="2">Acero</option>
          <option value="3">Aluminio</option>
		  <option value="4">Plastico</option>
		</select>
      </div>
      <p>Color: <%=mesa.getColor() %></p>
      <p>Quieres personalizar el color</p><br>
      <input type="checkbox" name="custom" <%=(mesa.isCustom())?"checked":"" %>>
    </div>

    <div class="row">
      <input type="submit" value="calcular precio">
    </div>
  </form>
  <div class="col-md-12 price">
	<span>Precio <%=mesa.getPrecio() %> &euro;</span>
</div>
</div>


		
<jsp:include page="template/footer.jsp"></jsp:include>
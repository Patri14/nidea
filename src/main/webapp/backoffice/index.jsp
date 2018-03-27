<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>


<jsp:include page="/template/head.jsp"></jsp:include>
<jsp:include page="/template/navbar.jsp"></jsp:include>

<jsp:include page="/template/alert.jsp"></jsp:include>



<div class="container">


   <div class="row">
       <div class="col-md-12">
			<h1>Listado materiales</h1>
				<table>
				<thead>
		        <tr>
    		        <th>id</th>
    		        <th>Nombre</th>
    		        <th>Precio</th>
		        </tr>
		    	</thead>
				
				<%
				ArrayList<Material> lista = (ArrayList<Material>)request.getAttribute("materiales");
				for (int i=0;i<lista.size();i++)
				{
				   out.println("<tr>");
				   out.println("<td>"+lista.get(i).getId()+"</td>");
				   out.println("<td>"+lista.get(i).getNombre()+"</td>");
				   out.println("<td>"+lista.get(i).getPrecio()+"</td>");
				   out.println("</tr>");
				  
				}
				%>
				</table>
    	</div><!-- end col 12 -->
     </div><!-- end row -->   
</div><!-- end container -->

<jsp:include page="/template/footer.jsp"></jsp:include>
<jsp:include page="template/head.jsp"></jsp:include>
<jsp:include page="template/navbar.jsp"></jsp:include>
<% 
	String nombre = "Cliente";
%>



<div class="container">
	<div class="row">
		<div class="col-md-12">
			 <div class="shell">
			  <div class="range">
				 <div class="heading-box">
					<h1 class="heading-custom">Bienvenido/a<span class="br"></span>
					<span class="br-divider"> <%=nombre %></span>
					</h1>
					<p>Nuestras mesas son de la mejor calidad, reclamadas en todos los lugares del mundo
					</p>
					<a class="btn btn-primary btn-lg btn-mesa" role="button" aria-pressed="true" href="generar-mesa"">Comprar Mesa</a>
				  </div>
				</div>
			 </div>
		</div>
	</div>
</div>

<jsp:include page="template/footer.jsp"></jsp:include>


<jsp:include page="/template/head.jsp"></jsp:include>
<jsp:include page="/template/navbar.jsp"></jsp:include>

<jsp:include page="/template/alert.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="form_main">
	             <h4 class="heading"><strong>Formulario  </strong> Login <span></span></h4>
	              <div class="form">
	                <form action="login" method="post" id="contactFrm" name="contactFrm">
	                    <input type="text" placeholder="Nombre usuario" name="usuario" class="txt" required autofocus>
	                    <input type="text" placeholder="Contraseña" name="password" class="txt" required autofocus>
	                    
	                    <input type="submit" value="Enviar" name="submit" class="txt2">
	                </form>
	            </div>
	       </div>
		</div>
	</div><!-- end row -->
</div><!-- end container -->
		
<jsp:include page="/template/footer.jsp"></jsp:include>
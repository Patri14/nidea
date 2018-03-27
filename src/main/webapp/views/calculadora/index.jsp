<jsp:include page="/template/head.jsp"></jsp:include>
<jsp:include page="/template/navbar.jsp"></jsp:include>

<jsp:include page="/template/alert.jsp"></jsp:include>



<div class="container">
    <div class="row">
        <div class="col-md-12">
        	<div class="calculadora_box">
	        <form  method="post" action="calculadora">
	        	<p>
			      <label for="num1">N&uacute;mero 1:</label>
			      <input type="text" name="num1">
			    </p>
			    <p>
			      <label for="num2">N&uacute;mero 2:</label>
			      <input type="text" name="num2">
			    </p>
	        	<label for="operacion">Operaciones:</label>
				<select name="operacion">
				  <option value="1">Suma</option>
				  <option value="2">Resta</option>
				  <option value="3">Multiplicacion</option>
				  <option value="4">Division</option>
				</select>
	     		<input type="submit" value="calcular">
	        </form>
	        </div>
    	 </div>
     </div>       
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>


		

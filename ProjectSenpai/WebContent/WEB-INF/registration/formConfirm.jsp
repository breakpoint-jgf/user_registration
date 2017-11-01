<%@page import="com.project.senpai.dto.RegistrationDto"%>

<style>

	ul.form {
		list-style :none
	}
	
	ul.form li {
		padding: 10px
	}
	
	ul.form li div {
		display: inline-block;
		width: 150px;
		max-w
	}
	
	ul.form li input {
		margin-left: 10px
	}

	.row{
	    min-height :200px;
	}
	
</style>


<% 
RegistrationDto dto = (RegistrationDto) request.getSession().getAttribute("registrationDtoValid");

if(dto == null){
	dto = new RegistrationDto();
}

%>


<div  id = "main-container" class='container'>
	
	<fieldset>
		<div class="row" id = "row-form">
			<form action="<%=getServletContext().getContextPath() %>/registration" method="post">
				<h2>User Personal Details</h2>
				<ul class="form">
					<li>
						<div><label for="userName">User Name</label></div> <%=dto.getUserName()%>
					</li>
					<li>
						<div><label for="age">Age</label></div> <%=dto.getAge()%>
					</li>
					<li>
						<button type="submit" class="submit-btn" value="back"  name="action">Back</button>
						<button type="submit" class="submit-btn" value="confirm" name="action">Confirm</button>
						<input type="hidden" name = "action" id="action" value="back">
					</li>
				</ul>	
			</form>
		</div>
	</fieldset>
	
	
</div>

<%@include file="/WEB-INF/javascripts_partial.jsp" %>

<script>
		
	$(function(){
		
		$(".submit-btn").click(function(){
			
			$("#action").val($(this).val());
			
		});	
	
	});
</script>


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
RegistrationDto dto = (RegistrationDto) request.getSession().getAttribute("registrationDtoAck");
%>


<div  id = "main-container" class='container'>
	
	<fieldset>
		<div class="row" id = "row-form">
			Thank you <b><%=dto.getUserName()%></b>
		</div>
	</fieldset>
	
	
</div>



<%@page import="com.project.senpai.dto.RegistrationDto"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="ct" uri="/WEB-INF/custom_tags.tld"%>

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
	
	.error{
		color : #FF0000
	}
	
	
</style>


<% 
RegistrationDto dto = (RegistrationDto) request.getSession().getAttribute("registrationDto");

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
					<div><label for="userName">User Name</label></div><input type='text' name = 'userName' id = 'userName' value="<%=dto.getUserName()%>" placeholder = 'user name'>
					<ct:error fieldName="userName"/>
				</li>
				<li>
					<div><label for="age">Age</label></div><input type='text' name = 'age' id="age" placeholder = 'age' value="<%=dto.getAge()%>">
					<ct:error fieldName="age"/>
				</li>
				<li>
					<button type="submit" id="submit-btn" value="submit">Submit</button>
					<input type="hidden" name = "action"  id= "action" value="submit">
				</li>
			</ul>	
		</form>
	</div>
	</fieldset>
	
	
</div>


<%@include file="/WEB-INF/javascripts_partial.jsp" %>

<script>
	
	function PageForm(){
	
		var $nameF = $('#userName');
		var $ageF = $('#age');
			
		function init(){
			$ageF.forceNumeric();
			if($ageF.val() <= 0){
				$ageF.val('');
			}
		}
		
		init();
	}
	
	
	$(function(){

		var pageForm = new PageForm();
	
	});
</script>


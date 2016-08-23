<html>
<head>
<title>Vehicle Identification</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
	$(document).ready(function() { 
	    $('#vehicleDetailsForm').ajaxForm( { beforeSubmit: validate, dataType:  'json', success: processJson, clearForm: true, error: invalidXML  } ); 
	});
	
	/*  This function will test the file extension */
	function validate(formData, jqForm, options) { 
	    var vehicleDetails = $('input[name=vehicleDetails]').fieldValue(); 
	    if (!vehicleDetails[0] || !(/\.(xml)$/i).test(vehicleDetails[0])) { 
	    	$('#vehicleDetailsForm').resetForm();
			$("#processData").html("<h3 style='color: red;'>Kindly select a valid XML file.</h3>");
	        return false; 
	    }  
	}
	/* This method will show the process data */
	function processJson(data){
		var html = "<div><table><tr><th>ID</th><th>Type</th><th>Frame</th><th>Whees</th><th>Powertrain</th></tr>";
		$(data.vehicles).each(function( index ) {
			html += "<tr><td>"+ this.id +"</td>";
			html += "<td>"+ this.type +"</td>";
			html += "<td>"+ this.frame +"</td>";
			html += "<td>"+ this.wheels +"</td>";
			html += "<td>"+ this.powertrain +"</td></tr>";
		});
		html += "</table></div><div><h3>Summary</h3><table><tr><th>Vehicle Type</th><th>Count</th></tr>";
		$(data.summary).each(function( index ) {
			html += "<tr><td>"+ this.vehicleType +"</td>";
			html += "<td>"+ this.count +"</td></tr>";
		});
		html += "</table></div>";
		$("#processData").html(html);
	}
	/* This functuon is for showing error message. */
	function invalidXML(data){
		$('#vehicleDetailsForm').resetForm();
		$("#processData").html("<h3 style='color: red;'>"+ JSON.parse(data.responseText).errorDescr +"</h3>");
	}
    </script>
</head>
<body>
	<h2>Vehicle Identifier</h2>
	<form id="vehicleDetailsForm" method="post"
		enctype="multipart/form-data" action="./services/identification">
		<label>Select File:</label> <input type="file" name="vehicleDetails" /><br />
		<input type="submit">
	</form>
	<div id="processData">
	</div>
</body>
</html>

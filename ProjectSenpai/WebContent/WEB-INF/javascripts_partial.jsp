<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<script src = "<c:url value='/js/jquery.min.js'/>"></script>




<!-- Bootstrap core JavaScript -->
<script src="<c:url value='vendor/jquery/jquery.min.js'/>"></script>
<script src="<c:url value='vendor/popper/popper.min.js'/>"></script>
<script src="<c:url value='vendor/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- Plugin JavaScript -->
<script src="<c:url value='vendor/jquery-easing/jquery.easing.min.js'/>"></script>
<script src="<c:url value='vendor/chart.js/Chart.min.js'/>"></script>
<script src="<c:url value='vendor/datatables/jquery.dataTables.js'/>"></script>
<script src="<c:url value='vendor/datatables/dataTables.bootstrap4.js'/>"></script>


<script>
// forceNumeric() plug-in implementation
jQuery.fn.forceNumeric = function () {

        return this.each(function () {
            $(this).keydown(function (e) {
                var key = e.which || e.keyCode;

                if (!e.shiftKey && !e.altKey && !e.ctrlKey &&
                // numbers   
                    key >= 48 && key <= 57 ||
                // Numeric keypad
                    key >= 96 && key <= 105 ||
                // comma, period and minus, . on keypad
                   key == 190 || key == 188 || key == 109 || key == 110 ||
                // Backspace and Tab and Enter
                   key == 8 || key == 9 || key == 13 ||
                // Home and End
                   key == 35 || key == 36 ||
                // left and right arrows
                   key == 37 || key == 39 ||
                // Del and Ins
                   key == 46 || key == 45)
                    return true;

                return false;
            });
        });
    }

</script>
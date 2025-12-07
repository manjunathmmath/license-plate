<%@ include file="../common/header.jsp" %>
<style type="text/css">
</style>
<body>
<%@ include file="../common/navigation.jsp" %>

<div class="container-fluid mt-2">
    <div class="alert alert-warning" role="alert">
        <p>Total Size of VBO data : 38.5 GB </p>
        <p>Assuming 2,672 records in each XML file.</p>
        <p>4479*2511(total files) = 11246769 records</p>
    </div>
    <%@include file="_filter.jsp" %>
    <div class="px-3 py-2 border-bottom mb-1"></div>
    <%@include file="_dataList.jsp" %>
</div>

<%@ include file="../common/footer.jsp" %>
<script type="text/javascript">
</script>
</body>
</html>
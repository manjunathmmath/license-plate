<%@ include file="common/header.jsp" %>
<style type="text/css">
</style>
<body>
<%@ include file="common/navigation.jsp" %>
<div class="container mt-2">
    <div class="row">
        <div class="col-md-8" id="post-container">

        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        loadAllPost()
    });

    async function loadAllPost() {
        showLoading();
        let data = await getPost();
        let html = ''
        $.each(data, function (index, item) {
            html += ' <article>'
            html += '<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Thumbnail"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>'
            html += '<h1>'+item.title+'</h1>'
            html += '<p class="text-muted">Published by ' + item.email
            html += '<time datetime="2025-12-07">@ December 7, 2025</time>'
            html += '</p>'
            html += '<p>'+item.description+'</p>'
            html += '</article>'
        });
        $("#post-container").html(html)
        removeLoading()
    }

    function getPost() {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'GET',
                url: '/post/getPosts',
                data: {},
                success: function (data) {
                    resolve(data);
                }
            });
        });
    }
</script>
</body>
</html>
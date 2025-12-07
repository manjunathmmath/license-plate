<%@ include file="common/header.jsp" %>
<style type="text/css">
    .post-images{
        width: 200px;
        height: 200px;
        margin: .2rem;
        border: 1px solid #CCCCCC;
    }
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
            $.each(item.images, function (mindex, mitem) {
                html += '<img class="post-images" src="data:'+mitem.type+';base64,'+mitem.imageData+'" />'
            })
            html += '<h1>' + item.title + '</h1>'
            html += '<p class="text-muted">Published by ' + item.email
            html += '<time datetime="2025-12-07"></time>'
            html += '</p>'
            html += '<p>' + item.description + '</p>'
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
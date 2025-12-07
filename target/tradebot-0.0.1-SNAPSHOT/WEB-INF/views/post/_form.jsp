<h5 class="text-start">Post License Plate Details</h5>
<div class="px-3 py-2 border-bottom mb-3"></div>
<div class="row">
    <div class="col-md-10">
        <div class="mb-3">
            <label class="form-label" autocomplete="off">Title</label>
            <input type="email" class="form-control" id="title">
            <div class="invalid-feedback"></div>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" id="email" autocomplete="off">
            <div class="invalid-feedback"></div>
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea class="form-control" id="description" rows="3" autocomplete="off"></textarea>
            <div class="invalid-feedback"></div>
        </div>
    </div>
    <div class="row">
        <div class="col-1">
            <button class="btn btn-primary" id="submit-post">Submit</button>
        </div>
        <div class="col-6">
            <div id="feedback-submit" style="display: none;"></div>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(document).on("click", "#submit-post", function (e) {
        e.preventDefault();

        let title = $("#title").val()
        let email = $("#email").val()
        let description = $("#description").val()
        let isError = false;

        if (!title) {
            $("#title").parent().find(".invalid-feedback").html("This cannot be empty.")
            $("#title").parent().find(".invalid-feedback").show()
            isError = true;
        } else {
            $("#title").parent().find(".invalid-feedback").html("")
            $("#title").parent().find(".invalid-feedback").hide()
        }

        if (!email) {
            $("#email").parent().find(".invalid-feedback").html("This cannot be empty.")
            $("#email").parent().find(".invalid-feedback").show()
            isError = true;
        } else {
            $("#email").parent().find(".invalid-feedback").html("")
            $("#email").parent().find(".invalid-feedback").hide()
        }

        if (!description) {
            $("#description").parent().find(".invalid-feedback").html("This cannot be empty.")
            $("#description").parent().find(".invalid-feedback").show()
            isError = true;
        } else {
            $("#description").parent().find(".invalid-feedback").html("")
            $("#description").parent().find(".invalid-feedback").hide()
        }
        if (isError) {
            return false;
        }
        savePostDetails();
    });

    async function savePostDetails() {
        let data = await savePost();
        if(data['status'] == "success"){
            $("#feedback-submit").html("Success.")
        }else{
            $("#feedback-submit").html("Failure.")
        }
        $("#feedback-submit").show();
        $("#title").val('')
        $("#email").val('')
        $("#description").val('')
    }

    function savePost() {
        let title = $("#title").val()
        let email = $("#email").val()
        let description = $("#description").val()
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: '/post/savePost',
                data: {title: title, email: email, description: description},
                success: function (data) {
                    resolve(data);
                }
            });
        });
    }
</script>
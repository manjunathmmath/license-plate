<div class="row">
    <div class="col-md-12">
        <form action="/post/upload" method="post" class="dropzone" id="upload-form" enctype="multipart/form-data">
            <input type="hidden" id="postId" value="" name="postId">
        </form>
        <span id="upload-message" style="display: none;">Please upload pictures</span>
        <button id="upload-submit" class="btn btn-primary" style="display: none;">Upload</button>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        initDropZone()
    });

    function initDropZone(){
        Dropzone.options.uploadForm = {
            maxFiles: 10,
            parallelUploads: 10,
            acceptedFiles: '.jpg,.jpeg,.png,.gif',
            autoProcessQueue: false,
            init: function () {
                this.on("error", function (file, data) {
                    alert(data)
                });
                this.on("maxfilesexceeded", function (file) {
                    this.removeFile(file);
                });
                this.on("success", function (file) {
                });
                this.on("queuecomplete", function () {
                    this.removeAllFiles();
                });
                this.on("addedfile", function (file) {
                    var removeButton = Dropzone.createElement("<div><button style='width: 100%;text-align:center;text-decoration:none;' class='btn btn-danger dz-remove'><i class='icon md-delete' aria-hidden='true'></i>Remove</button></div>");
                    var _this = this;

                    removeButton.addEventListener("click", function (e) {
                        e.preventDefault();
                        e.stopPropagation();
                        _this.removeFile(file);
                    });

                    $('#upload-submit').click(function (e) {
                        e.preventDefault();
                        e.stopPropagation();
                        _this.processQueue();
                    });

                    file.previewElement.appendChild(removeButton);
                });
            }
        };
    }
</script>
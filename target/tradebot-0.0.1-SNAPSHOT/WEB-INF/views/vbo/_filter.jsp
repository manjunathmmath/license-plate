<div class="row ">
    <div class="col-md-2">
        <div class="input-group input-group-sm">
            <span class="input-group-text">Directory</span>
            <select id="directory" class="form-control">
            </select>
            <div class="invalid-feedback"></div>
        </div>
    </div>
    <div class="col-md-2">
        <div class="input-group input-group-sm ">
            <span class="input-group-text">Files</span>
            <select id="files" class="form-control">
            </select>
            <div class="invalid-feedback"></div>
        </div>
    </div>
    <div class="col-md-2">
        <button class="btn btn-warning btn-sm" type="submit" value="Load" id="load-data">
            Load Data
        </button>
    </div>
    <div class="col-md-2">
        <button class="btn btn-warning btn-sm" type="submit" value="Show" id="show-data">Show Data</button>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        fillDirectoryAndFiles()
    });

    let globalDirList = null;

    async function fillDirectoryAndFiles() {
        let dir = await showDirectory();
        globalDirList = dir;
        let select = $("#directory");
        let htmlMarkup = "";
        htmlMarkup += '<option value="" selected>Choose</option>'
        $.each(dir, function (index, item) {
            if(index.includes("VBO")){
                htmlMarkup += '<option  value="' + index + '">' + index + '</option>'
            }
        });
        select.html(htmlMarkup);
    }

    $(document).on("change", "#directory", function () {
        let key = $(this).val();
        let select = $("#files");
        let htmlMarkup = "";
        htmlMarkup += '<option value="" selected>Choose</option>'
        $.each(globalDirList[key], function (index, item) {
            htmlMarkup += '<option  value="' + item + '">' + item + '</option>'
        });
        select.html(htmlMarkup);
    });


    function showDirectory() {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'GET',
                url: '/vbo/api/showDirectory',
                data: {},
                success: function (data) {
                    resolve(data);
                }
            });
        });
    }



    $(document).on("click", "#load-data", function () {

        let dir = $("#directory option:selected").val()
        let file = $("#files option:selected").val()
        let isError = false;

        if(!dir){
            $("#directory").parent().find(".invalid-feedback").html("This cannot be empty.")
            $("#directory").parent().find(".invalid-feedback").show()
            isError= true;
        }else{
            $("#directory").parent().find(".invalid-feedback").html("")
            $("#directory").parent().find(".invalid-feedback").hide()
        }

        if(!file){
            $("#files").parent().find(".invalid-feedback").html("This cannot be empty.")
            $("#files").parent().find(".invalid-feedback").show()
            isError= true;
        }else{
            $("#files").parent().find(".invalid-feedback").html("")
            $("#files").parent().find(".invalid-feedback").hide()
        }
        if(isError){
            return false;
        }
        loadData($(this))
    });

    async function loadData(that){
        that.attr("disabled",true);
        let spinner = ''
        spinner +=' <span id="spinner-container">'
        spinner += '<span  class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
        spinner += '</span>'
        that.append(spinner)
        await loadXmlData()
        that.find("#spinner-container").remove();
        that.removeDataArr("disabled");
    }

    function loadXmlData() {
        let dir = $("#directory option:selected").val()
        let file = $("#files option:selected").val()
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'GET',
                url: '/vbo/api/loadXmlData',
                data: {
                    dir: dir, file: file
                },
                success: function (data) {
                    resolve(data);
                }
            });
        });
    }



</script>
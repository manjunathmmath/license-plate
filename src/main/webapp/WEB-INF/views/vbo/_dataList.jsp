<div id="bag-object-table-container" style="display: none;">
    <table id="bag-object-table" class="table table-striped table-bordered dt-responsive nowrap"
           style="width: 100%;">
        <thead>
        <tr>
            <th>ID</th>
            <th>IDENTIFICATIE</th>
            <th>FILE</th>
            <th>FOLDER</th>
        </tr>
        </thead>

    </table>
</div>

<script type="text/javascript">
    function geAllBagObjects() {
        let dir = $("#directory option:selected").val()
        let file = $("#files option:selected").val()
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'GET',
                url: '/pnd/api/geAllBagObjects',
                data: {
                    dir: dir, file: file
                },
                success: function (data) {
                    resolve(data);
                }
            });
        });
    }

    $(document).on("click", "#show-data", function () {
        generateStockDataTable()
    });

    let bagObjectTable = null

    async function generateStockDataTable() {
        let data = await geAllBagObjects();
        $("#bag-object-table-container").show()
        bagObjectTable = $('#bag-object-table').DataTable({
            "processing": true,
            "order": [[0, "asc"]],
            "pageLength": 100,
            "bPaginate": true,
            "data": data.data,
            "bDestroy": true,
            "scrollX": true,
            "columnDefs": [
                {
                    "targets": [],
                    "visible": false,
                    "searchable": false
                }
            ],
            "columns": [
                {"data": 'ID'},
                {"data": 'IDENTIFICATIE'},
                {"data": 'FILE'},
                {"data": 'FOLDER'},
            ],
            "fnInitComplete": function (oSettings, json) {
            }
        });
    }

</script>
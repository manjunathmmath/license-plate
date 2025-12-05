<div id="bag-object-table-container" style="display: none;">
    <table id="bag-object-table" class="table table-striped table-bordered dt-responsive nowrap"
           style="width: 100%;">
        <thead>
        <tr>
            <th>ID</th>
            <th>FILE</th>
            <th>FOLDER</th>
            <th>IDENTIFICATIE</th>
            <th>GECONSTATEERD</th>
            <th>DOCUMENTDATUM</th>
            <th>DOCUMENTNUMMER</th>
            <th>OORSPRONKELIJK_BOUWJAAR</th>
            <th>BEGIN_GELDIGHEID</th>
            <th>TIJDSTIP_REGISTRATIE</th>
            <th>TIJDSTIP_REGISTRATIELV</th>
            <th>VOORKOMENIDENTIFICATIE</th>
            <th>STATUS</th>
            <th>POST_LIST</th>
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
            scrollY: '500px',
            scrollCollapse: true,
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
                {"data": 'FILE'},
                {"data": 'FOLDER'},
                {"data": 'IDENTIFICATIE'},
                {"data": 'GECONSTATEERD'},
                {"data": 'DOCUMENTDATUM'},
                {"data": 'DOCUMENTNUMMER'},
                {"data": 'OORSPRONKELIJK_BOUWJAAR'},
                {"data": 'BEGIN_GELDIGHEID'},
                {"data": 'TIJDSTIP_REGISTRATIE'},
                {"data": 'TIJDSTIP_REGISTRATIELV'},
                {"data": 'VOORKOMENIDENTIFICATIE'},
                {"data": 'STATUS'},
                {"data": 'POST_LIST'},
            ],
            "fnInitComplete": function (oSettings, json) {
            }
        });
    }

</script>
<div id="bag-object-table-container" style="display: none;">
    <table id="bag-object-table" class="table table-striped table-bordered dt-responsive nowrap"
           style="width: 100%;">
        <thead>
        <tr>
            <th>ID</th>
            <th>FILE</th>
            <th>FOLDER</th>
            <th>IDENTIFICATIE</th>
            <th>GEBRUIKSDOEL</th>
            <th>GECONSTATEERD</th>
            <th>DOCUMENTDATUM</th>
            <th>DOCUMENTNUMMER</th>
            <th>POST_LIST</th>
            <th>STATUS</th>
            <th>BEGIN_GELDIGHEID</th>
            <th>EIND_GELDIGHEID</th>
            <th>EIND_REGISTRATIE</th>
            <th>TIJDSTIP_EIND_REGISTRATIELV</th>
            <th>TIJDSTIP_REGISTRATIE</th>
            <th>TIJDSTIP_REGISTRATIELV</th>
            <th>VOORKOMENIDENTIFICATIE</th>
            <th>NUMMERAANDUIDING_REF</th>
            <th>PAND_REF</th>
            <th>OPPERVLAKTE</th>
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
                url: '/vbo/api/geAllBagObjects',
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
        showData($(this))
    });

    async function showData(that){
        that.attr("disabled",true);
        let spinner = ''
        spinner +=' <span id="spinner-container">'
        spinner += '<span  class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>';
        spinner += '</span>'
        that.append(spinner)
        await generateStockDataTable()
        that.find("#spinner-container").remove();
        that.removeAttr("disabled");
    }

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
                {"data": 'GEBRUIKSDOEL'},
                {"data": 'GECONSTATEERD'},
                {"data": 'DOCUMENTDATUM'},
                {"data": 'DOCUMENTNUMMER'},
                {"data": 'POST_LIST'},
                {"data": 'STATUS'},
                {"data": 'BEGIN_GELDIGHEID'},
                {"data": 'EIND_GELDIGHEID'},
                {"data": 'EIND_REGISTRATIE'},
                {"data": 'TIJDSTIP_EIND_REGISTRATIELV'},
                {"data": 'TIJDSTIP_REGISTRATIE'},
                {"data": 'TIJDSTIP_REGISTRATIELV'},
                {"data": 'VOORKOMENIDENTIFICATIE'},
                {"data": 'NUMMERAANDUIDING_REF'},
                {"data": 'PAND_REF'},
                {"data": 'OPPERVLAKTE'},
            ],
            "fnInitComplete": function (oSettings, json) {
            }
        });
    }

</script>
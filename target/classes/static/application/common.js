function getKiteInstrumentsBySegment(segment) {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: 'getKiteInstrumentsBySegment',
            data: {
                segment: segment,
            },
            success: function (data) {
                resolve(data);
            }
        });
    });
}

function getSegments() {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: 'getSegments',
            data: {},
            success: function (data) {
                resolve(data);
            }
        });
    });
}

function getAllSubscriptionTokenBySegment(segment) {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: 'getAllSubscriptionTokenBySegment',
            data: {
                segment: segment,
            },
            success: function (data) {
                resolve(data);
            }
        });
    });
}

function getAllStockStrikeIntervals(monthType) {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: 'getAllStockStrikeIntervals',
            data: {
                monthType: monthType,
            },
            success: function (data) {
                resolve(data);
            }
        });
    });
}


function findAllByInstrumentTokenIn(tokens) {
    if (tokens) {
        tokens = JSON.stringify(tokens);
    }
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'POST',
            url: 'findAllByInstrumentTokenIn',
            data: {
                tokens: tokens,
            },
            success: function (data) {
                resolve(data);
            }
        });
    });
}

let indexStrikeInterval = {
    'NIFTY 50': '50,50',
    'NIFTY MID SELECT': '25,25',
    'NIFTY FIN SERVICE': '50,50',
    'NIFTY BANK': '100,100',
    'BANKEX': '100,100',
    'SENSEX': '100,100',
    'GIFT NIFTY': '50,50',
}

function getStrikeDetails(open, interval) {
    let strikeOne = parseInt(interval[0])
    let strikeTwo = parseInt(interval[1])

    let ustrikeOne = (parseFloat(open) + strikeOne);
    let ustrikeTwo = (ustrikeOne + strikeTwo);
    let bstrikeOne = (parseFloat(open) - strikeOne);
    let bstrikeTwo = (bstrikeOne - strikeTwo);

    let map = {}
    map['bstrikeOne'] = parseFloat(bstrikeOne).toFixed(2);
    map['bstrikeTwo'] = parseFloat(bstrikeTwo).toFixed(2);
    map['ustrikeOne'] = parseFloat(ustrikeOne).toFixed(2);
    map['ustrikeTwo'] = parseFloat(ustrikeTwo).toFixed(2);
    return map;
}

async function saveVixQuote() {
    if (!localStorage.getItem("VIX_QUOTE")) {
        let res = await getHistoricalData($("#PREVIOUS_TRADING_DAY").val(), $("#PREVIOUS_TRADING_DAY").val(), 264969, 'day');
        localStorage.setItem("VIX_QUOTE", JSON.stringify(res));
    }
}

function getVixRange(prevQuoteData, prevVixData) {

    var vixMM = calculateVixRange("MONTHLY", prevQuoteData, prevVixData)
    var vixWW = calculateVixRange("WEEKLY", prevQuoteData, prevVixData)
    var vixDD = calculateVixRange("DAILY", prevQuoteData, prevVixData)

    let d = {}
    d.vixMMRange = vixMM.range;
    d.vixMMLower = vixMM.lNift;
    d.vixMMUpper = vixMM.uNift;

    d.vixWWRange = vixWW.range;
    d.vixWWLower = vixWW.lNift;
    d.vixWWUpper = vixWW.uNift;

    d.vixDDRange = vixDD.range;
    d.vixDDLower = vixDD.lNift;
    d.vixDDUpper = vixDD.uNift;

    return d;

}

function calculateVixRange(type, prevQuoteData, prevVixData) {
    var data = {}
    var prevData = prevQuoteData
    var previousClose = prevVixData
    var chg;
    if (type == "DAILY") {
        chg = parseFloat(previousClose) / Math.sqrt(365 - 104 - 15)
    }
    if (type == "MONTHLY") {
        chg = parseFloat(previousClose) / Math.sqrt(12)
    }
    if (type == "WEEKLY") {
        chg = parseFloat(previousClose) / Math.sqrt(52)
    }

    var range = parseFloat(prevData) * chg / 100
    var lNift = parseFloat(prevData) - range
    var uNift = parseFloat(prevData) + range

    data['chg'] = chg.toFixed(2)
    data['range'] = range.toFixed(2)
    data['lNift'] = lNift.toFixed(2)
    data['uNift'] = uNift.toFixed(2)
    return data;
}

function date_time(id) {
    $("#" + id).html(moment(new Date()).format('MMMM dddd YYYY, hh:mm:ss A'));
    setTimeout('date_time("' + id + '");', '1000');
    return true;
}

$(document).ready(function () {
    date_time("current-date-time")
});
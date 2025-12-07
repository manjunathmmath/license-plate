function showLoading() {
    let html = ''
    html += '<div id="loading-container" class="d-flex justify-content-center">'
    html += '<div class="spinner-border" role="status">'
    html += '<span class="visually-hidden">Loading...</span>'
    html += '</div>'
    html += '</div>'
    $('body').append(html)
}

function removeLoading(){
    $('body').find("#loading-container").remove()
}
toastr.options = {
    closeButton: true,
    debug: false,
    progressBar: false,
    positionClass: "toast-top-center",
    onclick: null,
    showDuration: "300",
    hideDuration: "1000",
    timeOut: "5000",
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut"
}

$('#search-btn').click(function () {
    var search = $('#search');
    if (search.val().length < 1 || search.val() == " ") {
        toastr.warning('请输入关键字');
        return false;
    } else {
        $('.from-inline').submit();
    }
});


$('#go').click(function () {
    var search = $('#search-1');

    if (search.val().length < 1 || search.val() == " ") {
        toastr.warning('请输入数据');
        return false;
    } else {
        $('#search-form').submit();
    }
});


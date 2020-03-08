
var lastUpdate = $("#lastUpdate");
var runTime = $("#RunTime");
var date = new Date();

lastUpdate.html(date.toLocaleDateString());

// 初始化弹框元素
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

/*多彩tag*/
var tags_a = $("#tags").find("a");

tags_a.each(function () {
    var x = 9;
    var y = 0;
    var rand = parseInt(Math.random() * (x - y + 1) + y);
    $(this).addClass("size" + rand);
});

setInterval(function () {
    runTime.html(setTime());
}, 1000);


$('#exit').click(function () {
    console.log('退出');
    $.ajax({
        url: '/api/exit/userExit',
        type: 'GET',
        dataType: 'json',
        success: function () {
            window.location.reload();
        }
    })
})


function setTime() {
    var d = new Date(), str = '';
    BirthDay = new Date("January 01,2020");
    today = new Date();
    timeold = (today.getTime() - BirthDay.getTime());
    sectimeold = timeold / 1000
    secondsold = Math.floor(sectimeold);
    msPerDay = 24 * 60 * 60 * 1000
    msPerYear = 365 * 24 * 60 * 60 * 1000
    e_daysold = timeold / msPerDay
    e_yearsold = timeold / msPerYear
    daysold = Math.floor(e_daysold);
    yearsold = Math.floor(e_yearsold);
    //str = yearsold + "年";
    str += daysold + "天";
    str += d.getHours() + '时';
    str += d.getMinutes() + '分';
    str += d.getSeconds() + '秒';
    return str;
}

function hidErweima(erweima) {
    $(erweima).attr("data-hidden", "false");
}
$("#gotop1,#gotop2").click(function(e) {
    TweenMax.to(window, 1.5, {scrollTo:0, ease: Expo.easeInOut});
    var huojian = new TimelineLite();
    huojian.to("#gotop1", 1, {rotationY:720, scale:0.6, y:"+=40", ease:  Power4.easeOut})
        .to("#gotop1", 1, {y:-1000, opacity:0, ease:  Power4.easeOut}, 0.6)
        .to("#gotop1", 1, {y:0, rotationY:0, opacity:1, scale:1, ease: Expo.easeOut, clearProps: "all"}, "1.4");
});

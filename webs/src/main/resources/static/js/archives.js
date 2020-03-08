$('label').click(function () {

    $('.event_year>li').removeClass('current');
    $(this).parent('li').addClass('current');
    var year = $(this).attr('for');
    $('#' + year).parent().prevAll('div').slideUp(800);
    $('#' + year).parent().slideDown(800).nextAll('div').slideDown(800);
});
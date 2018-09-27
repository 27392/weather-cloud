$(function () {
    $("#selectCityId").change(function(){
        var cityId = $(this).val();
        var url = '/report/cityId/' + cityId;
        window.location.href = url;
    })
})
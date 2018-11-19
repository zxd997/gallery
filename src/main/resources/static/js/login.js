$("form button:submit").click(function () {
    $.ajax({
        type: 'POST',
        dataType:'json',
        data:$("form input:not(:eq(2))").serializeArray(),
        url:'/login',
        success:function (data) {
            console.log(data.code);
            if (data.code==200){
                window.location.href="/upload";
            }else {
                alert(data.msg);
                window.location.href="/789";
            }
        },
        error:function (data) {
            console.log('/login');
            console.log(data);
        }
    })
    return false
})






$('#btn_dangki').click(function (e) {

    var username = $("#txt_username").val();
    var email = $("#txt_email").val();
    var password = $("#txt_password").val();

    var flag = false;

    if (username == '') {
        $('#error_username').text("Bạn chưa nhập tên tài khoản.")
    }
    if (password == '') {
        $('#error_password').text("Bạn chưa nhập password.")
    }

    if (email == '') {
        $('#error_email').text("Bạn chưa nhập email.")
    }
    
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    if (emailReg.test(email) == false) {
        $('#error_email').text("Email không hợp lệ")
    }


    if (username != '' && email != '' && password != '' && emailReg.test(email) == true) {
        flag = true
    }

    if (!flag) {
        alert("Vui lòng kiểm tra lại")
        return false;
    } else {
        $('#error_username').text("")
        $('#error_password').text("")
        $('#error_email').text("")
        $("#thanhcong_username").text("Tên Đăng nhập: " + username)
        $("#thanhcong_email").text("Email: " + email)
        $("#thanhcong_password").text("Password: " + password)
        $("#thongbao_thanhcong").css('display', 'block')
    }

})
$('#btn_dangnhap').click(function (e) {
    
    var email = $("#txt_email").val();
    var password = $("#txt_password").val();

    var flag = false;

    
    if (password == '') {
        $('#error_password').text("Bạn chưa nhập password.")
    }

    if (email == '') {
        $('#error_email').text("Bạn chưa nhập email.")
    }
    
    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    if (emailReg.test(email) == false) {
        $('#error_email').text("Email không hợp lệ")
    }


    if (email != '' && password != '' && emailReg.test(email) == true) {
        flag = true
    }

    if (!flag) {
        alert("Vui lòng kiểm tra lại")
        return false;
    } else {
        
        $('#error_password').text("")
        $('#error_email').text("")
        
    }

})
$('#btn_dathang').click(function (e) {
    
    var phone = $("#txt_phone").val();
    var address = $("#txt_address").val();

    var flag = false;

    
    if (phone == '') {
        $('#error_phone').text("Bạn chưa nhập số điện thoại.")
    }

    if (address == '') {
        $('#error_address').text("Bạn chưa nhập địa chỉ.")
    }
    if (address != '' && phone != '') {
        flag = true
    }

    if (!flag) {
        $("#thongbao_loi").css('display', 'block')
      
        return false;
    } else {
        $('#error_phone').text("")
        $('#error_address').text("")      
    }

})
    
   


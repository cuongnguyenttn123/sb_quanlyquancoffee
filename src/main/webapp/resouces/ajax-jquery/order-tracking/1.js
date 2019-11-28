jQuery(document).ready(function($) {
    var value = $('#valueid').val();

    if(value ==='XN'){
        $('#progressbar_2').addClass('active');
    }
    if(value ==='CTT'){
        $('#progressbar_2').addClass('active');
        $('#progressbar_3').addClass('active');
    }
    if(value ==='DTT'){
        $('#progressbar_2').addClass('active');
        $('#progressbar_3').addClass('active');
        $('#progressbar_4').addClass('active');

    }
        
});
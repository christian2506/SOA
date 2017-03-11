$(document).ready(function(){
    $("#add-user").click(function(e){
        e.preventDefault();
        $(".fondo").show();
        $("#register-client").show();
        $("#register-activity").show();
        $(document).keyup(function(e){
            if(e.which == 27){
               $("#register-client").hide();
               $("#register-activity").hide();
               $(".fondo").hide(); 
            }
        });
    });
    
    $('select.dropdown')
        .dropdown()
    ;
});
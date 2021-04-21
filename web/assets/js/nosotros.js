window.addEventListener("load",function(){

    var hover_nav_principal = $(".items");
    var letras = $(".items>a");
    var redes  = $(".items_redes>a");
    hover_nav_principal.hover(realizarcambio,devolvercambio);
    letras.hover(realizarcambioletras,devolvercambioletras);
    redes.hover(cambiocolorredes,devolvercolorredes);

    function realizarcambioletras(){
        $(this).css("color","#FF5733")
    }
    function devolvercambioletras(){
        $(this).css("color","black")
    }
    function cambiocolorredes(){
        $(this).css("color","#FF5733")
    }
    function devolvercolorredes(){
        $(this).css("color","#fff");
    }


    function realizarcambio(){
        $(this).css("color","#FF5733")
        .css("border-bottom","2px solid #7216af")
    }
    function devolvercambio(){
        $(this).css("color","black")
        .css("border-bottom","none")
    }
    // Nav Responsive
    var sliderResponsive = $(".hamburguesa");
    var contenedor_responsive =$("#contenedor_principal_responsive");

    contenedor_responsive.hide();
    sliderResponsive.click(function(){
        contenedor_responsive.slideToggle("fast")
    })
})
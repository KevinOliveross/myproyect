window.addEventListener("load",function(){
    // Evento para utilizar el hover en el nav principal
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




    /*var hover_nav_secundario = $(".hiper2")
    hover_nav_secundario.hover(cambiacolors2,cambiacolores2);

    function cambiacolors2(){
        $(this).css("color","#FF5733")
        .css("text-decoration","none");
    }
    function cambiacolores2(){
        $(this).css("color","#fff")
    }*/

    botones_divs = $(".botones");
    botones_divs.hover(colorbotones,coloresbotones);
    function colorbotones(){
        var short_this = $(this);
        short_this.css("background","#FF5733");
    }
    function coloresbotones(){
        var short_this = $(this);
        short_this.css("background","transparent");
    }
})

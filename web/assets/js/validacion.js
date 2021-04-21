function validacion() {
    var nombre,contraseña;
    nombre=document.getElementById("user").value;
    contraseña=document.getElementById("pasw").value;

    if(nombre.length>30 || contraseña.length>50){

        alert("Cantidad maxima de caracteres");
        return false;
    }
   
}
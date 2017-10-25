var tablero = new Array();
var filas;
var columnas;

window.onload = function(){
    var tabla = document.getElementById("tablero");
    var filasTabla = tabla.getElementsByTagName("tr");
    var celdas = tabla.getElementsByTagName("td");

    filas = filasTabla.length;
    columnas = filasTabla.length;

    for(i in celdas){
        celdas[i].onclick = comprobarCasilla;
    }

    for(var i=0;i<filasTabla.length;i++){
        tablero[i] = [0,0,0,0,0];
    }

    for(var i = 1; i < 5; i++){
        colocarBarco(i);
    }

    console.log(tablero);
}

function comprobarCasilla(){
    var filaColumna = this.getAttribute("name").split("_");
    var f = filaColumna[0];
    var c = filaColumna[1];

    if(tablero[f][c]>0){
        this.style.backgroundColor = "red";
    }else{
        this.style.backgroundColor = "blue";
    }

    this.onclick = null;
}

function colocarBarco(dimensionBarco){
    var barcoColocado = false;
    do{
        var orientacion = Math.floor(Math.random() * 2);
        var pInicialFila = Math.floor(Math.random() * filas);
        var pInicialColumna = Math.floor(Math.random() * columnas);

        if(orientacion == 0){
            //horizontal
            console.log("(fila:"+pInicialFila+",columna:"+pInicialColumna+")");
            if(tablero[pInicialFila][pInicialColumna] > 0){
                console.log("aqui ya hay un barco (fila:"+pInicialFila+",columna:"+pInicialColumna+")");
            }else{
                console.log("Punto inicial + dimension: "+(pInicialColumna+dimensionBarco));
                if(pInicialColumna+dimensionBarco <= columnas){
                    console.log("cabe");
                    var entraBarco = true;
                    for(var i=0;i<dimensionBarco;i++){
                        if(tablero[pInicialFila][pInicialColumna+i]>0){
                            entraBarco = false;
                            console.log("el barco pisaria otro barco");
                        }
                    }

                    if(entraBarco){
                        console.log("el barco esta listo para ponerse (horizontal)");
                        for(var i=0;i<dimensionBarco;i++){
                            tablero[pInicialFila][pInicialColumna+i] = dimensionBarco;
                        }
                        barcoColocado = true;
                    }

                }else{
                    console.log("no cabe");
                }
            }
            
        }else{
            //vertical
            console.log("(fila:"+pInicialFila+",columna:"+pInicialColumna+")");
            if(tablero[pInicialFila][pInicialColumna] > 0){
                console.log("aqui ya hay un barco (fila:"+pInicialFila+",columna:"+pInicialColumna+")");
            }else{
                console.log("Punto inicial + dimension: "+(pInicialFila+dimensionBarco));
                if(pInicialFila+dimensionBarco <= filas){
                    console.log("cabe");
                    var entraBarco = true;
                    for(var i=0;i<dimensionBarco;i++){
                        if(tablero[pInicialFila+i][pInicialColumna]>0){
                            entraBarco = false;
                            console.log("el barco pisaria otro barco");
                        }
                    }

                    if(entraBarco){
                        console.log("el barco esta listo para ponerse (vertical)");
                        for(var i=0;i<dimensionBarco;i++){
                            tablero[pInicialFila+i][pInicialColumna] = dimensionBarco;
                        }
                        barcoColocado = true;
                    }

                }else{
                    console.log("no cabe");
                }
            }
        }
    }while(!barcoColocado);
}
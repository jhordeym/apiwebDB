function exibeNome(){
    var elNome = document.getElementById('txtNome');
    var strNome = elNome.value;
    var elDisplay = document.getElementById("display");
    elDisplay.innerText = strNome;
    
   
    console.log(strNome);
}

function novoContato() {
    var elListaContatos = document.getElementById("listaContatos");
    var inputContato = document.createElement("input");
   
    var labelContato = document.createElement("label");
    labelContato.innerText="Contato:";

    var br = document.createElement("br");
    
    var btnExc = document.createElement("input");
    btnExc.setAttribute("type", "button");
    btnExc.setAttribute("value", "-");
    btnExc.onclick=function() {
        elListaContatos.removeChild(divLinha);
     };

    var divLinha = document.createElement("div");

    divLinha.appendChild(labelContato);
    divLinha.appendChild(inputContato);
    divLinha.appendChild(btnExc);
    divLinha.appendChild(br);

    elListaContatos.appendChild(divLinha);
}
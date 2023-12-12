function cargarCSS(archivo) {
    var link = document.createElement("link");
    link.setAttribute("rel", "stylesheet");
    link.setAttribute("type", "text/css");
    link.setAttribute("href", archivo);
    document.head.appendChild(link);
}

var carpetaCSS = '/CSS/';
var archivosCSS = ['index.css', 'header.css','footer.css','main.css'];

archivosCSS.forEach(function (file) {
    cargarCSS(carpetaCSS + file);
});

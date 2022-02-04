function download() {
	var url = document.getElementById("scaricaButton").value;
	FileSaver.saveAs(url, "image.jpg");
}
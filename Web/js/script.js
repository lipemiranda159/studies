/*var resposta = confirm("teste");
console.log(resposta);
var a = 10;
var b = 5;
alert(a+b);
*/
function soma(a, b){
	return a + b;
}

console.log(soma(10,5));

document.getElementById("btn-calcular").onclick = function () 
{
	var valorA = document.getElementById("valorA").value;
	var valorB = document.getElementById("valorB").value;
	alert(parseInt(valorA)+parseInt(valorB));
}
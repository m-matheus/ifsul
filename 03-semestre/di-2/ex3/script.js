const numero = prompt("Digite um número de 1 a 6: ");
const sorteio = Math.floor((Math.random() * 6) + 1);
if(numero == sorteio) {
    alert("Você ganhou 3 mil reais no tigrinho!!!!!!");
}
else {
    alert(`Você errou. Tente novamente até você falir! O número correto é: ${sorteio}`);
}
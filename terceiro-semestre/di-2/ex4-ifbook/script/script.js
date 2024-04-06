// criando um evento que espera o documento estar carregado para executar a funcao (que basicamente é todo o codigo)
document.addEventListener("DOMContentLoaded", function () {
  // criando uma const e colocando o nome de todas as pessoas
  const pessoas =
    "Amanda de Oliveira, Bruna Freitas da Motta, Bruna Rafaela Böch, Diego Dexheimer Wiebbelling, Diogo Ramos, Eduardo Rigon, Guilherme Antonio da Rosa Bertoli, Guilherme Tamara Xavier, João Pedro Marques de Souza, Lucca Steinmetz Lazzari, Matheus de Moraes, Michelle Gonçalves de Oliveira, Nicoly da Silva Ribeiro, Rafael Ramos Garcia";
  // transformando as pessoas em uma lista de pessoas
  const listaPessoas = pessoas.split(", ");
  // criando uma array vazia para armazenar os amigos que o usuario vai aceitar
  const amigos = [];
  // contador de amigo para colocar o numero do inicio da tabela e também colocarmos a foto da respectiva pessoa
  let friendCounter = 0;
  // criando uma funcao de acição de amigos
  function addNewFriend(name) {
    // usando queryselector para selecionar a classe table (que esta na nossa tabela)
    const table = document.querySelector(".table");
    // criando uma const para inserir linhas na tabela
    const newRow = table.insertRow();
    // adicionando o nosso contador 
    
    // adicionando no html uma linha na tabela com os dados desejados
    newRow.innerHTML = `  
        <tr>
          <th scope="row">${friendCounter}</th>
          <td><img src="image/${friendCounter}.jpeg" alt=""></td>
          <td>${name}</td>
          <td>${new Date}</td>
        <tr>
          `;
  }
  // percorrendo a lista de amigos e realizando a pergunta se é ou não amigo
  for (let i = 0; i < listaPessoas.length; i++) {
    const confirma = confirm(`Você é amigo(a) do(a) ${listaPessoas[i]}?`);
    friendCounter++;
    if (confirma) {
      // se sim, adiciona na lista de amigos e chama a funcao de adicao
      amigos.push(listaPessoas[i]);
      addNewFriend(listaPessoas[i]);
    }
  }

    
});

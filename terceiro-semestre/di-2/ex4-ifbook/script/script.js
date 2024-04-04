document.addEventListener("DOMContentLoaded", function () {
  const pessoas =
    "Amanda de Oliveira, Bruna Freitas da Motta, Bruna Rafaela Böch, Diego Dexheimer Wiebbelling, Diogo Ramos, Eduardo Rigon, Guilherme Antonio da Rosa Bertoli, Guilherme Tamara Xavier, João Pedro Marques de Souza, Lucca Steinmetz Lazzari, Matheus de Moraes, Michelle Gonçalves de Oliveira, Nicoly da Silva Ribeiro, Rafael Ramos Garcia";

  const listaPessoas = pessoas.split(", ");
  const amigos = [];
  let friendCounter = 0;
  function addNewFriend(name) {
    const table = document.querySelector(".table");
    const newRow = table.insertRow();
    friendCounter++;
    newRow.innerHTML = `  
        <tr>
          <th scope="row">${friendCounter}</th>
          <td><img src="image/${friendCounter}.jpeg" alt=""></td>
          <td>${name}</td>
          <td>${new Date}</td>
        <tr>
          `;
  }

  for (let i = 0; i < listaPessoas.length; i++) {
    const confirma = confirm(`Você é amigo(a) do(a) ${listaPessoas[i]}?`);
    if (confirma) {
      amigos.push(listaPessoas[i]);
      addNewFriend(listaPessoas[i]);
    }
  }

    
});

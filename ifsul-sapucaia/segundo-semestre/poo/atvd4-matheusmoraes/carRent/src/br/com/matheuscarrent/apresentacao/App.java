package br.com.matheuscarrent.apresentacao;

import java.util.List;
import java.util.Scanner;

import br.com.matheuscarrent.model.Usuario;
import br.com.matheuscarrent.model.Veiculo;
import br.com.matheuscarrent.persistencia.UsuarioDAO;
import br.com.matheuscarrent.persistencia.VeiculoDAO;

public class App {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        boolean running = true;
        do {
            System.out.println();
            System.out.println("1 - Cadastrar novo usuário");
            System.out.println("2 - Login");
            int option = kb.nextInt();
            Usuario u = null;
            Veiculo v = null;
            UsuarioDAO uDAO;
            VeiculoDAO vDAO;
            switch (option) {
                case 1:
                    u = new Usuario();
                    System.out.println();
                    System.out.println("Digite seu nome: ");
                    u.setNome(kb.next());
                    System.out.println("Digite seu email: ");
                    u.setEmail(kb.next());
                    System.out.println("Digite sua senha: ");
                    u.setSenha(kb.next());
                    uDAO = new UsuarioDAO();
                    uDAO.salvar(u);
                    break;

                case 2:
                    u = new Usuario();
                    System.out.println();
                    System.out.println("Digite seu email: ");
                    u.setEmail(kb.next());
                    System.out.println("Digite sua senha: ");
                    u.setSenha(kb.next());
                    System.out.println();
                    uDAO = new UsuarioDAO();
                    Usuario usuarioLogado = uDAO.fazerLogin(u.getEmail(), u.getSenha());
                    if (usuarioLogado != null) {
                        // O login foi bem-sucedido
                        System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioLogado.getNome());
                        System.out.println();
                        do {
                            option = 0;
                            System.out.println("1 - Cadastrar novo veiculo");
                            System.out.println("2 - Visualizar meus veiculos cadastrados");
                            System.out.println("3 - Alugar um veiculo");
                            System.out.println("4 - Visualizar todos veiculos registrados");
                            
                            option = kb.nextInt();
                            switch (option) {
                                case 1:
                                    // Cadastra o veiculo
                                    v = new Veiculo();
                                    
                                    // Associa o ID do usuário logado ao veículo
                                    v.setProprietario(usuarioLogado);
                                    System.out.println();
                                    System.out.println("Digite a placa do seu veiculo: ");
                                    v.setPlaca(kb.next());
                                    System.out.println("Digite o modelo do veiculo: ");
                                    v.setModelo(kb.next());
                                    System.out.println("Digite a cor do veiculo: ");
                                    v.setCor(kb.next());
                                    System.out.println("Digite o ano do veiculo: ");
                                    v.setAno(kb.nextInt());
                                    System.out.println("Digite o valor para aluguel do veiculo: ");
                                    v.setPreco(kb.nextDouble());
                                    System.out.println();

                                    vDAO = new VeiculoDAO();
                                    vDAO.cadastrarVeiculo(v);
                                    System.out.println("Veiculo cadastrado com sucesso!");
                                    System.out.println();
                                    break;
                                case 2:
                                    // Lista veiculos do usuario
                                    vDAO = new VeiculoDAO();
                                    List<Veiculo> veiculosUsuario = vDAO.buscarVeiculosUsuario(usuarioLogado.getId());
                                    if (!veiculosUsuario.isEmpty()) {
                                        System.out.println();
                                        System.out.println("Veículos cadastrados:");
                                        for (Veiculo veiculo : veiculosUsuario) {
                                            System.out.println("ID: " + veiculo.getId());
                                            System.out.println("Placa: " + veiculo.getPlaca());
                                            System.out.println("Modelo: " + veiculo.getModelo());
                                            System.out.println("Cor: " + veiculo.getCor());
                                            System.out.println("Ano: " + veiculo.getAno());
                                            System.out.println("Preço: " + veiculo.getPreco());
                                            System.out.println("Status: " + veiculo.getStatus());
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("Nenhum veículo cadastrado.");
                                    }
                                    break;
                                case 3:
                                    // Lista todos veiculos do banco e seleciona um veiculo para alugar
                                    vDAO = new VeiculoDAO();
                                    List<Veiculo> veiculos = vDAO.buscarTodosVeiculos();

                                    if (!veiculos.isEmpty()) {
                                        System.out.println();
                                        System.out.println("Veículos disponíveis para alugar:");
                                        for (Veiculo veiculo : veiculos) {
                                            System.out.println("ID: " + veiculo.getId());
                                            System.out.println("Placa: " + veiculo.getPlaca());
                                            System.out.println("Modelo: " + veiculo.getModelo());
                                            System.out.println("Cor: " + veiculo.getCor());
                                            System.out.println("Ano: " + veiculo.getAno());
                                            System.out.println("Preço: " + veiculo.getPreco());
                                            System.out.println("Status: " + veiculo.getStatus());
                                            System.out.println();
                                        }
                                        int e;
                                        System.out.println("Deseja alugar algum veiculo?");
                                        System.out.println("1 - Sim");
                                        System.out.println("2 - Não");
                                        e = kb.nextInt();

                                        switch (e) {
                                            case 1:
                                                System.out.println("Digite o ID do veículo que deseja alugar: ");
                                        long idVeiculoSelecionado = kb.nextLong();

                                        Veiculo veiculoSelecionado = null;
                                        for (Veiculo veiculo : veiculos) {
                                            if (veiculo.getId() == idVeiculoSelecionado) {
                                                veiculoSelecionado = veiculo;
                                                break;
                                            }
                                        }

                                        if (veiculoSelecionado != null) {

                                            System.out.println("Você selecionou o veículo:");
                                            System.out.println("ID: " + veiculoSelecionado.getId());
                                            System.out.println("Placa: " + veiculoSelecionado.getPlaca());
                                            System.out.println("Modelo: " + veiculoSelecionado.getModelo());
                                            System.out.println("Cor: " + veiculoSelecionado.getCor());
                                            System.out.println("Ano: " + veiculoSelecionado.getAno());
                                            System.out.println("Preço: " + veiculoSelecionado.getPreco());
                                            System.out.println("Status: " + veiculoSelecionado.getStatus());
                                            System.out.println();

                                            veiculoSelecionado.setStatus("Reservado");
                                            vDAO.editarVeiculo(veiculoSelecionado);
                                            System.out.println("Veículo alugado com sucesso!");
                                        } else {
                                            System.out.println("Veículo não encontrado.");
                                        }
                                                break;
                                            case 2:
                                            break;
                                            
                                            default:
                                                break;
                                        }
                                        
                                    } else {
                                        System.out.println("Nenhum veículo disponível para alugar.");
                                    }
                                    break;
                                case 4:
                                // Mostra todos veiculos registrados
                                vDAO = new VeiculoDAO();
                                List<Veiculo> veiculosGeral = vDAO.buscarTodosVeiculos();

                                if (!veiculosGeral.isEmpty()) {
                                    System.out.println("Veículos: ");
                                    System.out.println();
                                    for (Veiculo veiculo : veiculosGeral) {
                                        System.out.println("ID: " + veiculo.getId());
                                        System.out.println("Placa: " + veiculo.getPlaca());
                                        System.out.println("Modelo: " + veiculo.getModelo());
                                        System.out.println("Cor: " + veiculo.getCor());
                                        System.out.println("Ano: " + veiculo.getAno());
                                        System.out.println("Preço: " + veiculo.getPreco());
                                        System.out.println("Status: " + veiculo.getStatus());
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Nenhum veiculo registrado.");
                                }
                                    break;
                                default:
                                    break;
                            }
                        } while (usuarioLogado != null);
                    } else {
                        // O login falhou
                        System.out.println("Login falhou. Verifique suas credenciais.");
                    }
                default:
                    break;
            }
        } while (running == true);
        kb.close();

    }
}

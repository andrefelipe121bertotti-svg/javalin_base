package br.edu.ifpr.pgua.eic.tads.models;
import java.util.ArrayList;

import br.edu.ifpr.pgua.eic.tads.models.entities.Funcionario;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;

public class Restaurante {
    
    
    private ArrayList<Usuario> usuarios;

    private ArrayList<Funcionario> funcionarios;

    public Restaurante(){
        usuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }


    public Usuario buscarCpf(String cpf){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getCpf().equals(cpf)){
                return usuarios.get(i);
                
            }
        }
        return null;
    }

    public Usuario buscarEmail(String email){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getEmail().equals(email)){
                return usuarios.get(i);
            }
        }
        return null;
    }

    public boolean cadastrarUsuario(String nome, String email, 
                                    String telefone, String cpf){
        
        if((buscarCpf(cpf)==null) && (buscarEmail(email)==null)){
            Usuario u = new Usuario(cpf, nome, email, telefone, 0.0);
            usuarios.add(u);
            return true;
        }
        return false;
        
    }

    public Funcionario buscarFuncionarioCpf(String cpf){
        for(Funcionario f:funcionarios){
            if(f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }


    public String cadastrarFuncionario(String nome, String email, String cpf,
                                       double salario, String cargo, String turno
    ){

        if(buscarFuncionarioCpf(cpf) == null){
            Funcionario f = new Funcionario(nome, email, cpf,salario, cargo, turno);
            funcionarios.add(f);
            return "Funcionário cadastrado!";
        }
        return "Funcionário não cadastrado!";
    }

    public String listarFuncionarios(){
        String texto = "";

        for(Funcionario f:funcionarios){
            texto += f.toString()+"\n";
        }
        return texto;
    }


    public String depositar(String cpf, double valor){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        if(valor <= 0){
            return "Valor inválido!";
        }

        if(usuario.inserirCredito(valor)){
            return "Depósito realizado!";
        }else{
            return "Valor inválido!";
        }
    }

    public String consumir(String cpf, double valor){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        if(valor <= 0){
            return "Valor inválido!";
        }

        if(usuario.consumirRefeicao(valor)){
            return "Depósito realizado!";
        }else{
            return "Valor inválido!";
        }
    }

    public String gerarExtrato(String cpf){
        Usuario usuario = buscarCpf(cpf);
        if(usuario == null){
            return "Usuário não encontrado!";
        }
        return usuario.gerarExtrato();
    }


    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public String listar(){

        String texto="Usuários Cadastrados\n";

        for(int i=0;i<usuarios.size();i++){
            texto += usuarios.get(i).toString()+"\n";
            
            
        }
        return texto;

    }


}

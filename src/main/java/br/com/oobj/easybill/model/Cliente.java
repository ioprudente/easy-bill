package br.com.oobj.easybill.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private static String nome;

    @Column(length = 11)
    @NotBlank
    private static String cpf;

    @NotBlank
    private static String email;

    @Column
    @NotBlank
    private static String rua;

    @Column(length = 11)
    @NotBlank
    private static String numero;

    @Column
    @NotNull
    private static String complemento;

    @Column
    @NotBlank
    private static String bairro;

    @Column
    @NotBlank
    private static String cidade;

    @Column
    @NotBlank
    private static String estado;


    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Cliente.nome = nome;
    }

    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        Cliente.cpf = cpf;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Cliente.email = email;
    }

    public static String getRua() {
        return rua;
    }

    public static void setRua(String rua) {
        Cliente.rua = rua;
    }

    public static String getNumero() {
        return numero;
    }

    public static void setNumero(String numero) {
        Cliente.numero = numero;
    }

    public static String getComplemento() {
        return complemento;
    }

    public static void setComplemento(String complemento) {
        Cliente.complemento = complemento;
    }

    public static String getBairro() {
        return bairro;
    }

    public static void setBairro(String bairro) {
        Cliente.bairro = bairro;
    }

    public static String getCidade() {
        return cidade;
    }

    public static void setCidade(String cidade) {
        Cliente.cidade = cidade;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        Cliente.estado = estado;
    }

    public Cliente toCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setNumero(numero);
        cliente.setCidade(cidade);
        cliente.setComplemento(complemento);
        cliente.setEstado(estado);
        cliente.setCidade(cidade);

        return cliente;
    }
}


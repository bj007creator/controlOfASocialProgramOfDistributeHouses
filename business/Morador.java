package business;

import util.*;
import java.text.NumberFormat;

public class Morador{
   private Cpf cpf;
   private String nome;
   private int qtdeDependentes;
   private float rendaFamiliar;
   private Telefone telefone;
   private String endereco;
   
   public Morador(Cpf cpf, String nome, int qtdeDeDependentes, float rendaFamiliar, Telefone telefone, String endereco){
      this.cpf = cpf;
      this.nome = nome;
      this.setQtdeDependentes(qtdeDeDependentes);
      this.setRendaFamiliar(rendaFamiliar);
      this.telefone = telefone;
      this.endereco = endereco;
   }
   public Cpf getCpf(){
      return this.cpf;
   }
   public String getNome(){
      return this.nome;
   }
   public int getQtdeDependentes(){
      return this.qtdeDependentes;
   }
   public float getRendaFamiliar(){
      return this.rendaFamiliar;
   }
   public Telefone getTelefone(){
      return this.telefone;
   }
   public String getEndereco(){
      return this.endereco;
   }
   
   public void setQtdeDependentes(int qtdeDependentes){
      while(qtdeDependentes < 0){
         System.out.print(Leitor.ERRO);
         qtdeDependentes = Leitor.readQtdeDependentes();
      }
      this.qtdeDependentes = qtdeDependentes;
   }
   public void setRendaFamiliar(float rendaFamiliar){
      while(rendaFamiliar < 0){
         System.out.print(Leitor.ERRO);
         rendaFamiliar = Leitor.readRendaFamiliar();
      }
      this.rendaFamiliar = rendaFamiliar;
   }
   
   public String nomeECpf(){
      return "CPF : " + this.cpf + "\n" +
             "nome : " + this.nome;
   }
   
   @Override
   public String toString(){
      return "CPF : " + this.cpf + "\n" + 
             "Nome : " + this.nome + "\n" +
             "Quantidade de dependentes : " + this.qtdeDependentes + "\n" +
             "Renda Familiar : " + NumberFormat.getCurrencyInstance().format(this.rendaFamiliar) + "\n" + 
             "Telefone : " + this.telefone + "\n" + 
             "Endereço : " + this.endereco;
   }
}
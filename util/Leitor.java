package util;

import java.util.Scanner;

public class Leitor{
   private static final Scanner LEITOR = new Scanner(System.in);
   public static final String ERRO = "Erro valor inválido !!!"; 
   
   public static int readQtdeDependentes(){
      System.out.print("Digite a quantidade de dependentes que dependem deste morador : ");
      int saida = LEITOR.nextInt();
      LEITOR.nextLine();
      return saida;
   }
   public static float readRendaFamiliar(){
      System.out.print("Digite a renda familiar deste morador : ");
      float saida = LEITOR.nextFloat();
      LEITOR.nextLine();
      return saida;
   }
   public static String readCpf() {
    	System.out.print("Digite o cpf do morador no modelo 000.000.000-00 : ");
      return LEITOR.nextLine();
    }
    
    public static String readNumeroTel(){
      System.out.print("Digite um número de telefone para o morador ex 0000-0000 : ");
      return LEITOR.nextLine();
    }
    public static int readDdd(){
      System.out.print("Digite o DDD do número de telefone celular do morador : ");
      int saida = LEITOR.nextInt();
      LEITOR.nextLine();
      return saida;
    }
    public static String readNome(){
      System.out.print("Digite o nome do morador : ");
      return LEITOR.nextLine();
    }
    public static String readEndereco(){
      System.out.print("Digite um endereço para este morador : ");
      return LEITOR.nextLine();
    }
    public static int readParametro(String parametro){
      System.out.print("Digite um valor para a quantidade máxima de moradores na " + parametro + " : ");
      int saida = LEITOR.nextInt();
      LEITOR.nextLine();
      return saida;
    }
}

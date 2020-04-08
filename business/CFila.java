package business;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.util.Random;
/**
 * @(#)CFila.java
 *
 *
 * @author Rodrigo Richard Gomes 
 * @version 1.00 2018/3/16
 */

public class CFila {
   private CCelula frente; // Celula cabeca.
   private CCelula tras; // Ultima celula.
   private int qtde;
   
   // Funcao construtora. Cria a celula cabeca e faz as referencias frente e tras apontarem para ela.
   public CFila() {
      frente = new CCelula();
      tras = frente;
   }

   // Verifica se a fila esta vazia. Retorna TRUE se a fila estiver vazia e FALSE caso contrario.
   public boolean vazia() {
      return frente == tras;
   }

   public void mostra(String titulo) {
      String saida = "";
      for (CCelula c = frente.prox; c != null; c = c.prox)
         saida += c.item + " \n\n ";
      
      JTextArea textArea = new JTextArea(40, 70);
      textArea.setText(saida + "\n");
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);

   }

   // Insere um novo Item no fim da fila.
   // O parametro "valorItem" e um Object contendo o elemento a ser inserido no final da fila.
   public void enfileira(Object valorItem) {
      tras.prox = new CCelula(valorItem);
      tras = tras.prox;
      qtde++;
   }
   
   public static CFila ConcatenaFila(CFila f1, CFila f2){
      CFila auxF1maisF2 = new CFila();
      CFila auxF1 = new CFila();
      CFila auxF2 = new CFila();
      
      Object retorno;
      do{
         retorno = f1.desenfileira();
         if(retorno != null){
            auxF1.enfileira(retorno);
            auxF1maisF2.enfileira(retorno);
         }
      }while(retorno != null);
      do{
         retorno = f2.desenfileira();
         if(retorno != null){
            auxF2.enfileira(retorno);
            auxF1maisF2.enfileira(retorno);
         }
      }while(retorno != null);
      //restaurar valores
      
      for(retorno = auxF1.desenfileira(); retorno != null; retorno = auxF1.desenfileira())
         f1.enfileira(retorno);
      for(retorno = auxF2.desenfileira(); retorno != null; retorno = auxF2.desenfileira())
         f2.enfileira(retorno);
      return auxF1maisF2;
   }

   // Retira e retorna o primeiro elemento da fila.
   // Retorna um Object contendo o primeiro elemento da fila. Caso a fila esteja vazia retorna null.
   public Object desenfileira()
   {
      Object item = null;
      if (frente != tras) {
         frente = frente.prox;
         item = frente.item;
         qtde--;
      }
      return item;
   }
   
   /*public static CFila inverte(CFila fila){
      CPilha pilha = new CPilha();
      for(Object aux = fila.desenfileira(); aux != null; aux = fila.desenfileira())
         pilha.empilha(aux);
      for(Object aux = pilha.desempilha(); aux != null; aux = pilha.desempilha())
         fila.enfileira(aux);
      return fila;
   }*/
   
   public static CFila criaCrescente(int n){
      CFila fila = new CFila();
      for(int i = 0; i < n; i++)
         fila.enfileira(i);
      return fila;
   }
   
   /*public static CFila criaDecrescente(int n){
      CFila fila = new CFila();
      for(int i = 0; i < n; i++)
         fila.enfileira(i);
      return CFila.inverte(fila);
   }*/
   public static CFila criaAleatoriamente(int n){
      CFila fila = new CFila();
      Random randomico = new Random();
      for(int i = 0; i < n; i++)
         fila.enfileira(randomico.nextInt(100));
      return fila;
   }
   //Cria fila personalizada 
   /*public static CFila criaCFila(int opcao, int n){
      if(opcao > 2 || opcao < 0)
         return null;
      return (opcao == 0) ? criaCrescente(n) : (opcao == 1) ? criaDecrescente(n) : criaAleatoriamente(n);
   }
   */
   public static void imprimeCFila(CFila F){
      int i = 1;
      for (CCelula c = F.frente.prox; c != null; c = c.prox, i++){
         if(i % 10 == 0)
            System.out.println(c.item);
         else
            System.out.print(c.item + "|");
      }
   }

   // Retorna o primeiro Item da fila sem remove-lo.
   // Retorna um Object contendo o primeiro Item da fila.
   public Object peek() {
      if (frente != tras)
         return frente.prox.item;
      else
         return null;
   }
   
   public void limpa(){
      this.frente.prox = null;
      this.tras = frente;
   }
   public void furaFila(Object item){
      frente.prox = (tras != frente) ? new CCelula(item, frente.prox) : new CCelula(item);
      if(frente.prox.prox == null)
         tras = frente.prox;
      qtde++;
   }
   
   public static void furaFila(CFila F, Object item){
      F.frente.prox = (F.tras != F.frente) ? new CCelula(item, F.frente.prox) : new CCelula(item);
      if(F.frente.prox.prox == null)
         F.tras = F.frente.prox;
      F.qtde++;
   }
   
   public static int somaElementos(CFila F){
      int soma = 0;
      for(CCelula c = F.frente.prox; c != null; c = c.prox)
          soma += (int) c.item;
      return soma;
   }
   public static int quantPositivos(CFila F){
      int quant = 0;
      for(CCelula c = F.frente.prox; c != null; c = c.prox)
         quant = ((int) c.item > 0) ? quant + 1 : quant;
      return quant;
   }

   // Verifica se o Item passado como parametro esta contido na fila.
   // O parametro "valorItem" e um object contendo o Item a ser localizado.
   // O metodo retorna TRUE caso o item esteja presente na fila.
   public boolean contem(Object valorItem) {
      boolean achou = false;
      CCelula aux = frente.prox;
      while (aux != null && !achou) {
         achou = aux.item.equals(valorItem);
         aux = aux.prox;
      }
      return achou;
   }

   // Verifica se o Item passado como parametro esta contido na fila. (Obs: usa o comando FOR)
   // Recebe como parametro um object contendo o Item a ser localizado.
   // Retorna TRUE caso o Item esteja presente na fila.
   public boolean contemFor(Object valorItem) {
      boolean achou = false;
      for (CCelula aux = frente.prox; aux != null && !achou; aux = aux.prox)
         achou = aux.item.equals(valorItem);
      return achou;
   }

   // Metodo que retorna a quantidade de itens da fila.
   public int quantidade() {
      return qtde;
   }

}
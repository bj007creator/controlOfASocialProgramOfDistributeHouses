package business;

import util.Leitor;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class CDicionario{
   private CCelulaDicionario primeira, ultima;
   private int qtde;
   
   public CDicionario(){
      this.primeira = new CCelulaDicionario();
      this.ultima = this.primeira;
   }
   public boolean vazio(){
      return this.primeira == this.ultima;   
   }
   public void adiciona(Object chave, Object valor){
      boolean finded = false;
      for(CCelulaDicionario aux = this.primeira.prox; !finded && aux != null; aux = aux.prox){
         if(aux.key.equals(chave))
            finded = true;
      }
      if(!finded){
         this.ultima.prox = new CCelulaDicionario(chave, valor);
         this.ultima = this.ultima.prox;
         this.qtde++;
      }
   }
   
   public Object recebeValor(Object chave){
      Object item = null;
      boolean finded = false;
      for(CCelulaDicionario aux = this.primeira.prox; !finded && aux != null; aux = aux.prox){
         if(aux.key.equals(chave)){
            item = aux.value;
            finded = true;
         }
      }
      return item;
   }
   
   public void showDic(String titulo){
      String saida = "";
      for(CCelulaDicionario aux = this.primeira.prox; aux != null; aux = aux.prox){
         saida += aux + "\n\n";
      }
      JTextArea textArea = new JTextArea(40, 70);
      textArea.setText(saida + "\n");
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
   }
   // Metodo que retorna a quantidade de itens do Dicionario.
   public int quantidade() {
      return qtde;
   }
}

package business;

public class CCelulaDicionario{
   //Atributos
   public Object key, value;
   public CCelulaDicionario prox;
   
   public CCelulaDicionario(){
      this.key = null;
      this.value = null;
      this.prox = null;
   }
   public CCelulaDicionario(Object chave, Object valor){
      this.key = chave;
      this.value = valor;
      this.prox = null;
   }
   
   public CCelulaDicionario(Object chave, Object valor, CCelulaDicionario proxima){
      this.key = chave;
      this.value = valor;
      this.prox = proxima;
   }
   
   @Override
   public String toString(){
      return "Key : " + this.key.toString() + " | " + "Value : " + this.value.toString();
   }
}
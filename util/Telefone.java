package util;

public class Telefone{
   private int ddd;
   private String numero;
   
   public Telefone(int ddd, String numero){
      this.setDdd(ddd);
      this.setNumero(numero);
   }
   
   public void setDdd(int ddd){
      while(ddd < 0){
         System.out.println(Leitor.ERRO);
         ddd = Leitor.readDdd();
      }
      this.ddd = ddd;
   }
   public void setNumero(String numero){
      while((numero.toCharArray()).length != 9 || !this.eNumeroValido(numero)){
         System.out.println(Leitor.ERRO);
         numero = Leitor.readNumeroTel();
      }
      this.numero = numero;
   }
   public static boolean eNumeroValido(String numero) {
    	char[] array = numero.toCharArray();
    	boolean eValido = true;
		for(int i = 0; i < array.length; i++) {
			if(i != 4) {
				if( !Character.isDigit(array[i]) )
					eValido = false;
			}
		}
		return eValido;
    }
    
    @Override
    public String toString(){
      return "("+ this.ddd + ") " + "9" + this.numero; 
    }
}
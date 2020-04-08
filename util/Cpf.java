package util;

public class Cpf{
   private String cpf;
   
   public Cpf(String cpf){
      this.setCpf(cpf);
   }
   
   public void setCpf(String cpf) {
		while( !(  eCpfOutrosCaracteresValidos(cpf) && cpf.length() == 14 && eCpfNumericamenteValido(cpf)  ) ) {
         System.out.println(Leitor.ERRO);
			cpf = Leitor.readCpf();
		}
		this.cpf = cpf;
	}
    
    public static boolean eCpfNumericamenteValido(String cpf) {
    	char[] array = cpf.toCharArray();
    	boolean eValido = true;
		for(int i = 0; i < 14; i++) {
			if(i != 7 && i != 3 && i != 11) {
				if( !Character.isDigit(array[i]) ) {
					eValido = false;
				}
			}
		}
		return eValido;
    }
    public static boolean eCpfOutrosCaracteresValidos(String cpf) {
    	char [] arrayCpf = cpf.toCharArray();
    	if( ".".equals(String.valueOf(arrayCpf[3])) && 
    		".".equals(String.valueOf(arrayCpf[7])) &&
    		"-".equals(String.valueOf(arrayCpf[11]))) {
    		return true;
    	}
    	return false;
    }

   @Override
   public String toString(){
      return this.cpf;
   }
}
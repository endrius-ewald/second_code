/*APLICATIVO PRINCIPAL
 * 
 */




public class TRABALHO2{
  public static void main (String args[]){
    //Criando Algumas Variaveis
    
    int PosicaoNave = 38; // 1 a 80 (38meio)
    int te = 1;
    int tirT = 2;
    System.out.println(SpaceInvaders.getBoardHeight());
    
    //Inicia aplicação
    SpaceInvaders.init();
    
    
    //Cria Vetor Tiro
    Tiro [] tir = new Tiro [10];
    //Inicializa Vetor Tiro
    for(int Ind1 = 0 ; Ind1 < 10 ; Ind1++){
      tir[Ind1] = new Tiro();
    }

    //Cria Vetor Inimigo
    Inimigo [] enem = new Inimigo [4];
    //Inicializa Vetor Inimigo
    for(int Ind1 = 0 ; Ind1 < 4 ; Ind1++){
      enem[Ind1] = new Inimigo();
    }
    
    //public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT)
    SpaceInvaders.desenha(enem,te,tir,tirT);
    SpaceInvaders.setPlataforma(PosicaoNave);
    
    
    while (true){
      //BLOCO ATIRAR
      if (SpaceInvaders.apertouEspaco()){
        //ATIRA
        System.out.println("Espaço");
      }
      //SpaceInvaders.desenha(0,0,0,0);
    }
  }
  
   /* ////////////////////////////////
    * ///#####//#####//#####//#####///
    * /////#//////#////#///#//#///#///
    * /////#//////#////#/##///#///#///
    * /////#//////#////#//#///#///#///
    * /////#////#####//#///#//#####///
    * ////////////////////////////////
    */
  
  public static class Tiro {
    public int x;
    public int y;
    public int speed;
  }
  
  /*
   * ///////////////////////////////////////////////////////////
   * ///#####//##///#//#####//##////##//#####//######///#####///
   * /////#////#/#//#////#////#/#//#/#////#////#////////#///#///
   * /////#////#//#/#////#////#//##//#////#////#//###///#///#///
   * /////#////#//#/#////#////#//////#////#////#////#///#///#///
   * ///#####//#///##//#####//#//////#//#####//######///#####///
   * ///////////////////////////////////////////////////////////
   */
  
  public static class Inimigo {
    
    public int x;
    public int y;
    public int vida;
    
  }
  
}
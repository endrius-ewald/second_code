/*APLICATIVO PRINCIPAL
 * 
 */




public class TRABALHO2{
  public static void main (String args[]){
    //Criando Algumas Variaveis
    
    int PosicaoNave = 38; // 1 a 80 (38meio)
    int te = 4; //quantidade de elementos no vetor de inimigos enem  
    int tirT = 10; //quantidade de elementos no vetor de tiros tir
    int tiroquevaiatirar = 0;
    
    
    //Inicia aplicação
    SpaceInvaders.init();
    
    
    //Cria Vetor Tiro
    Tiro [] tir = new Tiro [10];
    //Inicializa Vetor Tiro
    for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
      tir[Ind1] = null;
    }
    
    
    
    
    //Cria Vetor Inimigo
    Inimigo [] enem = new Inimigo [4];
    //Inicializa Vetor Inimigo
    for(int Ind1 = 0 ; Ind1 < 4 ; Ind1++){
      enem[Ind1] = new Inimigo();
    }
    
    enem[0].x = 1;
    enem[0].y = 1;
    enem[1].x = 20;
    enem[1].y = 1;
    enem[2].x = 40;
    enem[2].y = 1;
    enem[2].vida = 15;
    enem[3].x = 60;
    enem[3].y = 1;
    //public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT)
    SpaceInvaders.desenha(enem,te,tir,tirT);
    SpaceInvaders.setPlataforma(PosicaoNave);
    
    //RODA O JOGO
    while (true){
      
      //ATIRA      
      if (SpaceInvaders.apertouEspaco()){
        System.out.println("Espaço");
        //Verifica se o tiro existe
        for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
          if (tir[Ind1] == null){
            tiroquevaiatirar = Ind1;
            Ind1 = 9;
          }
        }
        
        tir[tiroquevaiatirar] = new Tiro();
        tir[tiroquevaiatirar].y = 76;
        tir[tiroquevaiatirar].x = PosicaoNave + 1;
        tir[tiroquevaiatirar].speed = 3;
        
      }
      
      //MOVE NAVE PARA ESQUERDA
      if (SpaceInvaders.apertouEsquerda()){
        if (PosicaoNave > 1){
          PosicaoNave--;
          SpaceInvaders.setPlataforma(PosicaoNave);
        }
      }
      
      //MOVE NAVE PARA ESQUERDA
      if (SpaceInvaders.apertouDireita()){
        if (PosicaoNave < 75){
          PosicaoNave++;
          SpaceInvaders.setPlataforma(PosicaoNave);
        }
      }
      
      //MOVE TIRO
      for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
        if (tir[Ind1] != null){//ignora se tiro nao existe
          if (tir[Ind1].y >= 0){ //move a bala se estiver na tela
            tir[Ind1].y = tir[Ind1].y - 1;// - tir[Ind1].speed;
            tir[Ind1].speed = tir[Ind1].speed;//acelera a bala
          }else{ //destroi a bala se sair da tela 
            tir[Ind1] = null;
          }
          
          //Acerta alvo
          //NAO ME LEMBRO PQ FIZ FORA DO IF DE CIMA, MAS ACHO QUE TEM UM MOTIVO
          if (tir[Ind1] != null){//ignora se tiro nao existe
            for(int Ind2 = 0 ; Ind2 < enem.length ; Ind2++){
              if (enem[Ind2] != null){
                if (tir[Ind1] != null){
                  if (tir[Ind1].x >= enem[Ind2].x -1  && tir[Ind1].x <= enem[Ind2].x + 9){//verifica o x
                    if (tir[Ind1].y >= enem[Ind2].y   && tir[Ind1].y <= enem[Ind2].y + 6){//verifica o y
                      enem[Ind2].vida--;//se acertou retira vida
                      tir[Ind1] = null;//se acertou destroi tiro
                      if (enem[Ind2].vida <= 0){//verifica vidas
                        enem[Ind2] = null;//se nao tem vidas destroi inimigo
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      
      
      
      //ATUALIZA O FRAME
      //public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT)
      SpaceInvaders.desenha(enem,te,tir,tirT);
    }
  }
  
  
  
}
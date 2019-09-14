/*APLICATIVO PRINCIPAL
 *Por : Endrius Ewald
 *Data:04/07
 *SPACE INVADERS: PROTEJA SUA NAVE CONTRA OS ALIENS INIMIGOS!
 * 
 * Nota: Usar Inimigo.java editado
 *       Usar SpaceInvaders.java editado
 */
import java.util.*;


public class TRABALHO2{
  public static void main (String args[]){
    
    //VARIAVEIS USADAS
    int PosicaoNave = 38; // 1 a 80 (38meio)
    int te = 4; //quantidade de elementos no vetor de inimigos enem  
    int tirT = 10; //quantidade de elementos no vetor de tiros tir
    boolean jogando = true; //Variavel que finaliza o jogo
    int inimigosmortos = 0; //numero de inimigos mortos
    int tirosdisparados = 0; // numero de tiros ativos
    int tiroquevaiatirar = 0; //vetor do tiro que sera disparado
    
    

    System.out.println("-Inimigos se aproximando Senhor!");
    System.out.println("-SOEM O ALARME!!!");
    System.out.println("-ASSUMAM POSTOS DE BATALHA!");
    System.out.println("-LEVANTEM OS ESCUDOS");
    System.out.println("-CARREGUEM OS PHASERS");
    System.out.println("-ATIRADOR ESTAMOS EM SUAS MÃOS");
    System.out.println("...............................................................................................");
    System.out.println("...............................................................................................");
    System.out.println("...............................................................................................");
    System.out.println("...............................................................................................");
    
    //CRIA VETOR TIRO
    Tiro [] tir = new Tiro [10];
    //INICIALIZA VETOR TIRO
    for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
      tir[Ind1] = null;
    }
    
    
    
    
    //CRIA VETOR INIMIGO
    Inimigo [] enem = new Inimigo [4];
    
    //INICIALIZA VETOR INIMIGO
    Random r = new Random();//Cria numero random para posicionar inimigos aleatoriamente
    for(int Ind1 = 0 ; Ind1 < 4 ; Ind1++){
      enem[Ind1] = new Inimigo();
      enem[Ind1].y = 1;//inicia inimigos no topo da tela
      enem[Ind1].vida = 15;//inicia vida dos inimigos em 15
      enem[Ind1].x = Math.abs((r.nextInt()%(70)));
      if (Ind1 == 2){//Cria o boss com vida 40
        enem[Ind1].vida = 40;
      }
    }
    
    //INCIA APLICACAO
    SpaceInvaders.init();
    
    //public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT)
    SpaceInvaders.desenha(enem,te,tir,tirT);
    SpaceInvaders.setPlataforma(PosicaoNave);
    
    //RODA O JOGO
    while (jogando){     
      //ATIRA      
      if (SpaceInvaders.apertouEspaco()){
        if (tirosdisparados < 10){
          //Verifica se o tiro existe
          for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
            if (tir[Ind1] == null){
              tiroquevaiatirar = Ind1;
              tirosdisparados++;
              Ind1 = 9; //finaliza for()
            }
          }
          //POSICIONA TIRO
          tir[tiroquevaiatirar] = new Tiro();
          tir[tiroquevaiatirar].y = 76;
          tir[tiroquevaiatirar].x = PosicaoNave + 1;
          tir[tiroquevaiatirar].speed = 3;
        }else{
          System.out.println("RECARREGAR!!!!");
        }
      }
      
      //MOVE NAVE PARA ESQUERDA
      if (SpaceInvaders.apertouEsquerda()){
        if (PosicaoNave > 1){
          PosicaoNave--;
          SpaceInvaders.setPlataforma(PosicaoNave);
          if (PosicaoNave%10 == 0){
            System.out.println("VIRANDO BOMBORDO!");
          }
        }
      }
      
      //MOVE NAVE PARA ESQUERDA
      if (SpaceInvaders.apertouDireita()){
        if (PosicaoNave < 75){
          PosicaoNave++;
          SpaceInvaders.setPlataforma(PosicaoNave);
          if (PosicaoNave%10 == 0){
            System.out.println("VIRANDO ESTEBORDO!");
          }
        }
      }
      
      //MOVE TIRO
      for(int Ind1 = 0 ; Ind1 < tir.length ; Ind1++){
        if (tir[Ind1] != null){//ignora se tiro nao existe
          if (tir[Ind1].y >= 0){ //move a bala se estiver na tela
            tir[Ind1].y = tir[Ind1].y - tir[Ind1].speed;
            tir[Ind1].speed = tir[Ind1].speed + 1;//acelera a bala
            for(int Ind2 = 0 ; Ind2 < enem.length ; Ind2++){
              if (enem[Ind2] != null){
                if (tir[Ind1] != null){
                  if (tir[Ind1].x >= enem[Ind2].x -1  && tir[Ind1].x <= enem[Ind2].x + 9){//verifica o x
                    if (tir[Ind1].y >= enem[Ind2].y   && tir[Ind1].y <= enem[Ind2].y + 6){//verifica o y
                      enem[Ind2].vida--;//se acertou retira vida
                      tir[Ind1] = null;//se acertou destroi tiro
                      tirosdisparados--;
                      if (enem[Ind2].vida <= 0){//verifica vidas
                        enem[Ind2] = null;//se nao tem vidas destroi inimigo
                        inimigosmortos++;
                        System.out.println("PEGUEI UM!");
                      }
                    }
                  }
                }
              }
            }
          }else{ //destroi a bala se sair da tela 
            tir[Ind1] = null;
            tirosdisparados--;
          }
        }
      }
      
      //DESLOCAMENTO LATERAL
      for(int Ind1 = 0 ; Ind1 < 4 ; Ind1++){
        if (enem[Ind1] != null){
          if (enem[Ind1].lado){
            enem[Ind1].x = enem[Ind1].x + Math.abs((r.nextInt()%(5)));
          }else{
            enem[Ind1].x = enem[Ind1].x - Math.abs((r.nextInt()%(5)));
          }
          if (enem[Ind1].x > 70){
            enem[Ind1].lado = false;
          }else if (enem[Ind1].x < 5){
            enem[Ind1].lado = true;
          }
        }
      }
      
      /*//DESLOCAMENTO VERTICAL
       for(int Ind1 = 0 ; Ind1 < 4 ; Ind1++){
       if (enem[Ind1] != null){
       enem[Ind1].y + tempojogo;
       }
       }
       
       //PERDER JOGO
       * if (tempojogo > 70){
       *   SpaceInvaders.gameOver();
       *   jogando = false;
       * }
       * 
       */
      
      //VENCER JOGO
      if (inimigosmortos >= 4){
        SpaceInvaders.ganhou();
        System.out.println("BOM TRABALHO ALMIRANTE");
      }
      
      //ATUALIZA O FRAME
      //public static void desenha(Inimigo [] enem, int te, Tiro [] tir, int tirT)
      SpaceInvaders.desenha(enem,te,tir,tirT);
    }
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj2011.QR.A;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import static java.lang.Math.*;


/**
 * 
 * @author lorocod
 *
 */
public class BotTrust {
    
    final static String WORK_DIR = "./";
    public int actua_O=0;
    public int actua_B=0;
    public int total_pasos=0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
       
        Scanner sc = new Scanner(new FileReader(WORK_DIR + "input-small.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR + "output.txt"));
//        
//        Scanner in = sc;
//        int T = in.nextInt();
//		for(int zz = 1; zz <= T;zz++){
//			int N = in.nextInt();
//			int bat = 1;
//			int oat = 1;
//			int btime = 0;
//			int otime = 0;
//			for(int i = 0; i < N;i++){
//				if(in.next().equals("B")){
//					int next = in.nextInt();
//					btime = max(btime+abs(bat-next), otime)+1;
//					bat = next;
//				}else{
//					int next = in.nextInt();
//					otime = max(otime+abs(oat-next), btime)+1;
//					oat = next;
//				}
//			}
//			System.out.format("Case #%d: %d\n", zz, max(btime, otime));
//		}        
//        
//       return ; 
        
        
        
        
        
        int tt = sc.nextInt();
        sc.nextLine();
        
        BotTrust BT= new BotTrust();
        for(int t = 0;t<tt;t++){
            String datos = sc.nextLine();
             
            String resp =  "Case #"+(t+1)+": "+ BT.resolver(datos);
            
            pw.println(resp);
            System.out.println(resp);
        }
        pw.flush();
        pw.close();
        sc.close();
    }
    
    public int resolver(String datos){
        
        Scanner sc = new Scanner(datos).useDelimiter(" ");
        System.out.println("Datos: "+datos);
        int cant= sc.nextInt();
        char robot[] = new char[cant+1];
        int boton[] = new int[cant+1];
        
        for(int i = 0;i<cant;i++){
           robot[i]= sc.next().charAt(0);
           boton[i]= sc.nextInt();
//           System.out.println(robot[i]);      
//           System.out.println(boton[i]);                  
        }
        int ultimo = 0,count_O=0,count_B=0;
        int pos, bonus_O=0, bonus_B=0;
//        for( pos = 0;pos<cant;pos++){
//            
//            if(robot[pos]=='O')count_O++;
//            if(robot[pos]=='B')count_B++;
//            System.out.println("robot: "+robot[pos]+" ultimo: "+robot[ultimo]+" pos: "+pos + " count_O: "+count_O+" count_B: "+count_B);
//            if((count_B>=2) && (count_O >=2)){
//                System.out.println("entro");
//                int bonus = cuentapasos(Arrays.copyOfRange(robot, ultimo, pos), Arrays.copyOfRange(boton, ultimo, pos), bonus_O, bonus_B);
//                bonus_O=0; bonus_B=0;
//                if(bonus>0)bonus_O = bonus;
//                else bonus_B = bonus;                
//                ultimo = pos;
//            }
//        }
        Contador c = new Contador();
//        int pos_a=0,pos_b=0;    
        int final_O =0, final_B=0;
        int totalPasos=0;
        actua_O = 1;
        actua_B = 1;
        for( pos = 0;pos<cant;pos++){
            
            final_O = (robot[pos]== 'O' ? boton[pos] : actua_O);
            final_B= (robot[pos]== 'B' ? boton[pos] : actua_B);                    
            c = cantPasosEntrePos(actua_O,  actua_B,final_O, final_B ,c.bonus_O, c.bonus_B);
            totalPasos+= c.pasos;
            System.out.println("pos: "+pos + " pasos devueltos: "+ c.pasos);
        }
            
        
        return totalPasos;
    }
    
    //cuenta los pasos en una secuencia, de muchos botones O y 1 boton B, o vicebersa.
    //devuelve posito para bonus de Orange, y negativos para bonus de Blue
    public int cuentapasos(char robot[], int boton[],int bonus_O, int bonus_B){
            System.out.println("array robot: " + robot.length + " array boton: " + boton.length + " bonus Orange: "+bonus_O + " bonus Blue: "+ bonus_B);
            int pasos_a ;
            int pasos_b;
        return 1;
    }
    
    //cuenta los pasos necesarios para llegar hasta un punto
    //devuelve posito para bonus de Orange, y negativos para bonus de Blue
    public Contador cantPasosEntrePos(int init_O, int init_B,int final_O, int final_B ,int bonus_O, int bonus_B){
            System.out.println("init_O: " + init_O + " init_B: " + init_B + " final_O: "+ final_O + " final_B: " + final_B+ " bonus_O: "+bonus_O + " bonus_B: "+ bonus_B);
            Contador c = new Contador();
            
            int pasos_O = Math.abs(final_O - init_O);
            int pasos_B = Math.abs(final_B - init_B);
            
            if(pasos_O == 0 && pasos_B==0)return Contador.crear(1, bonus_O, bonus_B);
            // se va a mover uno solo
            if(pasos_O>0){ // se mueve O                
                pasos_O++;  //+1 apretar boton
                c.pasos = pasos_O;
                if(bonus_O>0){
                    // en este caso da 0 pasos y se resta bonus
                    if(pasos_O < bonus_O){
                        c.pasos =0;
                        c.bonus_O = bonus_O - pasos_O;
                    }
                    if(pasos_O >= bonus_O){
                        c.pasos = pasos_O - bonus_O;
                        c.bonus_O = 0;
                        c.bonus_B = c.pasos; //se da bonus EN B a la diferencia entre pasos y el bonus
                    }                                     
                }else{
                    c.bonus_B = bonus_B + c.pasos; // le da bonus al otro. se incrementa bonus B
                }

            }
            if(pasos_B!=0){ // se mueve B
                pasos_B++;
                c.pasos = pasos_B;
                if(bonus_B>0){
                   if(pasos_B < bonus_B){
                        c.pasos =0;
                        c.bonus_B = bonus_B - pasos_B;
                    }
                    if(pasos_B >= bonus_B){
                        c.pasos = pasos_B - bonus_B;
                        c.bonus_B = 0;
                        c.bonus_O = c.pasos; //se da bonus EN O a la diferencia entre pasos y el bonus
                    }                                                                    
                }else{
                    c.bonus_O = bonus_O + c.pasos;
                }                
            }
                        
            
//            c.pasos =  Math.max(pasos_B,pasos_O);                        
//            c.bonus_B = bonus_B + pasos_O - pasos_B; // se incrementa bonus de B
//            c.bonus_O = bonus_O + pasos_B - pasos_O;
//            if(c.bonus_B<0)c.bonus_B =0;
//            if(c.bonus_O<0)c.bonus_O =0;
            
            
//            if(pasos_B>0 && bonus_B >0){
//                pasos_B =pasos_B - bonus_B;
//            }
//            if(pasos_O>0 && bonus_O >0){
//                pasos_O =pasos_O - bonus_O;
//            }
            
            
            actua_B = final_B;
            actua_O = final_O;
            
        return c;
    }    
    
}

class Contador{
    int bonus_O=0;
    int bonus_B=0;
    int pasos;

    public static Contador crear(int pasos,int bonus_O,int bonus_B){
        Contador c = new Contador();
        c.bonus_B = bonus_B;
        c.bonus_O = bonus_O;
        c.pasos = pasos;
        return c;
        
    }
        
}
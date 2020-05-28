
package excecao1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entites.DominioExcecao;
import model.entites.Reserva;

public class Program {

    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Número do quarto: ");
            int numQuarto = sc.nextInt();
            System.out.print("Data de check-in (DD/MM/YYYY) : ");
            Date dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (DD/MM/YYYY) : ");
            Date dataCheckOut = sdf.parse(sc.next());
            Reserva r = new Reserva(numQuarto, dataCheckIn, dataCheckOut);
            System.out.println(r.toString());

            System.out.println("Informe os dados para atualizar a reserva: ");
            System.out.print("Data de check-in (DD/MM/YYYY) : ");
            dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (DD/MM/YYYY) : ");
            dataCheckOut = sdf.parse(sc.next());

            r.atualizacaoReserva(dataCheckIn, dataCheckOut);
            System.out.println(r.toString());
            sc.close();
        } catch (ParseException e){
            System.out.println("Data Inválida");
        }catch (DominioExcecao e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        
    }
    
}

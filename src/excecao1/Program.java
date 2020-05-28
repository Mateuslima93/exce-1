
package excecao1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entites.Reserva;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Número do quarto: ");
        int numQuarto = sc.nextInt();
        System.out.print("Data de check-in (DD/MM/YYYY) : ");
        Date dataCheckIn = sdf.parse(sc.next());
        System.out.print("Data de check-out (DD/MM/YYYY) : ");
        Date dataCheckOut = sdf.parse(sc.next());
        if (!dataCheckOut.after(dataCheckIn)) {
            System.out.println("Erro na reserva: data de check-out anterior a data de check-in");
        } else {
            Reserva r = new Reserva(numQuarto, dataCheckIn, dataCheckOut);
            System.out.println(r.toString());
            
            System.out.println("Informe os dados para atualizar a reserva: ");
            System.out.print("Data de check-in (DD/MM/YYYY) : ");
            dataCheckIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (DD/MM/YYYY) : ");
            dataCheckOut = sdf.parse(sc.next());
            String error = r.atualizacaoReserva(dataCheckIn, dataCheckOut);
            if (error != null) {
                System.out.println(error);
            } else
                System.out.println(r.toString());
        sc.close();
        }
    }
    
}

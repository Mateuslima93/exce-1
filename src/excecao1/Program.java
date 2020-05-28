
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
            Date agora = new Date();
            if (!dataCheckIn.after(agora)|| !dataCheckOut.after(agora)) {
                System.out.println("Erro de reserva: as datas de reserva devem ser datas futuras");
            } else if (!dataCheckOut.after(dataCheckIn)) {
                System.out.println("Erro na reserva: data de check-out anterior a data de check-in");
            } else {
                r.atualizacaoReserva(dataCheckIn, dataCheckOut);
                System.out.println(r.toString());
        }
        sc.close();
        }
    }
    
}

package Ex1.src;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.JFrame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
         PhoneBook pb1 = new PhoneBook();
         pb1.makeWindow();

         ComboBoxFrame comboBoxFrame = new ComboBoxFrame();
         comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         comboBoxFrame.setSize(350,150);
         comboBoxFrame.setVisible(true);

         TextFieldFrame textFieldFrame = new TextFieldFrame();
         textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         textFieldFrame.setSize(325,125);
         textFieldFrame.setVisible(true);

         Calendar c = Calendar.getInstance();
         System.out.println("Data e Hora atual: " + c.getTime());
         System.out.println("Ano: " + c.get(Calendar.YEAR));
         System.out.println("Mês: " + (c.get(Calendar.MONTH)+1));
         System.out.println("Dia do mês: " + c.get(Calendar.DAY_OF_MONTH));

         c.set(Calendar.YEAR,1963);
         c.set(Calendar.MONTH, Calendar.MARCH);
         c.set(Calendar.DAY_OF_MONTH,8);
         System.out.println("\nData reprogramada e hora atual: " + c.getTime());
         System.out.println("Ano: " + c.get(Calendar.YEAR));
         System.out.println("Mês: " + (c.get(Calendar.MONTH)+1));
         System.out.println("Dia do mês: " + c.get(Calendar.DAY_OF_MONTH));

         c = Calendar.getInstance();
         System.out.println("\nData e Hora atual: " + c.getTime());
         System.out.println("Ano: " + c.get(Calendar.YEAR));
         System.out.println("Mês: " + (c.get(Calendar.MONTH)+1));
         System.out.println("Dia do mês: " + c.get(Calendar.DAY_OF_MONTH));
         int hora = c.get(Calendar.HOUR_OF_DAY);
         if(hora > 6 && hora < 12){
             System.out.println("Bom Dia");
         }
         else
         {
             if(hora>12 && hora < 18)
             {
                 System.out.println("Boa Tarde");
             }
             else
             {
                 System.out.println("Boa Noite");
             }
         }

         c.set(2013,Calendar.FEBRUARY, 28);
         Date data = c.getTime();
         System.out.println("Data atual sem formatação: " + data);
         DateFormat formataData = DateFormat.getDateInstance();
         System.out.println("Data atual com formatação: " + formataData.format(data));
         DateFormat horario = DateFormat.getDateInstance();
         System.out.println("Hora formatada: "+horario.format(data));

         DateFormat dtHora = DateFormat.getDateInstance();
         System.out.println(dtHora.format(data));

         Date date = c.getTime();
         DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
         System.out.println("Data brasileira: "+f.format(date));
         f = DateFormat.getDateInstance(DateFormat.LONG);
         System.out.println("Data sem o dia escrito: "+f.format(date));
         f = DateFormat.getDateInstance(DateFormat.MEDIUM);
         System.out.println("Data resumida 1: "+f.format(date));
         f = DateFormat.getDateInstance(DateFormat.SHORT);
         System.out.println("Data resumida 2: "+f.format(date));

         DateFormat d = DateFormat.getDateInstance();
         System.out.println("Data: " + d.format(data));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data formatada: " + sdf.format(data));
        System.out.println("Data convertida: " + sdf.parse("02/08/1970"));

        Locale brasil = new Locale("pt","BR");
        Locale eua = Locale.US;
        Locale italia = Locale.ITALIAN;

        DateFormat fb = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data e hora brasileira: "+fb.format(data));
        DateFormat sb = DateFormat.getDateInstance(DateFormat.SHORT,brasil);
        System.out.println("Data e hora brasileira: "+sb.format(data));
        DateFormat fe = DateFormat.getDateInstance(DateFormat.FULL,eua);
        System.out.println("Data e hora americana: "+fe.format(data));
        DateFormat se = DateFormat.getDateInstance(DateFormat.SHORT,brasil);
        System.out.println("Data e hora americana: "+se.format(data));
        DateFormat fi = DateFormat.getDateInstance(DateFormat.FULL,brasil);
        System.out.println("Data e hora italiana: "+fi.format(data));
        DateFormat si = DateFormat.getDateInstance(DateFormat.SHORT,brasil);
        System.out.println("Data e hora italiana: "+si.format(data));

        Calendar dateTime = Calendar.getInstance();

        System.out.printf("%tc\n", dateTime);
        System.out.printf("%tF\n", dateTime);
        System.out.printf("%tD\n", dateTime);
        System.out.printf("%tr\n", dateTime);
        System.out.printf("%tT\n", dateTime);

        System.out.printf("%1$tA, %1$tB %1$td, %1$tY\n", dateTime);
        System.out.printf("%1$TA, %1$TB %1$Td, %1$TY\n", dateTime);
        System.out.printf("%1$ta, %1$tb %1$td, %1$ty\n", dateTime);

        System.out.printf("%1$tH:%1$tM:%1$tS\n", dateTime);
        System.out.printf("%1$tZ %1$tI:%1$tM:%1$tS %tp",dateTime);
        }
    }

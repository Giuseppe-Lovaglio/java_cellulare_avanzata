import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class Cellulare_con_gioco {
    public double creditoDisponibile;
    public int chiamateEffettuate;
    public double tariffaAlMinuto;

    ArrayList<String> rubrica_nomi = new ArrayList<String>();
    ArrayList<String> rubrica_numeri = new ArrayList<String>();

    Scanner input = new Scanner(System.in);

    public void avvio() {

        System.out.print("Premi 1 per selezionare l'app slot machine, premi 2 per avviare la modalità chiamata: ");
        int scelta_1 = input.nextInt();

        while(scelta_1 != 1 && scelta_1 != 2) {
            System.out.print("Riprova, premi 1 per selezionare l'app slot machine, premi 2 per avviare la modalità chiamata: ");
            scelta_1 = input.nextInt();
        }

        if (scelta_1 == 2) {
            ciclo: while (true) {
                System.out.println();
                System.out.println("Premi 1 per ricaricare il tuo credito.");
                System.out.println("Premi 2 per impostare la tua tariffa.");
                System.out.println("Premi 3 per effettuare una chiamata.");
                System.out.println("Premi 4 per visualizzare il credito disponibile.");
                System.out.println("Premi 5 per visualizzare il numero di chiamate effettuate.");
                System.out.println("Premi 6 per azzerare il numero di chiamate effettuate.");
                System.out.println("Premi 7 per modificare o visualizzare la tua rubrica.");
                System.out.println("Premi 8 per terminare.");
                System.out.println();
                int inputInserito = input.nextInt();

                while (inputInserito < 1 || inputInserito > 8) {
                    System.out.println("Il numero da te inserito non è corretto, riprova.");
                    inputInserito = input.nextInt();
                }
                
                switch (inputInserito) {
                    case 1:
                        this.versamento();
                        break;
                    case 2:
                        this.impostaTariffa();
                        break;
                    case 3:
                        this.chiamata();
                        break;
                    case 4:
                        this.visualizza_credito();
                        break;
                    case 5:
                    this.visualizza_numero_chiamate_effettuate();
                        break;
                    case 6:
                        this.azzeramento_numero_chiamate_effettuate();
                        break;
                    case 7:
                        this.aggiornaRubrica();
                        break;
                    case 8:
                        System.out.println("Fine.");
                        break ciclo;
                }
            }

            input.close();
        }

        else {
            int totale_uguali = 0;
            while(true) {
                System.out.print("Scrivi g per giocare o ESCI per uscire: ");
                String comando = input.next();
                comando = comando.toLowerCase();

                while(!comando.equals("g") && !comando.equals("esci")) {
                    System.out.print("Il comando immesso non è riconosciuto, riprova: ");
                    comando = input.next();
                    comando = comando.toLowerCase();
                }

                if (comando.equals("g")) {
                    String numero_random1;
                    String numero_random2;
                    String numero_random3;
                    String risultato = "";
                    
                    numero_random1 = (Math.round(Math.floor(Math.random()*5+1)) + "").substring(0, 1);
                    numero_random2 = (Math.round(Math.floor(Math.random()*5+1)) + "").substring(0, 1);
                    numero_random3 = (Math.round(Math.floor(Math.random()*5+1)) + "").substring(0, 1);
                    risultato = numero_random1 + " " + numero_random2 + " " + numero_random3;

                    if (numero_random1.equals(numero_random2) && numero_random2.equals(numero_random3)) {
                        System.out.println("Hai vinto!");
                        totale_uguali += 1;
                    }

                    System.out.println(risultato);
                    System.out.println("Totale vincite: " + totale_uguali);
                }

                else {
                    System.out.println("Fine!");
                    break;
                }
            }
        }
    }

    public void versamento() {
        System.out.print("Digita l'ammontare del versamento che vuoi effettuare sul tuo credito: ");
        double valore_input_versamento = input.nextDouble();

        while (valore_input_versamento <= 0) {
            System.out.println("L'ammontare da te inserito non è corretto, inserisci un valore maggiore di 0.0 per effettuare il versamento: ");
            valore_input_versamento = input.nextDouble();
        }

        this.creditoDisponibile += valore_input_versamento;
        System.out.println("Il versamento è andato a buon fine! Il tuo credito ora ammonta a " + this.creditoDisponibile + " euro.");
    }

    public void impostaTariffa() {
        System.out.print("Inserisci la tariffa desiderata: ");
        double tariffa = input.nextDouble();
        this.tariffaAlMinuto = tariffa;
        System.out.println("La tua tariffa è stata aggiornata a " + this.tariffaAlMinuto + " euro al minuto.");
    }

    public void chiamata() {
        ciclo0: while (true) {
            while (this.tariffaAlMinuto == 0) {
                System.out.print("Il tuo piano tariffario non è impostato, non puoi effettuare chiamate. Premi 2 per impostare la tariffa al minuto oppure 8 per tornare indietro. ");
                int scelta = input.nextInt();
                while (scelta != 2 && scelta != 8) {
                    System.out.print("Il numero che hai inserito non è valido, premi 2 per impostare la tariffa al minuto oppure 8 per tornare   indietro. ");
                    scelta = input.nextInt();
                }
            
                if (scelta == 2) {
                    this.impostaTariffa();
                }
            
                else {
                    break ciclo0;
                }
            }
                System.out.print("Inserisci il numero di minuti di chiamata che vorresti effettuare o '-10' per tornare indietro o -5 per modificare la tua rubrica: ");
                int minuti_chiamata = input.nextInt();

                if (minuti_chiamata == -10) {
                    System.out.println("La chiamata non è stata effettuata.");
                    break ciclo0;
                }

                else if (minuti_chiamata == -5) {
                    this.aggiornaRubrica();
                }
            
                else {
                    while (minuti_chiamata <= 0 && minuti_chiamata != -10 && minuti_chiamata != -5) {
                        System.out.print("Il valore che hai inserito non è corretto, riprova: ");
                        minuti_chiamata = input.nextInt();
                    }
                
                    double costo_totale_chiamata = minuti_chiamata * this.tariffaAlMinuto;
                    System.out.println("Il costo totale della chiamata è " + costo_totale_chiamata + " euro.");
                    this.chiamateEffettuate += 1;
                
                    if (this.creditoDisponibile - costo_totale_chiamata >= 0) {
                        System.out.println("La chiamata è stata effettuata.");
                        this.creditoDisponibile = this.creditoDisponibile - costo_totale_chiamata;
                        break;
                    }
                
                    else {
                        System.out.println("Il credito disponibile non è sufficiente, chiamata terminata.");
                        System.out.println("La chiamata è durata " + (this.creditoDisponibile / tariffaAlMinuto) + " minuti e hai speso " +     this.       creditoDisponibile + " euro.");
                        this.creditoDisponibile = 0;
                        break;
                    }
                }     
        }
    }

    public void visualizza_credito() {
        System.out.println("Il credito disponibile è " + this.creditoDisponibile + " euro.");
    }

    public void visualizza_numero_chiamate_effettuate() {
        System.out.println("Il numero totale di chiamate effettuate è " + this.chiamateEffettuate + ".");
        System.out.println("---------------------------------");
        if (this.rubrica_nomi.size() == 0) {
            System.out.println("La tua rubrica è vuota!");
        }
        else {
            System.out.println("La tua rubrica:");
            for (int i = 0; i < this.rubrica_nomi.size(); i++) {
                System.out.println(this.rubrica_nomi.get(i) + ": " + this.rubrica_numeri.get(i));
            }
        }
    }

    public void azzeramento_numero_chiamate_effettuate() {
        this.chiamateEffettuate = 0;
        System.out.println("Il numero totale di chiamate da te effettuate è stato azzerato.");
    }

    public void aggiornaRubrica() {
        System.out.println("Premi 1 per aggiornare la rubrica, 2 per eliminare un contatto o 3 per visualizzare la rubrica.");
        int scelta = input.nextInt();

        while (scelta < 1 || scelta > 3) {
            System.out.println("Il numero inserito non è corretto, premi 1 per aggiornare la rubrica, 2 per eliminare un contatto o 3 per visualizzare la rubrica.");
            scelta = input.nextInt();
        }

        if (scelta == 1) {
            System.out.print("Scrivi il nome e cognome della persona che vorresti aggiungere alla tua rubrica: ");
            input.nextLine();
            String nome = input.nextLine();
            this.rubrica_nomi.add(nome);

            System.out.print("Scrivi il numero di telefono: ");
            String numero = input.next();
            this.rubrica_numeri.add(numero);

            System.out.println("La tua rubrica è stata aggiornata correttamente.");
        }

        else if (scelta == 2) {
            if (this.rubrica_nomi.size() == 0) {
                System.out.println("Non ci sono elementi nella tua rubrica");
            }

            else {
                while(true) {
                    System.out.print("Scrivi il nome e cognome della persona che vorresti rimuovere dalla rubrica: ");
                    input.nextLine();
                    String nome = input.nextLine();
                    int indice = this.rubrica_nomi.indexOf(nome);

                    if (indice != -1) {
                        this.rubrica_nomi.remove(indice);
                        this.rubrica_numeri.remove(indice);
                        System.out.println("L'elemento è stato rimosso correttamente.");
                        break;
                    }

                    else {
                        System.out.print("Il nome da te inserito non è presente nella rubrica, premi 1 per riprovare o 2 per terminare: ");
                        int valore = input.nextInt();

                        while (valore != 1 || valore != 2) {
                            System.out.println("Il numero che hai inserito non è corretto, premi 1 per riprovare o 2 per terminare: ");
                            valore = input.nextInt();
                        }

                        if (valore == 2) {
                            break;
                        }
                    }
                }
            }
        }

        else {
            if (this.rubrica_nomi.size() == 0) {
                System.out.println("La tua rubrica è vuota!");
            }

            else {
                System.out.println("La tua rubrica:");
                for (int i = 0; i < this.rubrica_nomi.size(); i++) {
                    System.out.println(this.rubrica_nomi.get(i) + ": " + this.rubrica_numeri.get(i));
                }
            }
        }
    }
}
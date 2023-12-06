# Esercizio 3x02 Java – Cellulare
#### Traccia base
Simulare un telefono Cellulare con contratto a ricarica, dotato di tre variabili d'istanza: credito
disponibile (iniziale 20,0€), chiamate effettuate (iniziale 0), tariffa.
Predisporre gli opportuni metodi per effettuare:
* Ricariche del credito di un importo a piacere, con "sms" di conferma;
* Impostazione di una tariffa di 20 centesimi/minuto;
* Chiamate di durate in minuti a piacere, verificando se il credito è sufficiente e bloccare
la chiamata in corso all'esaurirsi del credito (un "sms" avvisa della situazione);
* Visualizzazione del credito disponibile;
* Visualizzazione del numero di chiamate effettuate;
* Azzeramento del numero di chiamate effettuate, con messaggio di conferma.
Utilizzare dei println() per simulare messaggi su display e sms ricevuti.
#### Traccia avanzata
Dopo aver svolto la traccia base e ottenuto conferma di completezza dal docente, si
potranno aggiungere al cellulare le seguenti funzionalità, modificando i metodi già
implementati laddove occorre:
* Gestione di una rubrica, con aggiunta di nome e numero nonché possibilità di
cancellare contatti; la rubrica può essere richiamata dalla funzione che effettua
chiamate;
* Potenziamento del visualizzatore di chiamate, che mostra anche i nomi dei contatti
oltre che la quantità delle telefonate effettuate;
* Creazione di una slot machine, da avviare scrivendo "Gioca" dopo aver selezionato
l'app, che sorteggia tre numeri da 1 a 5, conteggiando il numero di volte che si
realizzano tre numeri uguali, e predisporre un input per uscire dal gioco.
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        // IDEAS
        // Añadir que se muestre lo que pasa cuando juga el ordenador para arreglar el programa
        // Añadir opción 2 jugadores en tres en raya
        // Añadir que se pueda escoger entre más de una lista de palabras en el ahorcado
        // Añadir dificultad ahorcado difici --> 6 fallos fácil --> 10 fallos

        Random random = new Random();
        Scanner entrada = new Scanner(System.in);
        // BUCLE PRINCIPAL DEL PROGRAMA
        boolean  en_el_programa = true;
        while (en_el_programa){
            System.out.println(" ");
            System.out.println("TRES EN RAYA / AHORCADO");
            System.out.println(" ");
            System.out.println("Escoge una opción");
            System.out.println("1. Para jugar al tres en raya");
            System.out.println("2. Para jugar al ahorcado");
            System.out.println("3. Para salir del programa");

            boolean exit = false;
            int entrada1 = 0;
            while (!exit) {
                System.out.print("Opción: ");
                exit = entrada.hasNextInt();
                if (exit) {
                    entrada1 = entrada.nextInt();
                    if (entrada1 < 1 || entrada1 > 3) {
                        exit = false;
                        System.out.println("Tienes que escribir un número entero entre 1 y 3");
                    }
                } else {
                    System.out.println("Tienes que escribir un número entero entre 1 y 3");
                }
                entrada.nextLine();
            }



            boolean jugando_ahorcado = false;
            boolean jugando_tres_en_raya = false;

            // SWITCH MENÚ
            switch (entrada1) {
                case 1:
                    jugando_tres_en_raya = true;
                    break;
                case 2:
                    jugando_ahorcado = true;
                    break;
                case 3:
                    en_el_programa = false;
                    System.out.println("Saliendo del programa ...");
            }
            System.out.println(" ");




            // NUEVO JUEGO TRES EN RAYA
            while (jugando_tres_en_raya) {
                char [][] tablero = new char [3][3];
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        tablero[i][j] = ' ';
                    }
                }
                System.out.println("T R E S   E N   R A Y A");
                System.out.println(" ");

                Scanner entrada0 = new Scanner(System.in);

                // JUGADOR ESCOGE FICHA
                String input0 = " ";
                char ficha = ' ';
                System.out.println("Escoge una ficha (X / O)");
                char ficha_jugador = ' ';
                char ficha_ordenador = ' ';
                boolean escogiendo_ficha = true;

                while (escogiendo_ficha){
                    System.out.print("Ficha: ");
                    input0 = entrada0.next();
                    char [] list_ficha = input0.toCharArray();
                    if (list_ficha.length != 1) {
                        System.out.println("Debes introducir un caracter (X / O)");

                    } else {
                        ficha = list_ficha[0];
                        if (ficha == 'X' || ficha == 'x'){
                            ficha_jugador = 'X';
                            ficha_ordenador = 'O';
                            escogiendo_ficha = false;
                        } else if (ficha == 'O' || ficha == 'o') {
                            ficha_jugador = 'O';
                            ficha_ordenador = 'X';
                            escogiendo_ficha = false;
                        } else {
                            System.out.println("Debes introducir un caracter (X / O)");
                        }
                    } entrada0.nextLine();
                }

                System.out.println(" ");
                System.out.println("Ficha del jugador es " + ficha_jugador);
                System.out.println("Ficha del ordenador es " + ficha_ordenador);
                System.out.println(" ");



                // INSTRUCCIONES TURNO JUGADOR
                System.out.println("Para ingresar una jugada debes introducir un número entre 1 y 9");
                System.out.println("[" + 1 + "] [" + 2 +"] [" + 3 + "]");
                System.out.println("[" + 4 + "] [" + 5 +"] [" + 6 + "]");
                System.out.println("[" + 7 + "] [" + 8 +"] [" + 9 + "]");
                System.out.println(" ");


                // ESCOGER SI QUIERES VER EL PENSAMIENTO DEL BOT
                boolean show_bot_instructions = false;
                System.out.println(" ");
                System.out.println("¿Quieres ver cómo piensa el bot?");
                String entrance = "";
                Scanner input = new Scanner(System.in);
                boolean salir = false;
                while (salir == false) {
                    System.out.print("(si o no): ");
                    entrance = input.next();
                    char [] entry = entrance.toCharArray();
                    if (entry[0] == 's'){
                        show_bot_instructions = true;
                        salir = true;
                    } else if (entry[0] == 'n') {
                        salir = true;
                    }input.nextLine();
                }
                System.out.println(" ");



                // QUIEN EMPIEZA
                boolean turno_jugador = false;
                int empieza = random.nextInt(2) + 1;
                if (empieza == 1){
                    System.out.println("Empiezas tú");
                    turno_jugador = true;
                } else {
                    System.out.println("Empieza el ordenador");
                }
                System.out.println(" ");



                // BUCLE PRINCIPAL TRES EN RAYA
                boolean partida_tres_en_raya = true;
                while (partida_tres_en_raya){
                    if (turno_jugador){
                        System.out.println("TU TURNO");

                        // MOSTRAR TABLERO
                        System.out.println("[" + tablero[0][0] + "] ["+ tablero[0][1] +"] ["+ tablero[0][2] + "]");
                        System.out.println("[" + tablero[1][0] + "] ["+ tablero[1][1] +"] ["+ tablero[1][2] + "]");
                        System.out.println("[" + tablero[2][0] + "] ["+ tablero[2][1] +"] ["+ tablero[2][2] + "]");
                        System.out.println(" ");

                        // BUCLE VALIDACIÓN JUGADA
                        boolean exit1 = false;
                        int jugada = 0;
                        while (!exit1){
                            System.out.print("Jugada: ");
                            exit1 = entrada0.hasNextInt();
                            if (exit1) {
                                jugada = entrada0.nextInt();
                                if (jugada < 1 || jugada > 9) {
                                    System.out.println("Debes introducir un número entre 1 y 9");
                                    exit1 = false;
                                } else {
                                    if (jugada == 1) {
                                        if (tablero[0][0] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[0][0] = ficha_jugador;
                                        }
                                    } else if (jugada == 2) {
                                        if (tablero[0][1] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[0][1] = ficha_jugador;
                                        }
                                    } else if (jugada == 3) {
                                        if (tablero[0][2] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[0][2] = ficha_jugador;
                                        }
                                    } else if (jugada == 4) {
                                        if (tablero[1][0] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[1][0] = ficha_jugador;
                                        }
                                    } else if (jugada == 5) {
                                        if (tablero[1][1] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[1][1] = ficha_jugador;
                                        }
                                    } else if (jugada == 6) {
                                        if (tablero[1][2] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[1][2] = ficha_jugador;
                                        }
                                    } else if (jugada == 7) {
                                        if (tablero[2][0] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[2][0] = ficha_jugador;
                                        }
                                    } else if (jugada == 8) {
                                        if (tablero[2][1] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[2][1] = ficha_jugador;
                                        }
                                    } else { // jugada = 9
                                        if (tablero[2][2] != ' '){
                                            System.out.println("Aquí ya hay una ficha introduce una jugada en la que haya un espacio en blanco");
                                            exit1 = false;
                                        } else {
                                            tablero[2][2] = ficha_jugador;
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Debes introducir un número entre 1 y 9");
                            } entrada0.nextLine();
                        } // while (exit4 == false)

                        // MOSTRAR TABLERO
                        System.out.println("[" + tablero[0][0] + "] ["+ tablero[0][1] +"] ["+ tablero[0][2] + "]");
                        System.out.println("[" + tablero[1][0] + "] ["+ tablero[1][1] +"] ["+ tablero[1][2] + "]");
                        System.out.println("[" + tablero[2][0] + "] ["+ tablero[2][1] +"] ["+ tablero[2][2] + "]");
                        System.out.println(" ");


                        // VERIFICAR SI HA GANADO
                        // Verificando Horizontales
                        if ((tablero[0][0] == ficha_jugador && tablero[0][1] == ficha_jugador && tablero[0][2] == ficha_jugador) ||
                                (tablero[1][0] == ficha_jugador && tablero[1][1] == ficha_jugador && tablero[1][2] == ficha_jugador) ||
                                (tablero[2][0] == ficha_jugador && tablero[2][1] == ficha_jugador && tablero[2][2] == ficha_jugador) ||
                                // Verificando Verticales
                                (tablero[0][0] == ficha_jugador && tablero[1][0] == ficha_jugador && tablero[2][0] == ficha_jugador) ||
                                (tablero[0][1] == ficha_jugador && tablero[1][1] == ficha_jugador && tablero[2][1] == ficha_jugador) ||
                                (tablero[0][2] == ficha_jugador && tablero[1][2] == ficha_jugador && tablero[2][2] == ficha_jugador) ||
                                // Verificando Diagonales
                                (tablero[0][0] == ficha_jugador && tablero[1][1] == ficha_jugador && tablero[2][2] == ficha_jugador) ||
                                (tablero[0][2] == ficha_jugador && tablero[1][1] == ficha_jugador && tablero[2][0] == ficha_jugador)){
                            System.out.println("HAS GANADO :)");
                            partida_tres_en_raya = false;
                        }

                        // VERIFICAMOS SI EL TABLERO ESTÁ COMPLETO (EMPATE)
                        boolean tablero_lleno = true;
                        for (int i = 0; i <= tablero.length - 1; i ++) {
                            for (int j = 0; j <= tablero[i].length - 1; j ++) {
                                if (tablero[i][j] == ' ') {
                                    tablero_lleno = false;
                                }
                            }
                        }
                        if (tablero_lleno) {
                            System.out.println("EMPATE :P");
                            partida_tres_en_raya = false;
                        }

                        turno_jugador = false;

                    } // if (turno_jugador)





                    /* Lógica turno ordenador:

                    *  1. Craer array con posibles jugadas                                                HECHO  271-331
                    *  2. Crear copia del array tablero para verificar las posibles jugadas               HECHO  342
                    *  3. Verificamos si podemos ganar en la siguiente jugada
                    *  4. Verificamos si el gugador puede ganar en la siguiente partida para bloquearlo
                    *  5. Ocupamos el centro de la pantalla si está libre
                    *  6. Ocupamos una esquina random si está libre
                    *  7. Ocupamos un lado random
                    */

                    // TURNO ORDENADOR
                    if (!turno_jugador && partida_tres_en_raya == true) {
                        System.out.println("TURNO DEL ORDENADOR");

                        // CREANDO VARIABLE PARA LA LONGITUD DEL ARRAY
                        // Para declarar un array del tamaño justo ya que no hemos aprendido a hacer listas
                        int espacios_vacios = 0;

                        for (int i = 0; i <= tablero.length - 1; i ++) {
                            for (int j = 0; j <= tablero[i].length - 1; j ++){
                                if (tablero[i][j] == ' ') {
                                    espacios_vacios ++;
                                }
                            }
                        }


                        // DECLARAMOS EL ARRAY (espacios_libres)
                        int [] espacios_libres = new int [espacios_vacios];
                        int num_espacio_libre = 0;

                        // BUCLE FOR PARA RELLENAR EL ARRAY (espacios_libres)
                        for (int i = 0; i <= tablero.length - 1; i ++) {
                            for (int j = 0; j <= tablero[i].length - 1; j ++){
                                if (tablero[i][j] == ' ') {
                                    // i = 0
                                    if (i == 0 && j == 0) { // 1
                                        espacios_libres[num_espacio_libre] = 1;
                                        num_espacio_libre ++;
                                    } else if (i == 0 && j == 1) { // 2
                                        espacios_libres[num_espacio_libre] = 2;
                                        num_espacio_libre ++;
                                    } else if (i == 0 && j == 2) { // 3
                                        espacios_libres[num_espacio_libre] = 3;
                                        num_espacio_libre ++;
                                    }

                                    // i = 1
                                    else if (i == 1 && j == 0) { // 4
                                        espacios_libres[num_espacio_libre] = 4;
                                        num_espacio_libre ++;
                                    }
                                    else if (i == 1 && j == 1) { // 5
                                        espacios_libres[num_espacio_libre] = 5;
                                        num_espacio_libre ++;
                                    }
                                    else if (i == 1 && j == 2) { // 6
                                        espacios_libres[num_espacio_libre] = 6;
                                        num_espacio_libre ++;
                                    }

                                    // i = 2
                                    else if (i == 2 && j == 0) { // 7
                                        espacios_libres[num_espacio_libre] = 7;
                                        num_espacio_libre ++;
                                    }
                                    else if (i == 2 && j == 1) { // 8
                                        espacios_libres[num_espacio_libre] = 8;
                                        num_espacio_libre ++;
                                    }
                                    else if (i == 2 && j == 2) { // 9
                                        espacios_libres[num_espacio_libre] = 9;
                                        num_espacio_libre ++;
                                    }
                                } // if (tablero[i][j] == ' ')
                            } // for (int j = 0; j <= tablero[i].length - 1; j ++)
                        } // CIERRE BUCLE PARA DECLARAR ARRAY (espacios_libres)


                        // (Esto es para hacer algunas comprobaciones no es necesario para la ejecución)
                        // Imprimir espacios libres
                        if (show_bot_instructions) {
                            System.out.println("ESPACIOS LIBRES POSIBLES JUGADAS ORDENADOR");
                            for (int i = 0; i <= espacios_libres.length -1; i ++) {
                                System.out.print(espacios_libres[i] + " ");
                            }
                            System.out.println(" ");
                        }


                        // CREANDO COPIA DEL TABLERO
                        char[][] copia_tablero = new char[3][3];

                        for (int i = 0; i <= tablero.length - 1; i ++) {
                            for (int j = 0; j <= tablero[i].length - 1; j ++){
                                copia_tablero[i][j] = tablero[i][j];
                            }
                        }


                        // DECLARANDO LAS VARIABLES NECESARIAS PARA BUCLE DE VERIFICACIÓN DE JUGADAS
                        boolean verificando = true;
                        int jugada_ordenador_prueba;
                        int jugada_ordenador_real = 0;

                        if (espacios_libres.length == 1) {
                            jugada_ordenador_real = espacios_libres[0];
                            verificando = false;
                        }

                        // BUCLE DE VERIFICACIÓN
                        while (verificando) {
                            // BUCLE FOR PARA VERIFICAR LAS POSIBLES JUGADAS GANADORAS
                            for (int i = 0; i <= espacios_libres.length - 1; i ++) {

                                // LIMPIANDO "copia_tablero" (imprescindible para el funcionamiento del bucle)
                                for (int x = 0; x <= tablero.length - 1; x ++) {
                                    for (int j = 0; j <= tablero[x].length - 1; j ++){
                                        copia_tablero[x][j] = tablero[x][j];
                                    }
                                }

                                //  Probamos cada jugada posible a ver si podemos ganar
                                /* "espacios_libres" es un array con posibles jugadas, cada posible jugada es
                                *   un entero del uno al nueve, pero sólo contiene las jugadas donde hay un espacio
                                *   vacío */
                                jugada_ordenador_prueba = espacios_libres[i];

                                // HACEMOS LA POSIBLE JUGADA EN LA COPIA DEL TABLERO
                                if (jugada_ordenador_prueba == 1) {
                                    copia_tablero[0][0] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 2) {
                                    copia_tablero[0][1] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 3) {
                                    copia_tablero[0][2] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 4) {
                                    copia_tablero[1][0] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 5) {
                                    copia_tablero[1][1] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 6) {
                                    copia_tablero[1][2] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 7) {
                                    copia_tablero[2][0] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 8) {
                                    copia_tablero[2][1] = ficha_ordenador;
                                } else if (jugada_ordenador_prueba == 9) {
                                    copia_tablero[2][2] = ficha_ordenador;
                                }

                                // VERIFICAMOS SI HEMOS GANADO
                                if (show_bot_instructions) {
                                    System.out.println("El ordenador intenta ganar la partida en la jugada " + espacios_libres[i]);
                                }
                                        // Verificando Horizontales
                                if ((copia_tablero[0][0] == ficha_ordenador && copia_tablero[0][1] == ficha_ordenador && copia_tablero[0][2] == ficha_ordenador) ||
                                        (copia_tablero[1][0] == ficha_ordenador && copia_tablero[1][1] == ficha_ordenador && copia_tablero[1][2] == ficha_ordenador) ||
                                        (copia_tablero[2][0] == ficha_ordenador && copia_tablero[2][1] == ficha_ordenador && copia_tablero[2][2] == ficha_ordenador) ||
                                        // Verificando Verticales
                                        (copia_tablero[0][0] == ficha_ordenador && copia_tablero[1][0] == ficha_ordenador && copia_tablero[2][0] == ficha_ordenador) ||
                                        (copia_tablero[0][1] == ficha_ordenador && copia_tablero[1][1] == ficha_ordenador && copia_tablero[2][1] == ficha_ordenador) ||
                                        (copia_tablero[0][2] == ficha_ordenador && copia_tablero[1][2] == ficha_ordenador && copia_tablero[2][2] == ficha_ordenador) ||
                                        // Verificando Diagonales
                                        (copia_tablero[0][0] == ficha_ordenador && copia_tablero[1][1] == ficha_ordenador && copia_tablero[2][2] == ficha_ordenador) ||
                                        (copia_tablero[0][2] == ficha_ordenador && copia_tablero[1][1] == ficha_ordenador && copia_tablero[2][0] == ficha_ordenador)){

                                    // HACEMOS NUESTRA JUGADA GANADORA
                                    jugada_ordenador_real = jugada_ordenador_prueba;
                                    System.out.println("La jugada del ordenador es " + jugada_ordenador_real);

                                    // Ya no hace falta verificar más jugadas y "break" --> para salir del "for"
                                    verificando = false;
                                    break;
                                }
                            }

                            // VERIFICAR SI EL JUGADOR PUEDE GANAR EN LA SIGUIENTE JUGADA
                            // En caso de que aún no hayamos hecho una jugada, por eso --> "if (verificando)"
                            int jugada_jugador_prueba = 0;
                            if (verificando) {
                                // BUCLE FOR PARA COMPROBAR CADA POSIBLE MOVIMIENTO DEL JUGADOR
                                for (int i = 0; i <= espacios_libres.length - 1; i ++) {

                                    // LIMPIANDO EL TABLERO
                                    // Otra vez imprescindible para el funcionamiento del bucle
                                    for (int x = 0; x <= tablero.length - 1; x ++) {
                                        for (int j = 0; j <= tablero[x].length - 1; j ++){
                                            copia_tablero[x][j] = tablero[x][j];
                                        }
                                    }

                                    // Probamos cada jugada posible a ver si el jugador puede ganar
                                    jugada_jugador_prueba = espacios_libres[i];

                                    // HACEMOS LA POSIBLE JUGADA EN LA COPIA DEL TABLERO
                                    if (jugada_jugador_prueba == 1) {
                                        copia_tablero[0][0] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 2) {
                                        copia_tablero[0][1] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 3) {
                                        copia_tablero[0][2] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 4) {
                                        copia_tablero[1][0] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 5) {
                                        copia_tablero[1][1] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 6) {
                                        copia_tablero[1][2] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 7) {
                                        copia_tablero[2][0] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 8) {
                                        copia_tablero[2][1] = ficha_jugador;
                                    } else if (jugada_jugador_prueba == 9) {
                                        copia_tablero[2][2] =ficha_jugador;
                                    }

                                    // VERIFICAMOS SI EL JUGADOR PUEDE GANAR EN LA SIGUIENTE JUGADA
                                    if (show_bot_instructions) {
                                        System.out.println("El ordenador intenta bloquear al jugador si es que puede ganar en la jugada " + espacios_libres[i]);
                                    }
                                            // Verificando horizontales
                                    if ((copia_tablero[0][0] == ficha_jugador && copia_tablero[0][1] == ficha_jugador && copia_tablero[0][2] == ficha_jugador) ||
                                            (copia_tablero[1][0] == ficha_jugador && copia_tablero[1][1] == ficha_jugador && copia_tablero[1][2] == ficha_jugador) ||
                                            (copia_tablero[2][0] == ficha_jugador && copia_tablero[2][1] == ficha_jugador && copia_tablero[2][2] == ficha_jugador) ||
                                            // Verificando Verticales
                                            (copia_tablero[0][0] == ficha_jugador && copia_tablero[1][0] == ficha_jugador && copia_tablero[2][0] == ficha_jugador) ||
                                            (copia_tablero[0][1] == ficha_jugador && copia_tablero[1][1] == ficha_jugador && copia_tablero[2][1] == ficha_jugador) ||
                                            (copia_tablero[0][2] == ficha_jugador && copia_tablero[1][2] == ficha_jugador && copia_tablero[2][2] == ficha_jugador) ||
                                            // Verificando Diagonales
                                            (copia_tablero[0][0] == ficha_jugador && copia_tablero[1][1] == ficha_jugador && copia_tablero[2][2] == ficha_jugador) ||
                                            (copia_tablero[0][2] == ficha_jugador && copia_tablero[1][1] == ficha_jugador && copia_tablero[2][0] == ficha_jugador)){

                                        // BLOQUEAMOS AL JUGADOR
                                        jugada_ordenador_real = jugada_jugador_prueba;
                                        System.out.println("La jugada del ordenador es " + jugada_ordenador_real);

                                        // Ya no hace falta verificar más jugadas y "break" --> para salir del "for"
                                        verificando = false;
                                        break;
                                    }
                                } // Bucle for verifica si gana el jugador
                            } // if (verificando)


                            // JUEGA EN EL CENTRO SI ESTÁ LIBRE
                            if (verificando) {
                                if (show_bot_instructions) {
                                    System.out.println("El ordenador intenta ocupar el centro");
                                }
                                if (tablero[1][1] == ' '){ // Si centro libre
                                    jugada_ordenador_real = 5; // Jugar al centro
                                    verificando = false; // No es necesario verifica nada más
                                }
                            }

                            // JUEGA EN ESQUINA RANDOM SI ESTÁ LIBRE
                            // Si aún no hemos hecho ninguna jugada --> "if (verificando)"
                            if (verificando) {

                                if (show_bot_instructions) {
                                    System.out.println("El ordenador intenta ocupar una esquina random");
                                }

                                /* Lógica para mover a una esquina:
                                *  1. Del array espacios libres sacamos las esquinas libres
                                *  2. Index randon para el array esquinas libres
                                *  3. Hacer jugada            */

                                int num_esquinas_libres = 0; // LO HE HECHO ASÏ PORQUE NO SABÏA QUE SE PODÍA USAR LISTAS
                                for (int i = 0; i <= espacios_libres.length - 1; i++) {
                                    if (espacios_libres[i] == 1 || espacios_libres[i] == 3 || espacios_libres[i] == 7 || espacios_libres[i] == 9) {
                                        num_esquinas_libres ++;
                                    }
                                }

                                int [] esquinas_libres = new int [num_esquinas_libres];
                                int index_esquina = 0;
                                for (int i = 0; i <= espacios_libres.length - 1; i++) {
                                    if (espacios_libres[i] == 1 || espacios_libres[i] == 3 || espacios_libres[i] == 7 || espacios_libres[i] == 9) {
                                        esquinas_libres[index_esquina] = espacios_libres[i];
                                        index_esquina ++;
                                    }
                                }

                                if (esquinas_libres.length > 1) {
                                    int essquina_random = random.nextInt(esquinas_libres.length);
                                    jugada_ordenador_real = esquinas_libres[essquina_random];
                                    verificando = false;
                                    System.out.println("La jugada del ordenador es " + jugada_ordenador_real);
                                } else if (esquinas_libres.length == 1) {
                                    jugada_ordenador_real = esquinas_libres[0];
                                    verificando = false;
                                    System.out.println("La jugada del ordenador es " + jugada_ordenador_real);
                                } else {

                                    // JUEGA EN LADO RANDOM SI ESTÁ LIBRE
                                    if (show_bot_instructions) {
                                        System.out.println("El ordenador intenta ocupar un lado random");
                                    }

                                    /* Lógica para mover a un lado:
                                     *  1. Del array espacios libres sacamos los lados libres
                                     *  2. Index randon para el array lados libres
                                     *  3. Hacer jugada            */

                                    int num_lados_libres = 0; // LO HE HECHO ASÏ PORQUE NO SABIA QUE SE PODÍA USAR LISTAS
                                    for (int i = 0; i <= espacios_libres.length - 1; i++) {
                                        if (espacios_libres[i] == 1 || espacios_libres[i] == 3 || espacios_libres[i] == 7 || espacios_libres[i] == 9) {
                                            num_lados_libres ++;
                                        }
                                    }

                                    int [] lados_libres = new int [num_lados_libres];
                                    int index_lado = 0;
                                    for (int i = 0; i <= espacios_libres.length - 1; i++) {
                                        if (espacios_libres[i] == 1 || espacios_libres[i] == 3 || espacios_libres[i] == 7 || espacios_libres[i] == 9) {
                                            lados_libres[index_lado] = espacios_libres[i];
                                            index_lado ++;
                                        }
                                    }

                                    if (lados_libres.length > 1) {
                                        int lado_random = random.nextInt(lados_libres.length);
                                        jugada_ordenador_real = lados_libres[lado_random];
                                        verificando = false;
                                        System.out.println("La jugada del ordenador es " + jugada_ordenador_real);
                                    } else if (lados_libres.length == 1) {
                                        jugada_ordenador_real = lados_libres[0];
                                        verificando = false;
                                        System.out.println("La jugada del ordenador es " + jugada_ordenador_real);
                                    }
                                }
                            } /* if (verificando) */
                        }// while (verificando)


                        // HACIENDO JUGADA ORDENADOR EN TABLERO REAL
                        if (jugada_ordenador_real == 1) {
                            tablero[0][0] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 2) {
                            tablero[0][1] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 3) {
                            tablero[0][2] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 4) {
                            tablero[1][0] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 5) {
                            tablero[1][1] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 6) {
                            tablero[1][2] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 7) {
                            tablero[2][0] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 8) {
                            tablero[2][1] = ficha_ordenador;
                        } else if (jugada_ordenador_real == 9) {
                            tablero[2][2] = ficha_ordenador;
                        }

                        // MOSTRAR TABLERO
                        System.out.println("[" + tablero[0][0] + "] ["+ tablero[0][1] +"] ["+ tablero[0][2] + "]");
                        System.out.println("[" + tablero[1][0] + "] ["+ tablero[1][1] +"] ["+ tablero[1][2] + "]");
                        System.out.println("[" + tablero[2][0] + "] ["+ tablero[2][1] +"] ["+ tablero[2][2] + "]");
                        System.out.println(" ");


                        // VERIFICAR SI HA GANADO
                                // Verificando Horizontales
                        if ((tablero[0][0] == ficha_ordenador && tablero[0][1] == ficha_ordenador && tablero[0][2] == ficha_ordenador) ||
                                (tablero[1][0] == ficha_ordenador && tablero[1][1] == ficha_ordenador && tablero[1][2] == ficha_ordenador) ||
                                (tablero[2][0] == ficha_ordenador && tablero[2][1] == ficha_ordenador && tablero[2][2] == ficha_ordenador) ||
                                // Verificando Verticales
                                (tablero[0][0] == ficha_ordenador && tablero[1][0] == ficha_ordenador && tablero[2][0] == ficha_ordenador) ||
                                (tablero[0][1] == ficha_ordenador && tablero[1][1] == ficha_ordenador && tablero[2][1] == ficha_ordenador) ||
                                (tablero[0][2] == ficha_ordenador && tablero[1][2] == ficha_ordenador && tablero[2][2] == ficha_ordenador) ||
                                // Verificando Diagonales
                                (tablero[0][0] == ficha_ordenador && tablero[1][1] == ficha_ordenador && tablero[2][2] == ficha_ordenador) ||
                                (tablero[0][2] == ficha_ordenador && tablero[1][1] == ficha_ordenador && tablero[2][0] == ficha_ordenador)){
                            System.out.println("HAS PERDIDO :(");
                            partida_tres_en_raya = false;
                        }

                        // VERIFICAMOS SI EL TABLERO ESTÁ COMPLETO (EMPATE)
                        boolean tablero_lleno = true;
                        for (int i = 0; i <= tablero.length - 1; i ++) {
                            for (int j = 0; j <= tablero[i].length - 1; j ++) {
                                if (tablero[i][j] == ' ') {
                                    tablero_lleno = false;
                                }
                            }
                        }
                        if (tablero_lleno) {
                            System.out.println("EMPATE :P");
                            partida_tres_en_raya = false;
                        }

                        turno_jugador = true;

                    } // (!turno_jugador && partida_tres_en_raya == true)
                }// while (partida_tres_en_raya)


                // VOLVER A JUGAR
                System.out.println(" ");
                System.out.println("¿Quieres volver a jugar?");
                String volver_jugar_TeR = "";
                Scanner inputx = new Scanner(System.in);
                boolean salir_bucle = false; // reemplazar por "exit4"
                while (!salir_bucle) {
                    System.out.print("Volver a jugar (si o no): ");
                    volver_jugar_TeR  = inputx.next();
                    char [] entry = volver_jugar_TeR .toCharArray();
                    if (entry[0] == 's'){
                        salir_bucle = true;
                    } else if (entry[0] == 'n') {
                        jugando_tres_en_raya = false;
                        salir_bucle = true;
                    }inputx.nextLine();
                }
                System.out.println(" ");
            } // while (jugando_tres_en_raya)








            // NUEVO JUEGO AHORCADO
            while (jugando_ahorcado) {

                //                                                      TABLERO AHORCADO
                //                                                          +---+ --> TERCER FAllO (elementos de la fila[0] = tableros[0][2-5])
                //                         CUARTO FALLO (tablero[1][2]) --> |   |
                //                         QUINTO FALLO (tablero[2][2]) --> O   |
                //                                                  1* --> /|\  | --> SEGUNDO FALLO (elementos de la columna[6][0-5])
                //                                                  2* --> / \  |
                //                                                              |
                //                                                        ======== --> PRIMER FALLO (elementos fila[6][0-7])
                // 1* SEXTO FALLO: tablero[3][2]
                //    SEPTIMO FALLO: tablero[3][1]
                //    OCTAVO FALLO: tablero[3][3]

                // 2* NOVENO FALLO: tablero[4][1]
                //    DÉCIMO FALLO: tablero[4][3]

                // ARRAY TABLERO
                char [][] tablero_A = new char [8][8];

                // BUCLE FOR PARA RELLENAR LOS ESPACIOS VACIOS DEL ARRAY CON --> ' ' (si no se ve raro al imprimirlo)
                for (int i = 0; i < tablero_A.length - 1; i ++) {
                    for (int j = 0; j < tablero_A[0].length; j ++) {
                        if (tablero_A[i][j] == '\u0000') {
                            tablero_A[i][j] = ' ';
                        }
                    }
                }

                // ARRAY ANNIMALES
                String [] palabras = {"hormiga","babuino","tejon","murcielago","oso","castor","camello","gato","almeja","cobra","pantera","coyote","cuervo","ciervo","perro","burro","pato","aguila","huron","zorro","rana","cabra","ganso","halcon","leon","lagarto","llama","topo","mono","alce","raton","mula","salamandra","nutria","buho","panda","loro","paloma","piton","conejo","carnero","rata","cuervo","rinoceronte","salmon","foca","tiburon","oveja","mofeta","perezoso","serpiente","araña","cigüeña","cisne","tigre","sapo","trucha","pavo","tortuga","comadreja","ballena","lobo","cebra"};


                System.out.println("A H O R C A D O");

                // ARRAY PARA MOSTRAR LAS LETRAS INCORRECTAS
                int num_errores = 10;
                char [] letras_incorrectas = new char [num_errores];

                // PALABRA SECRETA random_index --> (0 / palabras-length)
                int posicion_palabra = random.nextInt(palabras.length - 1);
                String palabra_secreta = palabras[posicion_palabra];
                char [] secret_word = palabra_secreta.toCharArray(); // Función para pasar String a char [] array

                // ARRAY LETRAS CORRECTAS
                char [] letras_correctas = new char [palabra_secreta.length()];

                // ARRAY TODAS LAS LETRAS
                char [] letras_posibles = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};

                // FALLOS
                System.out.println(" ");
                System.out.println("¿Quieres jugar en dificultad fácil o dificultad difícil?");
                System.out.println(" ");
                System.out.println("1 --> DIFÍCIL");
                System.out.println("2 --> FÁCIL");
                System.out.println(" ");
                int dificultad = 0;
                int fallos = -1;

                Scanner dificulty = new Scanner(System.in);
                boolean es_entero;
                while (fallos !=  0 && fallos != 4) {
                    System.out.print("Dificultad: ");
                    es_entero = dificulty.hasNextInt();
                    if (es_entero) {
                        dificultad = dificulty.nextInt();
                        if (dificultad == 2) {
                            fallos = 0;
                        } else if (dificultad == 1) {
                            fallos = 4; // Si es dificultad 1 añadimos los tres primeros fallos al tablero
                        }  else {
                            System.out.println("Introduce un número 1 o 2");
                        }

                    } else {
                        System.out.println("Introduce un número 1 o 2");
                    }
                    dificulty.nextLine();
                }

                // AÑADIENDO LOS 4 PRIMEROS FALLOS AL ARRAY DEL TABLERO EN CASO DE DIFICULTAD DIFÍCIL
                if (fallos == 4) {
                    // PRIMER FALLO
                    for (int i = 0; i <= tablero_A[6].length - 1; i ++) {
                        tablero_A[6][i] = '=';
                    }

                    // SEGUNDO FALLO
                    for (int i = 0; i <= tablero_A.length - 1; i ++) {
                        if (i != 0 && i != 6) {
                            tablero_A[i][6] = '|';
                        } else {
                            tablero_A[0][6] = '+';
                        }
                    }

                    // TERCER FALLO
                    for (int i = 0; i <= tablero_A[0].length - 1; i ++) {
                        if (i > 2 && i < 6) {
                            tablero_A[0][i] = '-';
                        } else if (i == 2 || i == 6) {
                            tablero_A[0][i] = '+';
                        }
                    }

                    // CUARTO FALLO (añadir al tablero)
                    tablero_A[1][2] = '|';
                }

                // COMIENZA EL JUEGO
                boolean acertando = true;
                while (acertando) {

                    // BUCLE PARA IMPRIMIR TABLERO
                    for (int i = 0; i < tablero_A.length - 1; i ++) {
                        for (int j = 0; j < tablero_A[0].length; j ++) {
                            System.out.print(tablero_A[i][j]);
                        }
                        System.out.println(' ');
                    }

                    // IMPREIMIR LETRAS INCORRECTAS
                    System.out.print("Letras incorrectas: ");
                    for (int i = 0; i <= letras_incorrectas.length - 1; i ++) {
                        if (letras_incorrectas[i] != '\u0000'){
                            System.out.print(letras_incorrectas[i] + " ");
                        }
                    }
                    System.out.println(" ");

                    // IMPRIMIENDO PALABRA CON --> '_'    // CAMBIOS QUE ME HA SUGERIDO INTELLIJ
                    for (char letter : letras_correctas){ // char letter : letras_correctas) --> int i = 0; i <= letras_correctas.length -1; i ++
                        if (letter == '\u0000'){          // letter --> letras_correctas[i]
                            System.out.print('_'+ " ");
                        }else{
                            System.out.print(letter + " ");// letter --> letras_correctas[i]
                        }
                    }
                    System.out.println(" ");


                    // INTENTO JUGADOR
                    char letra = ' ';
                    String intento = "";
                    boolean exit2 = false;

                    // BUCLE PARA VALIDAR LA ENTRADA
                    while (!exit2){
                        boolean repetida = false;
                        System.out.print("Adivina una letra: ");
                        intento = entrada.next();
                        char [] input_array = intento.toCharArray(); // CONVERTIMOS LA ENTRADA EN --> char [] array
                        if (input_array.length != 1) { // Si hay más de un caracter
                            System.out.println("Debes introducir solo una letra");
                        }else{
                            letra = input_array[0]; // Si solo hay una letra la declaramos en letra

                            // BUCLE FOR PARA VERIFICAR QUE LETRA ESTÁ EN EL ARRAY --> letras_posibles (que contiene todas las letras)
                            for (int i = 0; i <= letras_posibles.length - 1; i ++) {
                                if (letra == letras_posibles[i]) {
                                    exit2 = true;
                                    break;
                                }
                            }
                            if (!exit2) { // SI NO ESTÁ BIEN
                                System.out.println("Debes introducir una letra a-z minúscula");
                                letra = ' ';
                            } else {
                                // VERIFICAMOS QUE NO HAYA ESCRITO ESTA LETRA ANTES
                                for (int i = 0; i <= letras_incorrectas.length - 1; i ++) { // SI ESTÁ EN --> letras_incorrectas
                                    if (letra == letras_incorrectas[i]) {
                                        repetida = true;
                                        break;
                                    }
                                }
                                for (int i = 0; i <= letras_correctas.length - 1; i ++) { // SI ESTÁ EN --> letras_correctas
                                    if (letra == letras_correctas[i]) {
                                        repetida = true;
                                        break;
                                    }
                                }
                                if (repetida) {
                                    System.out.println("Ya has escrito esta letra");
                                    exit2 = false;
                                }
                            }
                        }
                        entrada.nextLine(); // Limpiamos Scanner
                    } // BUCLE DE VALIDACIÓN DE LA ENTRADA

                    // VERIFICAR SI LA LETRA ESTÁ EN LA PALABRA SECRETA
                    boolean letra_correcta = false;
                    for (int i = 0; i <= secret_word.length - 1; i ++){
                        if (letra == secret_word[i]) {
                            letras_correctas[i] = letra;
                            letra_correcta = true;
                        }
                    }
                    // SI LETRA ES INCORRECTA (añadimos dibujo al tablero)
                    //   0 1 2 3 4 5 6 7 8
                    // 0     + - - - +
                    // 1     |       |
                    // 2     0       |
                    // 3   / | \     |
                    // 4   /   \     |
                    // 5             |
                    // 6 = = = = = = = = =
                    if (!letra_correcta) {
                        letras_incorrectas[fallos] = letra; // AÑADIMOS A LETRAS INCORRECTAS

                        System.out.println("Letra incorrecta :(");
                        System.out.println(" ");

                        if (fallos == 0) {
                            // PRIMER FALLO (añadir al tablero)
                            for (int i = 0; i <= tablero_A[6].length - 1; i ++) {
                                tablero_A[6][i] = '=';
                            }

                        } else if (fallos == 1) {
                            // SEGUNDO FALLO (añadir al tablero)
                            for (int i = 0; i <= tablero_A.length - 1; i ++) {
                                if (i != 0 && i != 6) {
                                    tablero_A[i][6] = '|';
                                } else {
                                    tablero_A[0][6] = '+';
                                }
                            }

                        } else if (fallos == 2) {
                            // TERCER FALLO (añador al tablero)
                            for (int i = 0; i <= tablero_A[0].length - 1; i ++) {
                                if (i > 2 && i < 6) {
                                    tablero_A[0][i] = '-';
                                } else if (i == 2 || i == 6) {
                                    tablero_A[0][i] = '+';
                                }
                            }

                        } else if (fallos == 3) {
                            // CUARTO FALLO (añadir al tablero)
                            tablero_A[1][2] = '|';

                        } else if (fallos == 4) {
                            // QUINTO FALLO (añadir al tablero)
                            tablero_A[2][2] = 'O';

                        } else if (fallos == 5) {
                            // SEXTO FALLO (añadir al tablero)
                            tablero_A[3][2] = '|';
                        } else if (fallos == 6) {
                            // SÉPTIMO FALLO (añadir al tablero)
                            tablero_A[3][1] = '/';
                        } else if (fallos == 7) {
                            // OCTAVO FALLO (añadir al tablero)
                            tablero_A[3][3] = '\\';
                        } else if (fallos == 8) {
                            // NOVENO FALLO (añadir al tablero)
                            tablero_A[4][1] = '/';
                        } else if (fallos == 9) {
                            // DÉCIMO FALLO (añadir al tablero)
                            tablero_A[4][3] = '\\';
                        }
                        fallos ++;

                        // Verificando si ha perdido
                        if (fallos == 10) {
                            System.out.println("Has perdido AHORCADO!!! :(");
                            System.out.println("La palabra era " + palabra_secreta);
                            // Bucle para imprimir tablero
                            for (int i = 0; i < tablero_A.length - 1; i ++) {
                                for (int j = 0; j < tablero_A[0].length; j ++) {
                                    System.out.print(tablero_A[i][j]);
                                }
                                System.out.println(' ');
                            }
                            acertando = false;
                        }
                    } else {
                        System.out.println("Letra correcta!!!");
                        System.out.println(" ");

                        boolean ha_ganado = true;
                        // Verificando si ha ganado
                        for (char letter: letras_correctas){ // CAMBIOS QUE ME HA SUGERIDO INTELLIJ
                            if (letter == '\u0000') {
                                ha_ganado = false;
                            }
                        }
                        if (ha_ganado) {
                            System.out.println("SÍ HAS GANADO :)");
                            System.out.println("La palabra es " + palabra_secreta);

                            acertando = false;
                        }
                    }
                }
                // VOLVER A JUGAR
                System.out.println(" ");
                System.out.println("¿Quieres volver a jugar?");
                String volver = "";
                Scanner play_again = new Scanner(System.in);
                boolean salir_volviendo_a_jugar_ahorcado = false;
                while (!salir_volviendo_a_jugar_ahorcado) {
                    System.out.print("Volver a jugar (si o no): ");
                    volver = play_again.next();
                    char [] entry = volver.toCharArray();
                    if (entry[0] == 's' || entry[0] == 'S'){
                        salir_volviendo_a_jugar_ahorcado = true;
                    } else {
                        jugando_ahorcado = false;
                        salir_volviendo_a_jugar_ahorcado = true;
                    } play_again.nextLine();
                }
            }
        }
    }
}
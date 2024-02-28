# practicaMinijuegos
Practica para ciclo superior

LÓGICA PROGRAMA --> TRES EN RAYA / AHORCADO

Bucle principal:

Menú principal:
		
Un switch para elegir
1. JUGAR TRES EN RAYA
		2. JUGAR AHORCADO
		3. SALIR

	Tres en raya:

	Bucle principal del juego:

Definimos algunas arrays y variables necesarias.

El jugador escoge algunas cosas:

Ficha
				Y si quiere ver cómo funciona el algoritmo del bot --> *
				Se escoge al azar quien empieza

Turno jugador:

Bucle que verifica todo sobre el intento del jugador

Imprimimos tablero

Verificamos si ha ganado

Verificamos si han empatado

Turno ordenador:
	
Definimos arrays y variables necesarias para realizar algunas pruebas en un tablero no real	
				* Si solo hay una jugada posible hacer esa jugada 
				
Bucle decidiendo jugada del ordenador:

Probamos todas las jugadas a ver si hay una ganadora
					Probamos todas las jugadas del jugador y si puede ganar lo bloqueamos
					Jugamos en el centro
					Jugamos en esquina random
					Jugamos en lado random

Imprimimos tablero

Verificamos si ha ganado

Verificamos si han empatado

Ahorcado:

Bucle principal del ahorcado:

Definimos variables y arrays necesarios

El jugador escoge dificultad:

Hacemos cambios de algunas variables según dificultad

Bucle mientras el jugador acierta la palabra:

Verificamos todos los errores sobre la entrada
					Que sea un solo caracter
					Que sea una letra del abecedario
					Que no esté repetida

Si es incorrecta:

Hacemos los cambios necesarios para imprimir bien el tablero
					Verificamos si ha perdido
				
Si es correcta:

Hacemos cambios necesarios para mostrar bien la palabra secreta
					Verificamos si ha ganado
				

			


A lo largo del programa hay bastantes bucles de control de errores y mucho código repetido, ya que no podemos utilizar métodos o funciones.
	

* Esto lo añadí para arreglar una cosa se quedaba bloqueado el programa, cuando el ordenador era el últmimo y sólo queda una tirada,  

package main

import (
	"fmt"
)

func saludar(ch chan bool) {

	fmt.Println("¡Hola desde la goroutine!")
	// nombre_chanel <- valor
	ch <- true
}

func main() {
	// se crea un chanel de tipo bool. Puede ser de cualquier tipo
	// pero en este caso se usa bool para indicar que la goroutine ha terminado
	channel := make(chan bool)

	// Se llama a la goroutine con el termino "go nombre_función(canal)".
	// Esto permite que la función se ejecute en paralelo con el resto del programa.
	// se usa la función go para ejecutar la función saludar en una goroutine
	// Esto permite que el programa principal no se bloquee y pueda continuar ejecutándose
	// mientras la goroutine se ejecuta en paralelo.
	go saludar(channel)

	// Esto es necesario para que el programa principal no termine antes de que la goroutine haya terminado su ejecución.
	// Se espera a que la goroutine envíe un valor al canal.
	// Mientras no llegue la señal del goroutine es funcion no sigue ejecutandose
	<-channel
	// tambien se puede usar el valor enviado por el chanel
	// nom_var := <-channel

	fmt.Println("El programa principal terminó.")
}

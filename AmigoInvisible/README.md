Este proyecto implementa el juego "Amigo Invisible" en Java. Los jugadores se asignan un amigo invisible de forma aleatoria, y las asignaciones se muestran en un formato específico.

## Clases Principales

### Persona
Representa a una persona en el juego, con un nombre y un amigo invisible al que debe hacer un regalo.

### Club
Gestiona a todos los participantes del juego, almacenando un conjunto de personas y asignándoles amigos invisibles de forma aleatoria.

### ClubManager
Gestiona la lectura de datos de entrada, la asignación de amigos invisibles y la presentación de los resultados en consola o archivo.

### Excepciones
- **AmigoException**: Excepción personalizada que maneja errores específicos del juego.

## Funcionalidades

1. Asigna amigos invisibles de manera aleatoria, asegurando que nadie se regale a sí mismo.
2. Permite leer datos desde un archivo y mostrar los resultados en consola o en un archivo de salida.
3. Permite excluir parejas o familias de la asignación de amigos invisibles.

## Uso

1. Crea un archivo de texto con los nombres de los participantes.
2. Ejecuta el programa para asignar amigos invisibles y ver los resultados.

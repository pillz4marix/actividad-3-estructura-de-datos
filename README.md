# actividad-3-estructura-de-datos
ACTIVIDAD 3 ESCAPE DEL LABORATORIO

Descripción
Esta actividad resuelve tres desafios de programación utilizando las tecnicas de recursividad divide y venceras y backtracking, el objetivo es aplicar estas tecnicas para resolver distintos problemas y encontrar la ruta mas corta dentro de un laberinto

Que problema resuelve la actividad
La actividad plantea un reto tipo Escape del Laboratorio donde cada desafio representa un problema diferente, los dos primeros desafios generan una contraseña y el tercero encuentra la ruta mas corta para salir de un laberinto considerando diferentes caminos y obstaculos

COMO FUNCIONA CADA DESAFIO

Desafio 1 - Recursividad
Recibe un numero entero y suma sus digitos de forma recursiva, si el resultado todavia tiene mas de un digito vuelve a repetir el proceso hasta obtener un unico digito, los resultados de los tres numeros forman la primera parte de la contraseña

Desafio 2 - Divide y Venceras
Encuentra el valor maximo de un arreglo utilizando la estrategia de divide y venceras, el arreglo se divide en dos partes, cada mitad se resuelve de forma recursiva y al final se comparan los maximos obtenidos para encontrar el mayor valor del arreglo

Desafio 3 - Backtracking
Resuelve un laberinto buscando la ruta mas corta desde el punto de inicio S hasta la salida E, el algoritmo explora diferentes caminos evita ciclos marcando las posiciones visitadas y conserva la ruta de menor longitud encontrada

Que tecnica se utilizó
Se utilizó recursividad para reducir un numero hasta un solo digito mediante la suma de sus digitos, tambien se utilizó divide y venceras para encontrar el valor maximo de un arreglo dividiendo el problema en partes mas pequeñas y combinando los resultados, finalmente se utilizó backtracking para explorar diferentes rutas dentro del laberinto regresar cuando un camino no es valido y conservar la ruta mas corta encontrada

Como ejecutar el programa
Abrir el proyecto en NetBeans o en cualquier IDE compatible con Java, ejecutar la clase Main, el programa resolvera automaticamente los tres desafios y mostrara los resultados en la consola

Como se obtiene la solución
Primero el desafio 1 genera la Clave 1, despues el desafio 2 genera la Clave 2, ambas claves se unen con el formato CLAVE1-CLAVE2, finalmente el desafio 3 encuentra la ruta mas corta del laberinto y muestra las posiciones visitadas la ruta final y las metricas de la busqueda

Que decisiones importantes tome durante la implementación
Separe cada desafio en una clase diferente para mantener el proyecto mas organizado, utilice metodos recursivos en los desafios 1 y 2 para cumplir con las restricciones de la actividad, en el desafio 3 utilice una matriz de posiciones visitadas para evitar ciclos durante la exploración, tambien implemente una poda de busqueda para dejar de explorar rutas que ya eran mas largas que la mejor ruta encontrada y asi reducir exploraciones innecesarias

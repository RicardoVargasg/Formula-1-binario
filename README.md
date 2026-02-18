Desarrolla una aplicación sencilla en Java para gestionar la información básica de los pilotos de Fórmula 1 de una temporada. Los datos se almacenan en un fichero binario y se cargan en memoria para su tratamiento mediante colecciones.
Fichero pilotos_f1.dat (binario)
• El fichero pilotos_f1.dat será un fichero binario que contendrá objetos Piloto serializados mediante ObjectOutputStream.
• Para generarlo puedes usar una clase auxiliar tipo CrearPilotosF1Binario
Colección a utilizar
• Utiliza una colección en memoria para guardar los pilotos, por ejemplo:
• List<Piloto> pilotos = new ArrayList<>();.
• Para comprobar si existe un piloto con el mismo nombre, puedes recorrer la lista o apoyarte en un Map<String, Piloto> opcional (clave = nombre).
Métodos (comportamiento requerido)
1. Cargar pilotos
• Leer el fichero binario pilotos_f1.dat usando FileInputStream y ObjectInputStream.
• Leer objetos Piloto en un bucle hasta detectar el final del fichero (EOFException).
• Guardar todos los pilotos leídos en la colección (por ejemplo, List<Piloto>).
• Controlar las posibles excepciones de entrada/salida y ClassNotFoundException.
2. Mostrar pilotos
• Recorrer la colección de pilotos y mostrar por pantalla todos los datos de cada uno 
(toString() o formato propio).
3. Añadir nuevo piloto
• Solicitar al usuario: nombre, escudería y puntos (por ejemplo, con Scanner).
• Comprobar si ya existe un piloto con el mismo nombre en la colección:
• Si no existe, crear un nuevo objeto Piloto y añadirlo a la colección.
• Si ya existe, mostrar un mensaje indicando que no se puede duplicar el 
nombre.
4. Buscar piloto
• Solicitar al usuario el nombre de un piloto.
• Recorrer la colección:
• Si se encuentra un piloto con ese nombre, mostrar toda su información.
• Si no se encuentra ninguno, mostrar mensaje de “no encontrado”.
5. Guardar datos
• Guardar la lista completa de pilotos en el fichero 
binario pilotos_f1.dat usando FileOutputStream y ObjectOutputStream.
• Recorrer la colección y escribir cada objeto Piloto con writeObject.
• El fichero debe sobrescribirse con el contenido actualizado (es decir, abrir 
el FileOutputStream sin modo append)

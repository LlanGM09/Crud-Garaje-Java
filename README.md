# CRUD Garaje Java 🚗💻

**CRUD Garaje Java** es un sistema de gestión de autos en consola, desarrollado en **Java** con **MySQL** y **JDBC**, diseñado con buenas prácticas de programación orientada a objetos, validaciones de entrada y manejo seguro de credenciales.

---

## ⚙️ Funcionalidades principales

Este proyecto implementa un **CRUD completo** de autos:

1. **Listar autos:** Muestra todos los autos registrados en formato de tabla profesional.  
2. **Agregar autos:** Permite registrar un auto nuevo con validación de campos obligatorios.  
3. **Actualizar autos:** Modifica los datos de un auto existente por su ID.  
4. **Eliminar autos:** Elimina un auto por su ID de forma segura.  
5. **Buscar autos por marca:** Búsqueda insensible a mayúsculas/minúsculas.  
6. **Manejo de errores y mensajes claros:** Confirmaciones y advertencias claras para el usuario.  

---

## 🛠️ Tecnologías utilizadas

- **Java 17+**  
- **MySQL 8+**  
- **JDBC**  
- **dotenv-java** (manejo seguro de credenciales)  
- **Maven**  

---


## 📂 Estructura del proyecto
Crud/
├── src/
│ ├── main/java/com/garaje/dao/AutoDao.java # DAO para CRUD de autos
│ ├── main/java/com/garaje/menu/Menu.java # Menú profesional en consola
│ ├── main/java/com/garaje/modelo/Auto.java # Modelo Auto
│ ├── main/java/com/garaje/modelo/Motor.java # Modelo Motor
│ ├── main/java/com/garaje/util/ConfigDB.java # Configuración de conexión segura
│ ├── main/java/org/example/Main.java # Clase principal
│ └── main/java/com/garaje/principal/PruebaConexion.java # Prueba de conexión
├── pom.xml
├── .gitignore
├── README.md
└── LICENSE

---



---

## ⚡ Configuración del proyecto

1. **Crear archivo `.env`** en `src/main/resources`:

```env
DB_URL=jdbc:mysql://localhost:3306/garaje_db
DB_USER=root
DB_PASSWORD=tu_contraseña
```
---

## Compilar y ejecutar el proyecto desde IntelliJ o terminal:

mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"

---

🎮 Ejemplo de uso

=== MENÚ GARAJE ===
1. Listar autos
2. Agregar auto
3. Actualizar auto
4. Eliminar auto
5. Buscar por marca
6. Salir
Seleccione una opción: 1

ID    Marca           Modelo          Tipo Motor   Pot.
-------------------------------------------------------------
1     Toyota          Yaris           Gasolina     130
3     Toyota          Corolla X Cross Diesel       160
4     Mazda           CX-5            Gasolina     187

Seleccione una opción: 2
Ingrese marca: Audi
Ingrese modelo: R8
Ingrese tipo de motor: Gasolina
Ingrese potencia: 150
✅ Auto agregado correctamente.


---

🌟 Características profesionales

Código limpio y modular (DAO, modelos, menú).

Validaciones de entrada para evitar datos incorrectos.

Manejo seguro de credenciales con .env.

 Escalable a Spring Boot, API REST o GUI.

Mensajes claros y amigables para el usuario.

---

👨‍💻 Autor

Llan Carlos Gutierrez Meriño

---

📜 Licencia

Este proyecto está bajo la licencia MIT.
Consulta el archivo LICENSE para más detalles.





## 🔹 Estructura del proyecto


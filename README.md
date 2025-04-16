# Universidad Técnica del Norte  
**Proyecto: Calculadora VLSM**  
**Nombre:** Diego Cuaycal  
**Carrera:** Ingeniería en Software  
**Materia:** Aplicaciones Móviles  
**Docente:** MSc. Diego Trejo  

---

## 📱 Descripción del Proyecto

Este es un proyecto académico desarrollado en **Android Studio utilizando Java**, que consiste en una aplicación móvil para el cálculo de subredes mediante **VLSM (Variable Length Subnet Mask)**. Permite ingresar una red base, un prefijo, definir múltiples subredes, validar la entrada y obtener resultados de direccionamiento automáticamente.

El sistema fue probado en **emuladores Pixel 6 API 33 (P65)** y **Pixel 5 API 36**, logrando un correcto funcionamiento de todas sus funcionalidades.

---

## ✨ Características

- Ingreso de:
  - Red base (IP)
  - Prefijo de máscara
  - Número de subredes
- Formulario dinámico para agregar:
  - Nombres de subredes
  - Tamaños requeridos
- Validaciones en tiempo real:
  - IP vacía o incorrecta
  - Prefijo fuera de rango
  - Campos incompletos
- Cálculo automático de:
  - Dirección de subred
  - Máscara
  - Prefijo
  - Rango asignable
  - Dirección broadcast
- Visualización clara en tarjetas individuales por subred.
- Botón **"Nuevo Cálculo"** para reiniciar el proceso.

---

## 📸 Capturas de Pantalla

### 1️⃣ Ingreso de Red Padre, Prefijo y Cantidad de Subredes
Se ingresan los datos iniciales de la red.
> ![Ingreso de red base](./screenshots/captura1_red_base.png)

---

### 2️⃣ Formulario dinámico para ingresar subredes
Subredes con nombre y cantidad de hosts requeridos.
> ![Subredes creadas](./screenshots/captura2_subredes_dinamicas.png)

---

### 3️⃣ Validaciones activas (campo vacío o datos inválidos)
Validación de campos incompletos y prefijos fuera de rango.
> ![Validación de subred incompleta](./screenshots/captura3_validacion_faltante.png)
> ![Validación de prefijo](./screenshots/captura4_validacion_prefijo.png)

---

### 4️⃣ Comparación con ejercicio matemático de VLSM
Ejercicio resuelto manualmente y graficado.
> ![Ejercicio matemático VLSM](./screenshots/captura5_ejercicio_manual.png)

---

### 5️⃣ Resultados generados por la aplicación
Muestra final del cálculo con todos los parámetros.
> ![Resultados del cálculo](./screenshots/captura6_resultado_app.png)

---

## ▶️ Cómo Usar

1. Ingresar IP base y prefijo de máscara.
2. Especificar el número de subredes requeridas.
3. Ingresar nombre y tamaño de cada subred.
4. Presionar **CALCULAR** para generar los resultados.
5. Si deseas empezar un nuevo cálculo, presiona **Nuevo Cálculo**.

---

## 🛠️ Tecnologías Utilizadas

- **Android Studio**
- **Java**
- XML para diseño de interfaces
- Git y GitHub

---


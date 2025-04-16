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
> ![image](https://github.com/user-attachments/assets/2eb15fc7-c36b-4cdc-a4c2-53631582ed77)


---

### 2️⃣ Formulario dinámico para ingresar subredes
Subredes con nombre y cantidad de hosts requeridos.
> ![image](https://github.com/user-attachments/assets/9b61bf37-6760-489c-a405-b32b954dbc3f)


---

### 3️⃣ Validaciones activas (campo vacío o datos inválidos)
Validación de campos incompletos y prefijos fuera de rango.
> ![image](https://github.com/user-attachments/assets/d693d2e8-d80d-44ce-8c52-e93c85a1e099)
> ![image](https://github.com/user-attachments/assets/4dab258d-4a0a-4f0a-a1a8-9ebefbb864f0)


---

### 4️⃣ Comparación con ejercicio matemático de VLSM
Ejercicio resuelto manualmente y graficado.
> ![image](https://github.com/user-attachments/assets/5913329e-84ee-4d7f-98bd-869ffac9bd23)


---

### 5️⃣ Resultados generados por la aplicación
Muestra final del cálculo con todos los parámetros.
> ![image](https://github.com/user-attachments/assets/a213617a-ff3f-4854-95a0-4975ffe05483)


---

### 🖼️ Evidencia general del proyecto
Vista completa del funcionamiento visual de la aplicación.  
> ![image](https://github.com/user-attachments/assets/2e69cdae-c937-46f9-98a8-afdb455c8fdd)


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


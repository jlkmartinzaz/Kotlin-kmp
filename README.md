# Kotlin KMP API con XAMPP

Este proyecto tiene como objetivo crear una **API utilizando Kotlin Multiplatform (KMP)** y consumirla o integrarla en un entorno local usando **XAMPP**.

## 🧩 Descripción

La idea principal es:

* Desarrollar la lógica compartida con **Kotlin Multiplatform**
* Exponer funcionalidades como una **API**
* Utilizar **XAMPP (Apache + PHP)** como entorno local para pruebas o integración

> ⚠️ Nota: Kotlin KMP no depende de XAMPP directamente. XAMPP se usa como entorno de servidor local para simular consumo o integración.

---

## 🏗️ Tecnologías utilizadas

* Kotlin Multiplatform (KMP)
* Kotlin/JVM (backend o lógica)
* XAMPP (Apache, PHP)
* HTTP / REST API

---

## 🚀 ¿Qué hace este proyecto?

* Define lógica compartida en Kotlin
* Expone endpoints (API)
* Permite consumir la API desde un entorno local (XAMPP)

---

## ⚙️ Estructura del proyecto

```bash
.
├── shared/          # Código compartido KMP
├── backend/         # Lógica de servidor (si aplica)
├── xampp/           # Archivos para pruebas con Apache/PHP
└── README.md
```

---

## 🔧 Requisitos

* JDK 11 o superior
* Android Studio o IntelliJ IDEA
* XAMPP instalado
* Git

---

## ▶️ Cómo ejecutar

### 1. Clonar el repositorio

```bash
git clone https://github.com/jlkmartinzaz/Kotlin-kmp.git
cd Kotlin-kmp
```

---

### 2. Ejecutar el backend (Kotlin)

Dependiendo de tu configuración:

```bash
./gradlew run
```

o desde IntelliJ/Android Studio.

---

### 3. Iniciar XAMPP

* Abre XAMPP
* Inicia **Apache**
* Coloca los archivos en la carpeta:

```bash
htdocs/
```

---

### 4. Consumir la API

Puedes usar:

* navegador
* Postman
* o scripts en PHP dentro de XAMPP

Ejemplo:

```bash
http://localhost/api/endpoint
```

---

## 📌 Notas importantes

* KMP se usa para compartir lógica, no para reemplazar el servidor web
* XAMPP actúa como entorno local de pruebas
* Puedes sustituir XAMPP por cualquier cliente HTTP

---

## 🧠 Futuras mejoras

* Integrar Ktor como servidor oficial
* Dockerizar el entorno
* Añadir autenticación
* Documentar endpoints con Swagger

---

## 👨‍💻 Autor

* GitHub: https://github.com/jlkmartinzaz

---

# Musical Battle

![GitHub top language](https://img.shields.io/github/languages/top/FedeBayer/musicalBattle?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/FedeBayer/musicalBattle?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/FedeBayer/musicalBattle?style=for-the-badge)
![GitHub pull requests](https://img.shields.io/github/issues-pr/FedeBayer/musicalBattle?style=for-the-badge)

## Introduction

Este trabajo especial está orientado a practicar el paradigma orientado a objetos y se practican elementos como:
POO - Colaboración y responsabilidad de los objetos - Herencia, polimorfismo y binding dinámico - Clase vs instancia - Modificadores de acceso - Clase abstracta - 
Dinámico vs estático - Interfaces - Patrones de diseño como Composite y Strategy.


<div align="center">
  <img src="https://img.freepik.com/premium-vector/abstract-music-background-vinyl-disk-explosion-vector-illustration_3482-3933.jpg?w=2000" width="20%"></img>
</div>


<details close="true">
  <summary><b>:gear: &nbsp;1 Objetivo</b></summary>

  Dado el reciente éxito de los realities, en especial el último de canciones, un canal de la competencia (cuya identidad no podemos revelar) decidió armar su propio reality de canto. Para poder organizarse mejor y facilitar la tarea de selección de participantes, armado de equipos y demás menesteres, la producción de dicho canal encargó la realización de un sistema para la apropiada administración de todo el reality.
  
En el reality participan un conjunto de coaches, que a su vez juegan el rol de jurados, y un conjunto de participantes. De los participantes, se registra su nombre, apellido, edad, géneros musicales de preferencia, idiomas en los que canta y los instrumentos que toca. La producción también almacena un conjunto de temas musicales que pueden ser cantados durante el reality. Cada tema musical tiene un título, un idioma, una lista de géneros musicales a los que pertenece y una lista de instrumentos musicales necesarios para interpretarlo durante el concurso (puede ser vacía).

  Cada coach/jurado tiene un listado de participantes asignados como equipo propio. Para una mejor organización, cada coach/jurado desea poder obtener:
● un listado de todos los instrumentos que pueden tocar los participantes de su equipo (no
debe haber repetidos)
  
● un listado de todos los idiomas que pueden cantar los participantes de su equipo (sin idiomas
repetidos)
  
● un listado de géneros de preferencia de los participantes de su equipo (sin repetidos y
ordenados alfabéticamente)
  
● El promedio de edad de su equipo
 
Durante el reality, se organizan batallas para decidir quién es expulsado del concurso en cada ronda.

Para poder organizar cada batalla, la producción del programa le pide a cada jurado que seleccione un participante de su equipo para cantar un determinado tema musical. Para esto y acorde al avance del programa se van solicitando a los jurados que busquen:
  
● Todos los participantes que canten en un determinado idioma, por ejemplo “inglés”.
  
● Todos los participantes que prefieran un determinado género, por ejemplo “rock”.
  
● Todos los participantes que canten en un determinado idioma y toquen un instrumento
específico.Por ejemplo, “Aleman” y “Guitarra”
  
● Todos los participantes que toquen “guitarra” y prefieran el género “balada” o que canten en
“inglés”.
  
● Todos los participantes mayores de una determinada edad.
  
● Los anteriores son algunos ejemplos de los listados que la producción le pide constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así como combinación lógicas de los existentes.
  
Uno de los jurados se puso exigente y solo permite agregar a su equipo participantes que al menos toquen un determinado instrumento, conozcan ciertos idiomas y prefieran un determinado género.
Puntualmente, solo permite agregar participantes que toquen la batería, puedan cantar en español e inglés, y que prefieran “pop”. Es posible que este jurado cambie en tiempo de ejecución su
restricción para aceptar participantes, aunque los participantes ya aceptados no se eliminan si cambia su preferencia por nuevos participantes.

En esta primer parte no se implementan las batallas
</details>

<details close="true">
  <summary><b>:gear: &nbsp;2 Objetivo</b></summary>

Continuando con la implementación del reality de canto en esta segunda parte se agrega a lo realizado en la primera parte las siguientes características.

Los participantes pueden estar organizados en grupos y bandas, un grupo o banda posee una lista de miembros que los componen (pueden ser integrantes o incluso sub bandas). Una banda o grupo posee un nombre, y una edad (la cual se calcula como el promedio de las edades de cada uno de sus miembros). Los géneros de preferencia se calculan como la intersección de los géneros de preferencia de todos sus miembros. Por ejemplo si un grupo tienen dos miembros A y B, el integrante A tiene preferencias {g1,g2,g3,g4} y el integrante B las preferencias {g1,g4,g7,g11} el grupo tendrá como preferencias de géneros {g1, g4}. En el caso de los idiomas que pueden interpretar una banda o grupo se considera la unión de los idiomas de todos sus miembros (no pueden existir repetidos), lo mismo ocurre para los instrumentos que puede tocar una banda.
  
Ahora cada coach/jurado tiene un listado de participantes asignados como equipo propio, este listado puede incluir Bandas, Grupos o Integrantes solistas.
Para una mejor organización, cada coach/jurado desea poder obtener:

  ● Un listado de todos los instrumentos que pueden tocar los participantes de su equipo (no debe haber repetidos)

  ● Un listado de todos los idiomas que pueden cantar los participantes de su equipo (sin idiomas repetidos)
  
  ● Un listado de géneros de preferencia de los participantes de su equipo (sin repetidos y ordenados alfabéticamente)
  
  ● El promedio de edad de su equipo

Para las batallas, se desea que cada uno de los coachs/jurados pueda buscar entre sus participantes integrantes, bandas o grupos que :

  ● Canten en un determinado idioma, por ejemplo “inglés”

  ● Prefieren un determinado género, por ejemplo “rock”.

  ● Canten en un determinado idioma y toquen un instrumento específico. Por ejemplo, “Aleman” y “Guitarra”

  ● Todos los participantes mayores de una determinada edad.

  ● Puedan Interpretar un determinado Tema Musical

  ● Los anteriores son algunos ejemplos de los listados que la producción le pide constantemente a los jurados. Se pueden agregar nuevos requerimientos de búsquedas así como combinación lógicas de los existentes.

Aclaraciones sobre la búsqueda de participantes:

  1. Si una banda o grupo cumple con lo que está buscando el jurado, se debe retornar la banda o el grupo entero (respetando la organización interna de grupos y subgrupos)

  2. Si una banda o grupo NO cumple con lo que está buscando el jurado, se buscan posibles miembros de la banda que sí cumplan y se retorna a estos miembros.

  3. El mecanismo anterior se repite en cada nivel organizativo que tenga la banda o grupo.

  4. Un tema puede ser interpretado por una banda/grupo/solista si puede cantar en el idioma del tema y al menos uno de los géneros está entre las preferencias del grupo/banda/solista.Sin embargo, para los temas de la final se debe chequear además de lo anterior que la
</details>

<details close="true">
  <summary><b>:gear: &nbsp;Ejemplo resultados</b></summary>
  
```java
Informacion de equipos de Coach

Nombres de participantes de  equipo de coach: Lautaro
Instrumentos: 
[Guitarra, Piano]
Promedio edad: 
32.0
Generos de preferencia: 
[Jazz, Rock]


Nombres de participantes de  equipo de coach: Valentin
Instrumentos: 
[Guitarra, Piano, Violin, Bateria, Bajo]
Promedio edad: 
30.222222222222225
Generos de preferencia: 
[]
///////////////////////////////////
Criterios de participantes para batallas


Participantes que cantan en Ingles: 
[Banda Banda2 [miembros=[Participante [nombre=Kevin, apellido=Yante, edad=41, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Ignacio, apellido=Varne, edad=22, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Banda Banda1 [miembros=[Participante [nombre=Carlos, apellido=Celor, edad=27, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Juan, apellido=Zon, edad=39, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Participante [nombre=Pedro, apellido=Lanz, edad=17, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]]
]]
]
Participantes que su genero preferido es Rock: 
[Participante [nombre=Pedro, apellido=Lanz, edad=17, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]
Participantes que cantan en Aleman y tocan Guitarra: 
[Banda Banda2 [miembros=[Participante [nombre=Kevin, apellido=Yante, edad=41, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Ignacio, apellido=Varne, edad=22, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Banda Banda1 [miembros=[Participante [nombre=Carlos, apellido=Celor, edad=27, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Juan, apellido=Zon, edad=39, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Participante [nombre=Pedro, apellido=Lanz, edad=17, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]]
]]
]
Participantes que son mayores a 19 años: 
[Banda Banda2 [miembros=[Participante [nombre=Kevin, apellido=Yante, edad=41, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Ignacio, apellido=Varne, edad=22, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Banda Banda1 [miembros=[Participante [nombre=Carlos, apellido=Celor, edad=27, generosMusicalesPreferencia=[Musica clasica, Musica electronica], idiomas=[Aleman, Frances], instrumentos=[Violin, Bateria]]
, Participante [nombre=Juan, apellido=Zon, edad=39, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
, Participante [nombre=Pedro, apellido=Lanz, edad=17, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]]
]]
]
Participantes que pueden interpretar tema1: 
[Participante [nombre=Pedro, apellido=Lanz, edad=17, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]
///////////////////////////////////
Criterios con combinaciones logicas

Participantes que toquen “guitarra” y prefieran el género “balada” O que canten en “inglés”: 
[Participante [nombre=Marcos, apellido=Celor, edad=19, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]
Participantes que toquen “guitarra” y prefieran el género “balada” Y que canten en “inglés”: 
[]
Participantes que NO prefieran el género “balada” y NO toquen guitarra: 
[Participante [nombre=Marcos, apellido=Celor, edad=19, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
]
///////////////////////////////////
Coach exigente


Coach exigente: Lautaro agrega a participante: Marcos ? 
false
Coach exigente: Lautaro cambio genero requerido de Pop a Rock 

Coach exigente: Lautaro agrega a participante: Marcos ? 
true


///////////////////////////////////
Lista para batalla
[Participante [nombre=Franco, apellido=Reter, edad=30, generosMusicalesPreferencia=[Rock, Jazz], idiomas=[Español, Ingles], instrumentos=[Guitarra, Piano]]
, Participante [nombre=Franco, apellido=Reter, edad=30, generosMusicalesPreferencia=[Electro, Dupstep], idiomas=[Japones], instrumentos=[Bajo]]
]


/////////
Batallas 

Lautaro vs Ulises
Ganador es: Empate

Por puntos
Lautaro vs Ulises
Ganador es: Lautaro

Marcos vs Carlos
Resultado = Empate

```
 
</details>



### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/FedeBayer/portfolio-BackEnd.git
   ```
2. Execute main.java (Reality/Main.java)

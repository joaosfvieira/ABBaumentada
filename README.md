# Árvore Binária Aumentada

# Compilação

Antes de tudo, é necessário instalar o OpenJDK JRE seguindo o procedimento abaixo:
```
sudo apt install default-jre
```
Depois, para checar se foi corretamente instalado:
```
java -version
```
Saída esperada:
```
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment (build 11.0.11+9-Ubuntu-0ubuntu2)
OpenJDK 64-Bit Server VM (build 11.0.11+9-Ubuntu-0ubuntu2, mixed mode)
```
Finalmente, para compilar o programa basta entrar no diretório onde o mesmo foi baixado e digitar:
```
javac Arvore.java Node.java
```
# Execução

O programa necessita de dois arquivos de texto para ser executado, o primeiro contendo os números inteiros a serem inseridos na ABB, separados por um espaço, o segundo com uma lista de comandos que farão as chamadas dos métodos desenvolvidos. A execução deve se parecer com isso:
```
java Arvore numerosArvore.txt comandosArvore.txt
```
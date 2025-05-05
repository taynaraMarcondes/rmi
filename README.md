# Medidor de Distâncias RMI

Este projeto demonstra uma aplicação cliente-servidor utilizando a tecnologia RMI (Remote Method Invocation) em Java. O servidor disponibiliza métodos para calcular a distância Euclidiana e a distância City Block entre conjuntos de dados, enquanto o cliente permite ao usuário selecionar o tipo de cálculo e visualizar os resultados, identificando o par de dados mais similar.

## Estrutura do Código

O projeto é composto por três arquivos principais:

-   **`Distance.java` (Interface):** Define a interface com os métodos remotos que o servidor implementa `euclidean` e `cityBlock`.
-   **`Distancemeter.java` (Servidor):** Implementa a interface `Distance` e contém a lógica para calcular as distâncias Euclidiana e City Block, além de comparar os resultados para identificar o par mais similar.
-   **`Client.java` (Cliente):** Uma aplicação que se conecta ao servidor RMI, apresenta um menu ao usuário para escolher o tipo de cálculo de distância e exibe os resultados retornados pelo servidor.
-   **`Server.java` (Inicializador do Servidor):** Responsável por iniciar o registro RMI, instanciar o objeto remoto `Distancemeter`, exportá-lo e registrá-lo no registro RMI para que os clientes possam encontrá-lo.

## Como Usar o Código

Siga os passos abaixo para compilar e executar o código:

### Pré-requisitos

-   Java Development Kit (JDK) instalado e configurado no seu sistema.

### Compilação

1.  Abra dois terminais ou prompts de comando.
2.  No primeiro terminal, navegue até o diretório onde os arquivos `.java` estão salvos e execute o seguinte comando para compilar todos os arquivos:

    ```bash
    javac *.java
    ```

### Execução do Servidor

1.  No mesmo terminal onde você compilou os arquivos, execute o servidor com o seguinte comando:

    ```bash
    java Server
    ```

    Você deverá ver a mensagem "Servidor Pronto!" indicando que o servidor está em execução e aguardando conexões de clientes. Por padrão, o servidor se registra no `localhost` na porta `1099`.

### Execução do Cliente (Local)

1.  No segundo terminal (também navegando até o diretório do código), execute o cliente com o seguinte comando:

    ```bash
    java Client
    ```

    O cliente tentará se conectar ao registro RMI rodando no `localhost` na porta `1099`.

### Execução do Cliente (Remoto - Substituindo localhost)

Se o servidor estiver rodando em uma máquina diferente na mesma rede, você precisará substituir `localhost` pelo endereço IP da máquina do servidor ao executar o cliente.

1.  **No código `Client.java`:** Antes de compilar, você pode alterar a linha que obtém o registro RMI para usar o IP do servidor:

    ```java
    Registry registry = LocateRegistry.getRegistry("IP_DO_SERVIDOR", 1099);
    ```

    Substitua `IP_DO_SERVIDOR` pelo endereço IP real da máquina onde o servidor está rodando.

2.  Após modificar (se necessário), compile o cliente novamente:

    ```bash
    javac Client.java
    ```

3.  Execute o cliente no segundo terminal, **sem alterar o comando de execução**:

    ```bash
    java Client
    ```

    O cliente agora tentará se conectar ao servidor no IP especificado.

### Interface do Cliente

Ao executar o cliente, você verá o seguinte menu:
```
	    | 		Pétala (mm) 	| 		Sépala (mm)
Objeto 	| Largura    | Altura   | Largura    | Altura
 	 A 	| 	 5.1 	 | 	 3.5 	| 	 1.4 	 | 	 0.2
 	 B 	| 	 5.9 	 | 	 3.0 	| 	 5.1 	 | 	 1.8
 	 C 	| 	 4.9 	 | 	 3.1 	| 	 1.5 	 | 	 0.1
```
Selecione uma das opções:

-   **`0 - Sair`:** Encerra a execução do cliente.
-   **`1 - Distância Euclidiana`:** Envia uma solicitação ao servidor para calcular a distância Euclidiana entre os conjuntos de dados A, B e C. O servidor retornará as distâncias A-B, A-C e B-C, indicando o par mais similar com base nessa métrica.
-   **`2 - Distância City Block`:** Envia uma solicitação ao servidor para calcular a distância City Block (Manhattan) entre os conjuntos de dados A, B e C. O servidor retornará as distâncias A-B, A-C e B-C, indicando o par mais similar com base nessa métrica.

Após selecionar uma opção de cálculo, o cliente exibirá os resultados fornecidos pelo servidor e apresentará o menu novamente até que a opção de sair (0) seja escolhida.
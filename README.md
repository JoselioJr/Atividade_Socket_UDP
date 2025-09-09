# Sistema de Sensores com Servidor UDP em Java

Este projeto demonstra o uso de **sockets UDP** em Java para simular vários sensores enviando leituras (como temperatura e umidade) para um servidor central.  
O servidor exibe em tempo real a última leitura de cada sensor conectado.

---

## 📌 Estrutura

- **Servidor.java** → Servidor que escuta em uma porta fixa (12345).  
  Recebe mensagens UDP e mantém um mapa com a última leitura de cada sensor.

- **Sensor.java** → Simula um sensor.  
  Gera leituras aleatórias (temperatura e umidade) e envia periodicamente para o servidor.  
  O nome do sensor é passado como argumento na linha de comando.

---

## ▶️ Como executar

1. No terminal execute (dentro da pasta do projeto):

```bash
javac Servidor.java Sensor.java
```

2. Execute:
```bash
java Servidor
```
3. Abra outro terminal e inicie os sensores (clientes)
```bash
java Sensor Sensor1
java Sensor Sensor2
java Sensor Sensor3
```

Cada cliente envia uma leitura a cada 1 segundo.
Você pode rodar quantos sensores quiser, cada um com um nome diferente.

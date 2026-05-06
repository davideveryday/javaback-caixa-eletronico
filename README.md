# Caixa Eletrônico em Java

Projeto em Java que simula o funcionamento de um caixa eletrônico com operações básicas e interface gráfica.

## Funcionalidades

- Saque com cálculo automático de cédulas  
- Relatório de cédulas disponíveis  
- Consulta do valor total no caixa  
- Reposição de cédulas  
- Definição de cota mínima  
- Exibição de extrato ao sair  
- Botão para popular o caixa automaticamente  

## Regras

- O saque utiliza as maiores cédulas possíveis  
- Limite de até 30 cédulas por saque  
- Caso não seja possível realizar o saque:  
  "Saque não realizado por falta de cédulas"  
- Se o caixa ficar abaixo do mínimo:  
  "Caixa Vazio: Chame o Operador"  

## Estrutura

- CaixaEletronico.java —  lógica do sistema  
- Interface.java — interface gráfica  
- ICaixaEletronico.java — contrato de métodos  

## Como executar

1. Compile o projeto  
2. Execute a classe `Interface`  

## Observações

Projeto desenvolvido para fins acadêmicos.

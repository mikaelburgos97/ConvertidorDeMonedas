# Conversor de Monedas

Este proyecto es un Conversor de Monedas implementado en Java que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

## Características

- Obtiene tasas de cambio actualizadas de ExchangeRate-API
- Permite al usuario especificar una moneda base
- Muestra tasas de cambio para una lista predefinida de monedas populares
- Utiliza Gson para el análisis de respuestas JSON

## Requisitos previos

- Java JDK 11 o superior
- Maven (opcional, pero recomendado para manejar dependencias)
- Una clave API de ExchangeRate-API (ya incluida en el código)

## Configuración

1. Clone este repositorio:
   ```
   git clone https://github.com/mikaelburgos97/ConvertidorDeMonedas/
   cd ConvertidorDeMonedas
   ```

2. Si no está usando Maven, descargue el JAR de Gson y añádalo a su classpath.

## Uso

1. Compile el proyecto:
   ```
   javac ConversorMonedas.java
   ```

2. Ejecute el programa:
   ```
   java ConversorMonedas
   ```

3. Cuando se le solicite, ingrese la moneda base (por ejemplo, USD).

4. El programa mostrará las tasas de cambio para una lista predefinida de monedas populares.

## Personalización

- Para cambiar las monedas mostradas, modifique el array `interestedCurrencies` en el método `displayRates`.
- Para usar una clave API diferente, actualice la constante `API_KEY` al principio de la clase.

## Contribuir

Las contribuciones son bienvenidas. Por favor, abra un issue para discutir cambios importantes antes de enviar un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo `LICENSE` para más detalles.

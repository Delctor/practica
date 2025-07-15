# Memoria de la Práctica - Sistema de Gestión de Almacén de Leña

## Introducción

Esta memoria documenta las decisiones de diseño e implementación tomadas durante el desarrollo de un sistema de gestión para un almacén de leña en Java. El proyecto se desarrolló siguiendo una metodología incremental a través de varias etapas, cada una añadiendo funcionalidades específicas al sistema base.

## Etapa 1: Clase Básica

### Clase `Pueblo`

En esta primera etapa se implementó la clase fundamental del sistema:

- **Decisión**: Implementar como clase independiente con atributos básicos
- **Justificación**: Representa una entidad geográfica fundamental para el cálculo de costes de transporte
- **Atributos implementados**:
  - `nombre`: Identificador único del pueblo
  - `precioTransporte`: Coste asociado al transporte a este pueblo (valor por defecto: 10)
- **Funcionalidad**: Métodos getter/setter estándar y método `imprimeInformacion()`

## Etapa 2: Ampliación del Sistema

### Decisiones de Diseño

En esta etapa se añadieron las clases complementarias al sistema:

#### Clase `Cliente`
- **Decisión**: Asociación obligatoria con un pueblo
- **Justificación**: Todo cliente debe pertenecer a un pueblo para calcular costes de transporte
- **Atributos implementados**:
  - `nombre`: Identificador del cliente
  - `direccion`: Dirección específica del cliente
  - `pueblo`: Referencia al objeto Pueblo (composición)
- **Funcionalidad**: Métodos de acceso y modificación estándar

#### Clase `Pedido`
- **Decisión**: Usar variables estáticas para precios globales
- **Justificación**: Los precios por kilo y por bolsa son únicos para todo el almacén
- **Atributos implementados**:
  - `cliente`: Referencia al cliente que realiza el pedido
  - `fecha`: Timestamp automático de creación
  - `cantidad`: Kilos de leña solicitados
  - `bolsasAstillas`: Número de bolsas de astillas
  - `servido`: Estado del pedido (boolean)
  - Variables estáticas: `precioPorKilo`, `precioPorBolsa`
- **Funcionalidad**: Cálculo automático del precio total incluyendo transporte

#### Clase `AlmacenLenya`
- **Decisión**: Usar ArrayList para gestionar colecciones
- **Justificación**: Flexibilidad para añadir/eliminar elementos dinámicamente
- **Atributos implementados**:
  - `pueblos`: Lista de pueblos servidos
  - `clientes`: Lista de clientes registrados
  - `pedidos`: Lista de pedidos realizados
  - `lenya`: Stock actual de leña (entero)
- **Funcionalidad**: Métodos para añadir elementos y marcar pedidos como servidos

## Etapa 3: Herencia, Polimorfismo y Mejoras Avanzadas

### Decisiones de Diseño Avanzado

En esta etapa final se implementaron conceptos avanzados de programación orientada a objetos:

#### Clase `PedidoPersonalizado`
- **Decisión**: Herencia de la clase `Pedido`
- **Justificación**: Reutilizar funcionalidad base añadiendo características específicas
- **Nuevas funcionalidades**:
  - Proporciones personalizadas de leña (pequeña, mediana, grande)
  - Validación de que las proporciones sumen 100%
  - Coste adicional por personalización
- **Polimorfismo aplicado**:
  - Override del método `calcularPrecio()` para incluir coste adicional
  - Override del método `imprimeInformacion()` para mostrar detalles específicos

#### Clase `AlmacenLenyaV2`
- **Decisión**: Crear versión mejorada mediante herencia de `AlmacenLenya`
- **Justificación**: Mantener compatibilidad con versión original mientras se añaden mejoras avanzadas

#### Nuevas Funcionalidades en AlmacenLenyaV2

1. **Control de Duplicados**:
   - Verificación de nombres únicos para pueblos y clientes
   - Validación de pedidos únicos por cliente no servido
   - **Decisión**: Prevenir inconsistencias en los datos

2. **Gestión de Stock**:
   - Verificación de disponibilidad antes de crear pedidos
   - Reducción automática del stock al crear pedidos
   - **Decisión**: Garantizar coherencia entre pedidos y stock disponible

3. **Control de Ganancias**:
   - Seguimiento acumulativo de ingresos por pedidos servidos
   - **Decisión**: Proporcionar métricas de negocio

4. **Análisis de Datos**:
   - Cálculo de leña pendiente por pueblo
   - Cálculo de leña necesaria para pedidos del último mes
   - **Decisión**: Facilitar la planificación y gestión del almacén

## Arquitectura del Sistema

### Evolución del Desarrollo

El desarrollo siguió una progresión lógica:

1. **Etapa 1**: Establecimiento de la entidad básica (`Pueblo`)
2. **Etapa 2**: Expansión con entidades relacionadas y gestión básica (`Cliente`, `Pedido`, `AlmacenLenya`)  
3. **Etapa 3**: Aplicación de conceptos avanzados (herencia con `PedidoPersonalizado` y mejoras con `AlmacenLenyaV2`)

### Clases Implementadas

El sistema desarrollado consta de las siguientes clases principales:

1. **`Pueblo`** - Entidad básica que representa poblaciones
2. **`Cliente`** - Gestión de clientes del almacén  
3. **`Pedido`** - Clase base para pedidos estándar
4. **`PedidoPersonalizado`** - Extensión de Pedido con personalización
5. **`AlmacenLenya`** - Gestión básica del almacén
6. **`AlmacenLenyaV2`** - Versión mejorada con funcionalidades avanzadas

### Diagrama de Relaciones

Las clases mantienen las siguientes relaciones:
- `Cliente` → `Pueblo` (composición)
- `Pedido` → `Cliente` (asociación)
- `PedidoPersonalizado` → `Pedido` (herencia)
- `AlmacenLenyaV2` → `AlmacenLenya` (herencia)
- `AlmacenLenya` → {`Pueblo`, `Cliente`, `Pedido`} (agregación)

## Patrones de Diseño Aplicados

### 1. Composición
- **Cliente-Pueblo**: Relación de composición donde el cliente tiene un pueblo
- **Pedido-Cliente**: Asociación donde el pedido referencia a un cliente

### 2. Herencia
- **PedidoPersonalizado**: Extiende Pedido añadiendo funcionalidad específica
- **AlmacenLenyaV2**: Extiende AlmacenLenya con mejoras adicionales

### 3. Polimorfismo
- Métodos sobrescritos para comportamientos específicos en clases derivadas
- Uso de variables estáticas para datos compartidos

## Decisiones Técnicas Relevantes

### Gestión de Fechas
- **Decisión**: Usar `java.util.Date` para timestamps automáticos
- **Justificación**: Simplicidad y compatibilidad con versiones de Java

### Manejo de Colecciones
- **Decisión**: `ArrayList` para todas las colecciones
- **Justificación**: Flexibilidad y facilidad de uso para operaciones CRUD

### Encapsulación
- **Decisión**: Atributos protegidos en clase base para herencia
- **Decisión**: Métodos package-private para simplicidad en el contexto educativo

### Validaciones
- **Decisión**: Validaciones en métodos de negocio en lugar de setters
- **Justificación**: Lógica de negocio centralizada y más flexible

## Conclusiones

El desarrollo del sistema siguió un enfoque incremental que permitió:

1. **Construcción sólida**: Base robusta en las primeras etapas
2. **Extensibilidad**: Fácil adición de nuevas funcionalidades
3. **Mantenibilidad**: Código bien estructurado y documentado
4. **Reutilización**: Aprovechamiento de herencia y polimorfismo

### Lecciones Aprendidas

- El desarrollo incremental por etapas permitió una construcción sólida del sistema
- Comenzar con una clase simple (`Pueblo`) facilitó la comprensión del dominio del problema
- La incorporación gradual de entidades y relaciones en la etapa 2 (`Cliente`, `Pedido`, `AlmacenLenya`) estableció una base funcional completa
- La aplicación de herencia y mejoras en la etapa 3 (`PedidoPersonalizado`, `AlmacenLenyaV2`) demostró la potencia de la programación orientada a objetos
- La documentación Javadoc mejora significativamente la mantenibilidad del código
- Las clases de prueba proporcionadas por la universidad validaron el correcto funcionamiento del sistema

### Posibles Mejoras Futuras

1. Implementación de interfaces para mayor flexibilidad
2. Uso de excepciones personalizadas para mejor manejo de errores
3. Separación de lógica de presentación y lógica de negocio
4. Implementación de persistencia de datos
5. Uso de patrones como DAO para acceso a datos

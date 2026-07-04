# MCP server (borrador de especificacion)

Servidor MCP de solo lectura para que un asistente de IA pueda consultar disponibilidad y presupuestos, sin poder crear, modificar ni cancelar reservas, y sin acceso a datos personales de clientes.

## buscar_disponibilidad

Parametros: ubicacion (string), fechaRecogida (fecha), fechaDevolucion (fecha), categoria (opcional).

Respuesta: lista de vehiculos disponibles agrupados por categoria, con precio base por dia y disponibilidad estimada.

## calcular_presupuesto

Parametros: categoria (string), fechaRecogida (fecha), fechaDevolucion (fecha), extras (lista opcional de codigos).

Respuesta: desglose de precio generado por el motor de reglas de tarifas (importe base, ajustes aplicados con su nombre e importe, importe de extras, total estimado). No crea ninguna reserva.

## listar_ubicaciones

Sin parametros obligatorios. Devuelve los puntos de recogida y devolucion disponibles, por ejemplo aeropuertos y oficinas por isla en Canarias.

## Reglas de diseno

El servidor no debe exponer herramientas de escritura. Ninguna respuesta debe incluir datos personales de clientes (nombres, emails, telefonos, matriculas). Toda respuesta de precio debe indicar explicitamente que es una estimacion sujeta a confirmacion en el momento de reservar. Las herramientas deben ser deterministas frente a la misma entrada, salvo por cambios reales de disponibilidad o tarifas.

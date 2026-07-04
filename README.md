# idea-rent-a-car

Borrador de diseno propio (no es codigo copiado de ningun repositorio de terceros) para modernizar la gestion de una empresa de alquiler de coches en Canarias. Pensado como punto de partida para que un equipo de desarrollo lo implemente sobre un stack propio, con licencia libre.

Se centra en tres piezas que no suelen venir resueltas en los sistemas de rent a car genericos: un motor de reglas de tarifas, un modulo de afiliados y comisiones, y un endpoint MCP de solo lectura para que asistentes de IA puedan consultar disponibilidad y precios.

## 1. Motor de reglas de tarifas

Idea central: en lugar de un precio fijo por coche, cada categoria de vehiculo tiene un precio base y una lista de reglas que se aplican en orden y modifican ese precio segun el contexto de la reserva.

### Modelo de datos (borrador)

RateRule: id, nombre (ej. Temporada alta agosto), categoriaVehiculo (economico, suv, lujo, o vacio si aplica a todas), tipo (TEMPORADA, ANTELACION, DURACION, DIA_SEMANA, EXTRA o RECARGO), fechaInicio, fechaFin, condicion (ej. antelacionDias mayor o igual a 30, duracionDias mayor o igual a 7), modificador (porcentaje o importe fijo, positivo o negativo), prioridad, acumulable (si se combina con otras reglas o es excluyente), activo.

TarifaBase: categoriaVehiculo, precioPorDia, deposito, kmIncluidos.

Extra: codigo (segundo conductor, gps, silla infantil, conductor joven), precioPorDia o precioUnico, aplicaAutomaticamente (por ejemplo recargo para conductor menor de 25 anos).

### Logica de calculo sugerida

Primero se busca la tarifa base de la categoria del vehiculo. Despues se filtran las reglas activas cuya condicion se cumpla para esa reserva (fechas, duracion, antelacion con la que se reserva, dia de recogida o devolucion). Luego se ordenan por prioridad y se aplican los modificadores acumulables, dejando que las reglas excluyentes solo permitan la de mayor prioridad. A continuacion se suman los extras seleccionados por el cliente y los recargos automaticos (conductor joven, entrega fuera de horario, entrega en otra isla o aeropuerto). Por ultimo se guarda el desglose completo, no solo el total, en la reserva, para poder mostrarlo al cliente y al admin y para auditoria.

Este enfoque es relevante en Canarias por la fuerte estacionalidad turistica (temporada alta en verano y en Navidad o Semana Santa) y porque muchas empresas locales cobran recargos por recogida o entrega entre islas o en aeropuerto.

## 2. Modulo de afiliados y comisiones

### Modelo de datos (borrador)

Affiliate: id, nombre o empresa, codigoReferido unico (ej. TEIDE10), tipoComision (porcentaje o importe fijo), valorComision, estado (pendiente, activo, suspendido), datos de facturacion.

AffiliateClick: affiliateId, timestamp, origen (utm_source, utm_campaign), dato tecnico anonimizado solo para analitica basica.

AffiliateConversion: affiliateId, reservaId, importeReserva, comisionCalculada, estado (pendiente, aprobada, pagada, anulada), fechaConversion.

### Flujo sugerido

Cada afiliado recibe un enlace o codigo propio. Al hacer una reserva con ese codigo, o con una cookie de atribucion con una ventana de por ejemplo 30 dias, el sistema crea una conversion en estado pendiente. Cuando la reserva se completa, es decir el coche se devuelve sin incidencias, la conversion pasa a aprobada y entra en el ciclo de liquidacion mensual. El panel de admin necesita una vista de reporting por afiliado con clics, conversiones, importe generado, comision pendiente y comision pagada, ademas de poder exportar liquidaciones.

## 3. Endpoint MCP de solo lectura

Idea: exponer un servidor MCP minimo, de solo lectura, para que un asistente de IA pueda consultar disponibilidad y presupuestos sin poder modificar reservas ni datos de clientes.

### Herramientas propuestas

buscar_disponibilidad: recibe ubicacion, fecha de recogida, fecha de devolucion y categoria opcional, y devuelve la lista de vehiculos disponibles con su precio base.

calcular_presupuesto: recibe categoria, fecha de recogida, fecha de devolucion y extras opcionales, y devuelve el desglose de precio aplicando el motor de reglas de tarifas, sin crear la reserva.

listar_ubicaciones: devuelve los puntos de recogida y devolucion, por ejemplo aeropuertos y oficinas por isla.

Puntos de diseno importantes: el servidor no debe tener acceso de escritura, es decir no crea, modifica ni cancela reservas, no debe devolver datos personales de clientes, y toda respuesta de precio debe indicar que es una estimacion sujeta a confirmacion en el momento de reservar.

## Proximos pasos

Definir el stack final, backend, base de datos y frontend admin, segun el equipo de desarrollo disponible. Prototipar primero el motor de reglas de tarifas, porque es la pieza que mas valor aporta frente a un sistema generico. Anadir el modulo de afiliados una vez el flujo de reservas este estable. Dejar el servidor MCP para el final, una vez el motor de tarifas y disponibilidad tengan una API interna solida sobre la que apoyarse.

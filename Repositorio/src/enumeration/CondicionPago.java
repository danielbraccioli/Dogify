package enumeration;

/**
 * ¿Cuáles son los tipos de comprobantes a emitir?
 * Los tipos de factura y/o tickets a emitir por cada venta o locación de servicio que realice, 
 * dependerán del sujeto con el que se opere.
 * 
 * Cuando se trate de una operación entre un Responsable Inscripto y Monotributista, Consumidor 
 * Final, o Exento, el Responsable Inscripto deberá emitir comprobantes tipo “B”.
 * Si se trata de operaciones entre responsables inscriptos, existen 3 tipos de comprobantes 
 * que se pueden utilizar:
 * Tio “A”
 * Tipo “A” con leyenda “pago en CBU informada”
 * Tipo “M”
 * En caso de que quien lo emita no sea un Responsable Inscripto (Monotributista; 
 * exento en el IVA), deberá operar con comprobantes tipo “C”.
 * Cuando se trate de una operación de exportación, corresponderá emitir comprobantes tipo “E”.
 *
 *	Fuente: http://www.afip.gob.ar/facturacion/
 *
 *	Para simplificar solo tenemos Factura A y B, y usaremos Responsable Inscripto y Consmudidor Final.
 */

public enum CondicionPago {
	ResponsableInscripto, ConsumidorFinal
}

export interface FxOperacion {
 id: number,
 monedaOrigen: string,
 monedaDestino: string,
 montoOrigen: number,
 montoDestino: number;
 tipoCambio: number,
 estado: string;
 fechaOperacion: Date,
 createdAt: Date;
}
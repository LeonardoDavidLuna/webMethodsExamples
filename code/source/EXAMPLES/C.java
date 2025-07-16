package EXAMPLES;

// -----( IS Java Code Template v1.2

import com.wm.util.Values;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.Session;
import com.wm.util.JournalLogger;
import com.wm.util.DebugMsg;
// --- <<IS-END-IMPORTS>> ---

public final class C

{
	// ---( internal utility methods )---

	final static C _instance = new C();

	static C _newInstance() { return new C(); }

	static C _cast(Object o) { return (C)o; }

	// ---( server methods )---



    public static final Values cService (Values in)
    {
        Values out = in;
		// --- <<IS-START(cService)>> ---
		// @specification EXAMPLES.C.INOUT:cINOUT
		// @subtype c
		// Declarar variables para los valores de entrada y el resultado
				double val1 = 0.0;
				double val2 = 0.0;
				double result = 0.0;
		
				try {
					// Obtener val1 del objeto Values de entrada
					// Se asume que val1 es un String que puede ser parseado a double
					String val1Str = in.getString("val1");
					if (val1Str != null) {
						val1 = Double.parseDouble(val1Str);
					} else {
						// Manejo de error si val1 no est\u00E1 presente o es nulo
						JournalLogger.logError(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE,
								"Input 'val1' is null or not found.");
					}
		
					// Obtener val2 del objeto Values de entrada
					// Se asume que val2 es un String que puede ser parseado a double
					String val2Str = in.getString("val2");
					if (val2Str != null) {
						val2 = Double.parseDouble(val2Str);
					} else {
						// Manejo de error si val2 no est\u00E1 presente o es nulo
						JournalLogger.logError(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE,
								"Input 'val2' is null or not found.");
					}
		
					// Realizar la suma
					result = val1 + val2;
		
					// Establecer el resultado en el objeto Values de salida
					// Aseg\u00FArate de que 'out' sea un nuevo objeto Values si no quieres modificar 'in' directamente.
					// En este caso, como 'out = in;' al principio, se est\u00E1 modificando el mismo objeto.
					// Si necesitas un objeto de salida diferente, deber\u00EDas crear uno nuevo:
					// Values newOut = new Values();
					// newOut.put("result", String.valueOf(result));
					// return newOut;
					out.put("result", String.valueOf(result)); // Convertir el resultado a String para almacenarlo
		
				} catch (NumberFormatException e) {
					// Manejo de error si los valores de entrada no son n\u00FAmeros v\u00E1lidos
					JournalLogger.logError(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE,
							"Error parsing input values to numbers: " + e.getMessage());
					// Puedes establecer un valor por defecto o un mensaje de error en 'result' si lo deseas
					out.put("result", "Error: Invalid number format");
				} catch (Exception e) {
					// Manejo de cualquier otra excepci\u00F3n inesperada
					JournalLogger.logError(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE,
							"An unexpected error occurred: " + e.getMessage());
					out.put("result", "Error: An unexpected error occurred");
				}
		
		    //out = ccService(Service.getSession(), in);
		// --- <<IS-END>> ---
        return out;
                
	}

	// --- <<IS-START-SHARED>> ---
	
	static {
	    try {
	        System.loadLibrary("EXAMPLES_C");
	        JournalLogger.log(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE, JournalLogger.INFO, 
				"Loading native library: EXAMPLES_C");
	    } catch (UnsatisfiedLinkError e) {
	        JournalLogger.logError(DebugMsg.LOG_MSG, JournalLogger.FAC_PACKAGE, 
				e.getMessage());
	    }
	}
	
	native static Values ccService(Session session, Values in);
		
	// --- <<IS-END-SHARED>> ---
}


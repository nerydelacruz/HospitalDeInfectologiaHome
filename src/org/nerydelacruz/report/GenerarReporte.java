package org.nerydelacruz.report;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.nerydelacruz.db.Conexion;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.io.InputStream;
public class GenerarReporte {
    public static void mostrarReporte(String nombreReporte,String titulo,Map parametros){
        InputStream reporte = GenerarReporte.class.getResourceAsStream(nombreReporte);
        try{
            JasperReport reporteMaestro = (JasperReport) JRLoader.loadObject(reporte);
            JasperPrint reporteImpreso = JasperFillManager.fillReport(reporteMaestro,parametros, Conexion.getInstancia().getConexion());
            JasperViewer visor = new JasperViewer(reporteImpreso,false);
            visor.setTitle(titulo);
            visor.setVisible(true);
        }catch (JRException ex) {
            Throwable cause = ex.getCause();
            cause.printStackTrace();
        }
    }

}

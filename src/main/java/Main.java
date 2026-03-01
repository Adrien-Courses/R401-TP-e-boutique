import controler.CatalogueServlet;
import controler.HelloServlet;
import controler.PanierServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8811);

        tomcat.getConnector(); // obligatoire

        // pointer vers ton dossier webapp
        String webappDir = "src/main/webapp";
        Context ctx = tomcat.addWebapp("", new File(webappDir).getAbsolutePath());

        Tomcat.addServlet(ctx, "hello", new HelloServlet());
        ctx.addServletMappingDecoded("/hello", "hello");

        Tomcat.addServlet(ctx, "panier", new PanierServlet());
        ctx.addServletMappingDecoded("/panier", "panier");

        Tomcat.addServlet(ctx, "catalogue", new CatalogueServlet());
        ctx.addServletMappingDecoded("/catalogue", "catalogue");

        System.out.println("App running at: http://localhost:8811/");

        tomcat.start();
        tomcat.getServer().await();
    }
}

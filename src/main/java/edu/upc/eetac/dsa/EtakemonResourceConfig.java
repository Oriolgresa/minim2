package edu.upc.eetac.dsa;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Created by OriolGresa on 21/12/16.
 */
public class EtakemonResourceConfig extends ResourceConfig {
    public EtakemonResourceConfig() {
        packages("edu.upc.eetac.dsa");
        packages("edu.upc.eetac.dsa.cors");
        register(RolesAllowedDynamicFeature.class);
        register(DeclarativeLinkingFeature.class);
    }
}


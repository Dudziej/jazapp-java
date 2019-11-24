package pl.edu.pjwstk.jaz.samples;

import pl.edu.pjwstk.jaz.samples.jpa.JpaExample;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ExamplesRunner implements ServletContextListener {

    @Inject
    private JpaExample jpaExample;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        jpaExample.runExample();
    }
}

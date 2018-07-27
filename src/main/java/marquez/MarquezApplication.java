package marquez;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

public class MarquezApplication extends Application<MarquezConfiguration> {
  public static void main(final String[] args) throws Exception {
    new MarquezApplication().run(args);
  }

  @Override
  public String getName() {
    return "MarquezApp";
  }

  @Override
  public void initialize(Bootstrap<MarquezConfiguration> bootstrap) {}

  @Override
  public void run(final MarquezConfiguration config, final Environment environment) {
    final JdbiFactory factory = new JdbiFactory();
    final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
  }
}
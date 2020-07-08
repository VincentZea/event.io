package io.event.api.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.linkedin.r2.filter.CompressionConfig;
import com.linkedin.r2.filter.FilterChain;
import com.linkedin.r2.filter.FilterChains;
import com.linkedin.r2.filter.compression.EncodingType;
import com.linkedin.r2.filter.compression.ServerCompressionFilter;
import com.linkedin.r2.filter.logging.SimpleLoggingFilter;
import com.linkedin.restli.server.RestLiConfig;
import com.linkedin.restli.server.guice.GuiceRestliServlet;
import io.event.api.db.*;

public class GuiceServletConfig extends GuiceServletContextListener {

  private static final int THRESHOLD = 4096;

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(
        new AbstractModule() {
          @Override
          protected void configure() {
            RestLiConfig restLiConfig = new RestLiConfig();
            restLiConfig.setResourcePackageNames("io.event.api.resources");
            bind(RestLiConfig.class).toInstance(restLiConfig);

            FilterChain filterChain = FilterChains.createRestChain(
                new ServerCompressionFilter(new EncodingType[]{EncodingType.SNAPPY}, new CompressionConfig(THRESHOLD)),
                new SimpleLoggingFilter());
            bind(FilterChain.class).toInstance(filterChain);
          }
        },
        new AbstractModule() {
          @Override
          protected void configure() {
            bind(String.class).annotatedWith(Names.named("PostgresqlDBUrl")).toInstance("jdbc:postgresql://localhost:5433/event.io");
            bind(String.class).annotatedWith(Names.named("PostgresqlDBUser")).toInstance("postgres");
            bind(String.class).annotatedWith(Names.named("PostgresqlDBPassword")).toInstance("password");
          }
        },
        new AbstractModule() {
          @Override
          protected void configure() {
            bind(UsersDB.class).to(PostgresqlUsersDB.class);
          }
        },
        new AbstractModule() {
          @Override
          protected void configure() {
            bind(EventsDB.class).to(PostgresqlEventsDB.class);
          }
        },
        new ServletModule() {
          @Override
          protected void configureServlets() {
            serve("/*").with(GuiceRestliServlet.class);
          }
        });
  }
}

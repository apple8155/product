package com.oneplan.product.product.config;

import org.apache.commons.lang3.StringUtils;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.IOException;
import java.util.List;

@Configuration
@EnableCassandraRepositories(basePackages = "com.oneplan.product.product.repository")
public class CassandraTestConfig extends AbstractCassandraConfiguration {

  @Value("${spring.data.cassandra.contact-points}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port:0000}")
  private int port;

  @Value("${spring.data.cassandra.keyspace}")
  private String keySpace;

  @Value("${spring.data.cassandra.username}")
  private String username;

  @Value("${spring.data.cassandra.password}")
  private String password;

  @Value("${spring.data.cassandra.schema-action}")
  private String schemaAction;

  public static int startCassandra() {
    int port = 0;
    try {
      EmbeddedCassandraServerHelper.startEmbeddedCassandra(
          EmbeddedCassandraServerHelper.CASSANDRA_RNDPORT_YML_FILE, 90000L);
      List<String> statements =
          new ClassPathCQLDataSet("cqlscripts/KeySpacesAndTables.cql", false, false)
              .getCQLStatements();
      statements.stream()
          .filter(statement -> StringUtils.isNotBlank(statement))
          .forEach(st -> EmbeddedCassandraServerHelper.getSession().execute(st));
      port = EmbeddedCassandraServerHelper.getNativeTransportPort();
    } catch (IOException e) {
    }
    return port;
  }

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.valueOf(schemaAction);
  }

  @Override
  protected String getLocalDataCenter() {
    return "datacenter1";
  }
}

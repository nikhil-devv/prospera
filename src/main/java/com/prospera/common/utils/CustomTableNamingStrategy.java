package com.prospera.common.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomTableNamingStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl {

    private static final String TABLE_PREFIX = "PROSPERA_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        if (name == null) {
            return null;
        }
        return Identifier.toIdentifier(TABLE_PREFIX + name.getText());
    }
}

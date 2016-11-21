package com.hoantran.flyway.support;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class FlywayMigration.
 */
public class FlywayMigration {

    /** Tracking system operations. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FlywayMigration.class);

    /** The migrate data source. */
    private DataSource migrateDataSource;

    /** The enable migration. */
    private boolean enableMigration;

    /** The is baseline. */
    private boolean isBaseline;

    /** The migrate script prefix. */
    private String migrateScriptPrefix;

    /** The migrate script separator. */
    private String migrateScriptSeparator;

    /** The migrate script suffix. */
    private String migrateScriptSuffix;

    /** The migrate table. */
    private String migrateTable;

    /**
     * Instantiates a new flyway migration.
     */
    public FlywayMigration() {
    }

    /**
     * Gets the migrate data source.
     *
     * @return the migrate data source
     */
    public DataSource getMigrateDataSource() {
        return migrateDataSource;
    }

    /**
     * Sets the migrate data source.
     *
     * @param migrateDataSource the new migrate data source
     */
    public void setMigrateDataSource(DataSource migrateDataSource) {
        this.migrateDataSource = migrateDataSource;
    }

    /**
     * Checks if is enable migration.
     *
     * @return true, if is enable migration
     */
    public boolean isEnableMigration() {
        return enableMigration;
    }

    /**
     * Sets the enable migration.
     *
     * @param enableMigration the new enable migration
     */
    public void setEnableMigration(boolean enableMigration) {
        this.enableMigration = enableMigration;
    }

    /**
     * Checks if is baseline.
     *
     * @return true, if is baseline
     */
    public boolean isBaseline() {
        return isBaseline;
    }

    /**
     * Sets the baseline.
     *
     * @param isBaseline the new baseline
     */
    public void setBaseline(boolean isBaseline) {
        this.isBaseline = isBaseline;
    }

    /**
     * Gets the migrate script prefix.
     *
     * @return the migrate script prefix
     */
    public String getMigrateScriptPrefix() {
        return migrateScriptPrefix;
    }

    /**
     * Sets the migrate script prefix.
     *
     * @param migrateScriptPrefix the new migrate script prefix
     */
    public void setMigrateScriptPrefix(String migrateScriptPrefix) {
        this.migrateScriptPrefix = migrateScriptPrefix;
    }

    /**
     * Gets the migrate script separator.
     *
     * @return the migrate script separator
     */
    public String getMigrateScriptSeparator() {
        return migrateScriptSeparator;
    }

    /**
     * Sets the migrate script separator.
     *
     * @param migrateScriptSeparator the new migrate script separator
     */
    public void setMigrateScriptSeparator(String migrateScriptSeparator) {
        this.migrateScriptSeparator = migrateScriptSeparator;
    }

    /**
     * Gets the migrate script suffix.
     *
     * @return the migrate script suffix
     */
    public String getMigrateScriptSuffix() {
        return migrateScriptSuffix;
    }

    /**
     * Sets the migrate script suffix.
     *
     * @param migrateScriptSuffix the new migrate script suffix
     */
    public void setMigrateScriptSuffix(String migrateScriptSuffix) {
        this.migrateScriptSuffix = migrateScriptSuffix;
    }

    /**
     * Gets the migrate table.
     *
     * @return the migrate table
     */
    public String getMigrateTable() {
        return migrateTable;
    }

    /**
     * Sets the migrate table.
     *
     * @param migrateTable the new migrate table
     */
    public void setMigrateTable(String migrateTable) {
        this.migrateTable = migrateTable;
    }

    /**
     * Migrate database.
     */
    public void migrateDatabase() {
        if (enableMigration) {
            LOGGER.info("========================= Start Flyway Migration ============================");

            // Create the Flyway instance
            Flyway flyway = new Flyway();

            // Point it to the database
            flyway.setDataSource(migrateDataSource);

            // Set properties for migration
            flyway.setBaselineOnMigrate(true);
            flyway.setSqlMigrationPrefix(migrateScriptPrefix);
            flyway.setSqlMigrationSeparator(migrateScriptSeparator);
            flyway.setSqlMigrationSuffix(migrateScriptSuffix);
            flyway.setTable(migrateTable);
            flyway.repair();

            // Start the migration
            flyway.migrate();
            LOGGER.info("========================= Finish Flyway Migration ============================");
        }
    }

}

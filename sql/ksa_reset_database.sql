
set echo on

whenever sqlerror continue

@ksa_drop_ddl.sql

whenever sqlerror exit failure

@ksa_create_ddl.sql
@ksa_config_dml.sql
@test_inserts/ksa_test_data_dml.sql
@ksa_constraints_ddl.sql

commit;

whenever sqlerror continue

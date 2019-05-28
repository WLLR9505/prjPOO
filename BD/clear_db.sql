BEGIN
  FOR i IN (SELECT   object_name, object_type FROM user_objects
            ORDER BY object_type DESC) LOOP

    /* Drop types in descending order. */
    IF i.object_type = 'TYPE' THEN

      /* Drop type and force operation because dependencies may exist. Oracle 12c
         also fails to remove object types with dependents in pluggable databases
         (at least in release 12.1). Type evolution works in container database
         schemas. */
      EXECUTE IMMEDIATE 'DROP '||i.object_type||' '||i.object_name||' FORCE';

    /* Drop table tables in descending order. */
    ELSIF i.object_type = 'TABLE' THEN

      /* Drop table with cascading constraints to ensure foreign key constraints
         don't prevent the action. */
      EXECUTE IMMEDIATE 'DROP '||i.object_type||' '||i.object_name||' CASCADE CONSTRAINTS';

      /* Oracle 12c ONLY: Purge the recyclebin to dispose of system-generated
         sequence values because dropping the table doesn't automatically 
         remove them from the active session.
         CRITICAL: Remark out the following when working in Oracle Database 11g. */
      EXECUTE IMMEDIATE 'PURGE RECYCLEBIN';

    ELSIF i.object_type = 'LOB' OR i.object_type = 'INDEX' THEN

      /* A system generated LOB column or INDEX will cause a failure in a
         generic drop of a table because it is listed in the cursor but removed
         by the drop of its table. This NULL block ensures there is no attempt
         to drop an implicit LOB data type or index because the dropping the
         table takes care of it. */
      NULL;
   
    ELSE

      /* Drop any other objects, like sequences, functions, procedures, and packages. */
      EXECUTE IMMEDIATE 'DROP '||i.object_type||' '||i.object_name;
      
    END IF;
  END LOOP;
END;
/

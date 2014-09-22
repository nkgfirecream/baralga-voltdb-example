package com.remast.baralga;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class DeleteProject extends VoltProcedure {

    public final SQLStmt deleteActivities = new SQLStmt("DELETE FROM PROJECT WHERE ID = ?;");

    public final SQLStmt deleteProject = new SQLStmt("DELETE FROM ACTIVITY WHERE PROJECT_ID = ?;");

    public VoltTable[] run(final String projectId) {
        voltQueueSQL(deleteActivities, projectId);
        voltQueueSQL(deleteProject, projectId);
        return voltExecuteSQL();
    }

}

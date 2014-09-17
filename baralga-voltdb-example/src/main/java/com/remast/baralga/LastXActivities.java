package com.remast.baralga;

import org.voltdb.SQLStmt;
import org.voltdb.VoltProcedure;
import org.voltdb.VoltTable;

public class LastXActivities extends VoltProcedure {

    public final SQLStmt lastXActivitiesSql = new SQLStmt("SELECT TOP ? * FROM ACTIVITY ORDER BY act_end ASC;");

    public VoltTable[] run(int x) {
        voltQueueSQL(lastXActivitiesSql, x);
        return voltExecuteSQL();
    }

}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flink.sql.launcher;


import com.dtstack.flink.sql.launcher.LauncherMain;

/**
 *   yarnPer提交任务时指定pluginLoadMode
 * Date: 2019/11/6
 * Company: www.dtstack.com
 * @author maqi
 */
public class PluginLoadModeTest {
    public static void testShipfileMode() throws Exception {
        String[] sql = new String[]{"--mode", "yarnPer", "-sql", "/Users/maqi/tmp/json/group_tmp4.txt", "-name", "PluginLoadModeTest",
                "-localSqlPluginPath", "/Users/maqi/code/dtstack/dt-center-flinkStreamSQL/plugins",
                "-remoteSqlPluginPath", "/Users/maqi/code/dtstack/dt-center-flinkStreamSQL/plugins",
                "-allowNonRestoredState", "false", "-flinkconf", "/Users/maqi/tmp/flink-1.8.1/conf",
                "-confProp", "{\"sql.checkpoint.cleanup.mode\":\"false\",\"sql.checkpoint.interval\":10000,\"time.characteristic\":\"EventTime\"}",
                "-yarnconf", "/Users/maqi/tmp/hadoop", "-flinkJarPath", "/Users/maqi/tmp/flink-1.8.1/lib", "-queue", "c", "-pluginLoadMode", "shipfile"};
        System.setProperty("HADOOP_USER_NAME", "admin");
        LauncherMain.main(sql);
    }

    public static void testClasspathMode() throws Exception {
        String[] sql = new String[]{"--mode", "yarnPer", "-sql", "/Users/maqi/tmp/json/group_tmp4.txt", "-name", "PluginLoadModeTest",
                "-localSqlPluginPath", "/Users/maqi/code/dtstack/dt-center-flinkStreamSQL/plugins",
                "-remoteSqlPluginPath", "/opt/dtstack/180_flinkplugin/sqlplugin",
                "-allowNonRestoredState", "false", "-flinkconf", "/Users/maqi/tmp/flink-1.8.1/conf",
                "-confProp", "{\"sql.checkpoint.cleanup.mode\":\"false\",\"sql.checkpoint.interval\":10000,\"time.characteristic\":\"EventTime\"}",
                "-yarnconf", "/Users/maqi/tmp/hadoop", "-flinkJarPath", "/Users/maqi/tmp/flink-1.8.1/lib", "-queue", "c", "-pluginLoadMode", "classpath"};
        System.setProperty("HADOOP_USER_NAME", "admin");
        LauncherMain.main(sql);
    }


    public static void testRocSql() throws Exception{
        String[] sql = new String[]{"-mode", "local", "-sql", "/Users/roc/Documents/flink_sql/sql/simpleInsert.sql", "-name", "roc",
                "-localSqlPluginPath", "/Users/roc/workspace/git_code/flinkStreamSQL/sqlplugins",
                "-remoteSqlPluginPath", "/Users/roc/workspace/git_code/flinkStreamSQL/sqlplugins",
                "-flinkconf", "/Users/roc/Documents/flink_sql/flinkconf",
                "-confProp", "{\"sql.checkpoint.cleanup.mode\":\"false\",\"sql.checkpoint.interval\":10000,\"time.characteristic\":\"EventTime\"}",
                "-yarnconf", "/Users/roc/Documents/flink_sql/yarnconf",
                "-flinkJarPath", "/Users/roc/Documents/flink_sql/flinkJarPath", "-queue", "c", "-pluginLoadMode", "classpath"};
        System.setProperty("HADOOP_USER_NAME", "admin");
        LauncherMain.main(sql);
    }

    public static void testLbbSql() throws Exception{
        String[] sql = new String[]{"-mode", "local",
                "-sql", "/Users/roc/Documents/flink_sql/sql/simpleInsert.sql",
                "-name", "doublebin",
                "-localSqlPluginPath", "/Users/doublebin/work/private/flinkStreamSQL/plugins",
                "-remoteSqlPluginPath", "/Users/doublebin/work/private/flinkStreamSQL/plugins",
                "-flinkconf", "/Users/doublebin/software/flink/flink-1.11.3/conf",
                "-confProp", "{\"sql.checkpoint.cleanup.mode\":\"false\",\"sql.checkpoint.interval\":10000,\"time.characteristic\":\"EventTime\"}",
                "-yarnconf", "/Users/doublebin/software/flink/hadoop-conf",
                "-flinkJarPath", "/Users/doublebin/software/flink/flink-1.11.3/lib",
                "-queue", "c",
                "-pluginLoadMode", "classpath"};
        System.setProperty("HADOOP_USER_NAME", "admin");
        LauncherMain.main(sql);
    }

    public static void main(String[] args) throws Exception {
        testRocSql();
//        testShipfileMode();
//        testClasspathMode();
    }
}

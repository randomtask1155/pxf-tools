package io.pivotal.support.pxf.api.utilities;

/**
 * Created by danl on 3/19/15.
 *
 * Example
 *

 [gpadmin@hdm1 ~]$ /usr/java/default/bin/java -classpath PXFGetFragments.jar:`hadoop classpath` io.pivotal.support.pxf.api.utilities.GetFragments /tmp/file.txt
 Setting up request params
 creating fragmenter
 getting fragments
 15/03/19 15:43:07 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
 15/03/19 15:43:09 WARN hdfs.BlockReaderLocal: The short-circuit local reads feature cannot be used because libhadoop cannot be loaded.
 15/03/19 15:43:10 INFO hdfs.DFSClient: Created HDFS_DELEGATION_TOKEN token 5454 for gpadmin on ha-hdfs:elephant
 15/03/19 15:43:10 INFO security.TokenCache: Got dt for hdfs://elephant; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:elephant, Ident: (HDFS_DELEGATION_TOKEN token 5454 for gpadmin)
 15/03/19 15:43:10 INFO mapred.FileInputFormat: Total input paths to process : 1
 dumping fragments
 {"PXFFragments":[{"userData":null,"replicas":["172.28.17.239","172.28.17.240","172.28.17.238"],"metadata":"rO0ABXcQAAAAAAAAAAAAAAAAAAABdHVyABNbTGphdmEubGFuZy5TdHJpbmc7rdJW5+kde0cCAAB4cAAAAAN0AA5oZHcyLnBoZC5sb2NhbHQADmhkdzMucGhkLmxvY2FsdAAOaGR3MS5waGQubG9jYWw=","sourceName":"/tmp/file.txt","index":0}]}


 JARS required for building
 /var/gphd/pxf/pxf-service/webapps/pxf/WEB-INF/lib/pxf-api-2.3.0.0.jar
 /usr/lib/gphd/pxf/pxf-hdfs.jar
 /usr/lib/gphd/pxf/pxf-service.jar
 /usr/lib/gphd/pxf/pxf-plugin.jar
 */

import com.pivotal.pxf.plugins.hdfs.HdfsDataFragmenter;
import com.pivotal.pxf.api.utilities.InputData;
import com.pivotal.pxf.api.Fragment;
import com.pivotal.pxf.service.FragmentsResponseFormatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GetFragments {
    public static void main(String[] args) throws IOException {

        if ( args.length < 1 ) {
            System.out.println("\nBuild for PHD 2.1.0.0")
            System.out.println("\nUsage:\n\njava -classpath GetFragments.jar:`hadoop classpath` io.pivotal.support.pxf.api.utilities.GetFragments /tmp/file.txt\n");
            System.exit(1);
        }

        System.out.println("Setting up request params ");
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("X-GP-FORMAT","TEXT");
        paramsMap.put("X-GP-DATA-DIR", args[0]);

        InputData pxfParms = new InputData();
        pxfParms.setDataSource(args[0]);

        System.out.println("creating fragmenter");
        HdfsDataFragmenter hdfrag = new HdfsDataFragmenter(pxfParms);
        try {
            System.out.println("getting fragments");
            List<Fragment> frags = hdfrag.getFragments();
            System.out.println("dumping fragments");
            String format = FragmentsResponseFormatter.formatResponseString(frags, args[0]);
            System.out.println(format);

        } catch (Exception e) {
            System.out.println("Error Getting fragments: " + e.toString());
            e.printStackTrace();
        }

    }
}
